package ua.com.zlatatrans.dto.form;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class WaterMarkForm {
    private List<MultipartFile> images;

    private String position;

    public List<MultipartFile> getImages() {
        return images;
    }

    public void setImages(List<MultipartFile> images) {
        this.images = images;
    }

    public String getPosition() {
        if (position == null)this.position = "";
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
