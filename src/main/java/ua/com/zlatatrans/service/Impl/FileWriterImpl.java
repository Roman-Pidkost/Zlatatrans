package ua.com.zlatatrans.service.Impl;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ua.com.zlatatrans.entity.Commodity;
import ua.com.zlatatrans.service.FileWriter;
import ua.com.zlatatrans.util.ImageResizer;
import ua.com.zlatatrans.util.WaterMarkPainter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Service
public class FileWriterImpl implements FileWriter {

	public int write(int id, List<MultipartFile> images, Commodity commodity) {
		int sequenceNumber = 1;


		if (images != null && !images.isEmpty()) {
			File pathToHome = new File(System.getProperty("catalina.home"));
            long folderId = (id + 1) * 33;
            boolean isCleared = false;
			File pathToFolder = new File(pathToHome, "images" + File.separator + "auto_" + String.valueOf(folderId));
            pathToFolder.mkdirs();
			for (MultipartFile multipartFile : images) {
				try {
					BufferedImage old = ImageIO.read(multipartFile.getInputStream());
					if (old == null) return 0;

					if (pathToFolder.exists() && !isCleared) {
						FileUtils.cleanDirectory(pathToFolder);
                        isCleared = true;
					}
					String fileName =
									commodity.getModel().getMake().getName() + "_"
									+ commodity.getModel().getName() + "_"
									+ commodity.getYear() + "_" + String.format("%.2f", commodity.getCapacity()).replace(",", ".") + "_"
									+ String.valueOf(sequenceNumber) + ".jpg";
					File pathToFile = new File(pathToFolder, fileName);
					ImageResizer resizer = new ImageResizer(old);
					BufferedImage present = resizer.createOffset();

					ImageIO.write(present, "jpg", pathToFile);
					sequenceNumber++;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return sequenceNumber - 1;
	}

	public Commodity setMainImage(int id, int number, Commodity commodity) {
		if (commodity.getImagesCount() > 1) {
			File pathToHome = new File(System.getProperty("catalina.home"));
			long folderId = (id + 1) * 33;
			File pathToFolder = new File(pathToHome, "images" + File.separator + "auto_" + String.valueOf(folderId));
			if (pathToFolder.exists()) {
				String fileName =
						commodity.getModel().getMake().getName() + "_"
								+ commodity.getModel().getName() + "_"
								+ commodity.getYear() + "_" + String.format("%.2f", commodity.getCapacity()).replace(",", ".") + "_";
				File image = new File(pathToFolder, fileName + String.valueOf(number) + ".jpg");
				File newName = new File(pathToFolder, fileName + "0.jpg");
				image.renameTo(newName);
				for (int i = number; i < commodity.getImagesCount(); i++) {
					image = new File(pathToFolder, fileName + (i + 1) + ".jpg");
					newName = new File(pathToFolder, fileName + i + ".jpg");
					image.renameTo(newName);
				}
				commodity.setVersion(commodity.getVersion() + 1);
				commodity.setIsSetMainImage(true);
				return commodity;
			}
		}
		return null;
	}

	public void writeZip(List<MultipartFile> images, String position) {

		File outPath = new File(System.getProperty("catalina.home") + File.separator + "watermarking");

		try {
			BufferedInputStream origin = null;

			if (outPath.exists()) {
				FileUtils.cleanDirectory(outPath);
			}
			outPath.mkdirs();

			WaterMarkPainter painter;
			for (MultipartFile multipartFile : images) {
				BufferedImage image = ImageIO.read(multipartFile.getInputStream());
				painter = new WaterMarkPainter(image);
				image = painter.addRectAndText(position);
				File pathToFile = new File(outPath, multipartFile.getName() + String.valueOf(Math.random()).replace(".", "0")+ ".jpg");
				ImageIO.write(image, "jpg", pathToFile);
			}

			File destination = new File(System.getProperty("catalina.home") + File.separator + "archive");
			if (destination.exists()) {
				FileUtils.cleanDirectory(destination);
			}
			destination.mkdirs();

			FileOutputStream dest = new
					FileOutputStream(destination + File.separator + "watermarkered.zip");

			ZipOutputStream out = new ZipOutputStream(new
					BufferedOutputStream(dest));

			out.setMethod(ZipOutputStream.DEFLATED);
			byte data[] = new byte[2048];
			String files[] = outPath.list();
			for (int i=0; i < files.length; i++) {
				FileInputStream fi = new
						FileInputStream(outPath + File.separator + files[i]);
				origin = new
						BufferedInputStream(fi, 2048);
				ZipEntry entry = new ZipEntry(files[i]);
				out.putNextEntry(entry);
				int count;
				while((count = origin.read(data, 0,
						2048)) != -1) {
					out.write(data, 0, count);
				}
				origin.close();
			}
			out.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
