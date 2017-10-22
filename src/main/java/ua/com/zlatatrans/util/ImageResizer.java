package ua.com.zlatatrans.util;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageResizer {
	
	private final static Color OFFSET_COLOR = new Color(255, 255, 255);
	
	private final static int RELATION_X = 4;
	private final static int RELATION_Y = 3;

	private final static int IMG_WIDTH = 1320;
	private final static int IMG_HEIGHT = 990;

	private final BufferedImage old;

	private final BufferedImage present;

	private final int oldX;
	private final int oldY;
	
	private final int newX;
	private final int newY;
	
	
	private boolean isCreateVerticalOffset;

	public ImageResizer(BufferedImage old) {
		this.old = old;
		oldX = old.getWidth();
		oldY = old.getHeight();

		isCreateVerticalOffset = (double)oldX / oldY < (double)RELATION_X / RELATION_Y;

		if (isCreateVerticalOffset) {
			newY = oldY;
			newX = oldY * RELATION_X / RELATION_Y;
		} else {
			newX = oldX;
			newY = oldX * RELATION_Y / RELATION_X;
		}
		present = new BufferedImage(newX, newY, old.getType());
	}
	
	public BufferedImage createOffset() {
		if (isCreateVerticalOffset) {
			addHorizontalOffset();
		} else {
			addVerticalOffset();
		}
		if (oldX > 863) {
			return resizeImageWithHint();
		}
		return present;
	}

	private void addHorizontalOffset() {
		int offset = (newX - oldX) / 2;
		for(int x = 0; x < newX; x++){
			for(int y = 0; y < newY; y++) {
				if (x <= offset) {
					present.setRGB(x, y, OFFSET_COLOR.getRGB());
				} else if (x <= oldX + offset - 1) {
					present.setRGB(x , y, old.getRGB(x - offset, y));
				} else {
					present.setRGB(x, y, OFFSET_COLOR.getRGB());
				}
			}
		}
	}

	private void addVerticalOffset() {
		int offset = (newY - oldY) / 2;
		for(int x = 0; x < newX; x++){
			for(int y = 0; y < newY; y++) {
				if (y <= offset) {
					present.setRGB(x, y, OFFSET_COLOR.getRGB());
				} else if (y <= oldY + offset - 1) {
					present.setRGB(x , y, old.getRGB(x, y - offset));
				} else {
					present.setRGB(x, y, OFFSET_COLOR.getRGB());
				}
			}
		}
	}

	private BufferedImage resizeImageWithHint(){
		BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, old.getType());
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(present, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
		g.dispose();
		g.setComposite(AlphaComposite.Src);
//		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
//				RenderingHints.VALUE_INTERPOLATION_BILINEAR);
//		g.setRenderingHint(RenderingHints.KEY_RENDERING,
//				RenderingHints.VALUE_RENDER_QUALITY);
//		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
//				RenderingHints.VALUE_ANTIALIAS_ON);
		return resizedImage;
	}
}
