package ua.com.zlatatrans.service;

import org.springframework.web.multipart.MultipartFile;
import ua.com.zlatatrans.entity.Commodity;

import java.util.List;

public interface FileWriter {
	int write(int id, List<MultipartFile> images, Commodity commodity);
	Commodity setMainImage(int id, int number, Commodity commodity);

	void writeZip(List<MultipartFile> images, String position);
}
