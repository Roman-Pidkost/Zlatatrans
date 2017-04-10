package ua.com.zlatatrans.util;

import java.awt.*;
import java.awt.image.BufferedImage;

public class WaterMarkPainter {


    private Color rectangleColor;

    private Color fontColor;

    private BufferedImage image;

    private int width;

    private int height;

    private Graphics2D  graphics;

    private String pattern;

    private boolean isVerticalStrategy;

    private int fontSize;

    public WaterMarkPainter(BufferedImage image) {
        this();
        this.image = image;
        pattern = "zlatatrans.com.ua";
        graphics = image.createGraphics();
        height = image.getHeight();
        width = image.getWidth();
        isVerticalStrategy = height > width;
    }

    public WaterMarkPainter(BufferedImage image, String pattern) {
        this();
        this.image = image;
        setPattern(pattern);
        graphics = image.createGraphics();
        height = image.getHeight();
        width = image.getWidth();
        isVerticalStrategy = height > width;
    }

    public WaterMarkPainter(BufferedImage image, String pattern, Color rectangleColor, Color fontColor) {
        this.image = image;
        setPattern(pattern);
        this.rectangleColor = rectangleColor;
        this.fontColor = fontColor;
        graphics = image.createGraphics();
        height = image.getHeight();
        width = image.getWidth();
        isVerticalStrategy = height > width;
    }

    private WaterMarkPainter() {
//        rectangleColor = new Color(0, 0, 0, 130);
//        fontColor = new Color(255, 255, 255, 200);
        rectangleColor = new Color(255, 255, 255, 130);
        fontColor = new Color(0, 0, 0, 200);
    }

    public BufferedImage addRectAndText() {
        return addRectAndText("bottom");
    }

    public BufferedImage addRectAndText(String position) {
        drawRectangleAndText(position);
        return image;
    }

    public BufferedImage addImage(BufferedImage markImage) {
        drawWatermarkImage(markImage, "top-right");
        return image;
    }

    public BufferedImage addImage(BufferedImage markImage, String position) {
        drawWatermarkImage(markImage, position);
        return image;
    }

    private void drawRectangleAndText(String position) {
        if (fontSize == 0) fontSize = isVerticalStrategy ? (int)(width * 0.075) : (int)(height * 0.075);
        graphics.setFont(new Font("sans-serif", Font.PLAIN, fontSize));

        FontMetrics fontMetrics = graphics.getFontMetrics();
        int stringWidth = fontMetrics.stringWidth(pattern);
        int stringHeight = fontMetrics.getAscent();

        int rectangleHeight = (int)(stringHeight * 1.3);
        int rectangleWidth = (int)(stringWidth * 1.1);
        int rectangleRound = stringHeight / 4;

        int textHorizontalOffset;
        int textVerticalOffset;
        int rectHorizontalOffset;
        int rectVerticalOffset;

        String[] positions = position.split("-");
        String verticalPosition;
        String horizontalPosition;
        if (positions.length > 1) {
            verticalPosition = positions[0];
            horizontalPosition = positions[1];
        } else {
            verticalPosition = positions[0];
            horizontalPosition = "";
        }

        switch (verticalPosition){
            case "top":
                textVerticalOffset = (int)(stringHeight * 1.35);
                rectVerticalOffset = stringHeight / 3;
                break;
            case "center":
                textVerticalOffset = (height - (int)(stringHeight * 0.75)) / 2;
                rectVerticalOffset = height / 2 - rectangleHeight;
                break;
            default:
                textVerticalOffset = height - (int)(stringHeight / 2.7);
                rectVerticalOffset = textVerticalOffset - (int)(stringHeight * 1.1);
        }
        switch (horizontalPosition){
            case "left":
                textHorizontalOffset = stringWidth / 10;
                rectHorizontalOffset = textHorizontalOffset - (rectangleWidth - stringWidth) / 2 + 1;
                break;
            case "right":
                textHorizontalOffset = width - stringWidth / 10 - stringWidth;
                rectHorizontalOffset = textHorizontalOffset - (rectangleWidth - stringWidth) / 2;
                break;
            default:
                textHorizontalOffset = (width - stringWidth ) / 2;
                rectHorizontalOffset = (width - rectangleWidth) / 2;
        }

        graphics.setColor(rectangleColor);
        graphics.fillRoundRect(rectHorizontalOffset, rectVerticalOffset, rectangleWidth, rectangleHeight, rectangleRound, rectangleRound);
        graphics.setColor(fontColor);
        graphics.drawString(pattern, textHorizontalOffset, textVerticalOffset);
    }

    private void drawWatermarkImage(BufferedImage markImage, String position) {
        graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.85f));

        String[] positions = position.split("-");
        String verticalPosition;
        String horizontalPosition;
        if (positions.length > 1) {
            verticalPosition = positions[0];
            horizontalPosition = positions[1];
        } else {
            verticalPosition = positions[0];
            horizontalPosition = "center";
        }

        int verticalOffset;
        int horizontalOffset;

        switch (verticalPosition){
            case "center":
                verticalOffset = height / 2 - markImage.getHeight() / 2;
                break;
            case "bottom":
                verticalOffset = height - height / 30 - markImage.getHeight();
                break;
            default:
                verticalOffset = height / 30;
        }
        switch (horizontalPosition){
            case "left":
                horizontalOffset = height / 30;
                break;
            case "center":
                horizontalOffset = width / 2 - markImage.getWidth() / 2;
                break;
            default:
                horizontalOffset = width - height / 30 - markImage.getWidth();
        }
        graphics.drawImage(markImage, horizontalOffset, verticalOffset, markImage.getWidth(), markImage.getHeight(), null);
    }

    public Color getRectangleColor() {
        return rectangleColor;
    }

    public void setRectangleColor(Color rectangleColor) {
        this.rectangleColor = rectangleColor;
    }

    public Color getFontColor() {
        return fontColor;
    }

    public void setFontColor(Color fontColor) {
        this.fontColor = fontColor;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {

        if (pattern.length() < 12){
            fontSize = isVerticalStrategy ? (int)(width * 0.075) : (int)(height * 0.075);
        } else if (pattern.length() > 21 && pattern.length() < 31) {
            fontSize = isVerticalStrategy ? (int)(width * 0.06) : (int)(height * 0.06);
        } else if (pattern.length() > 31 && pattern.length() < 38) {
            fontSize = isVerticalStrategy ? (int)(width * 0.05) : (int)(height * 0.05);
        } else {
            fontSize = isVerticalStrategy ? (int)(width * 0.05) : (int)(height * 0.05);
            this.pattern = pattern.substring(0, 36) + "...";
            return;
        }
        this.pattern = pattern;
    }
}
