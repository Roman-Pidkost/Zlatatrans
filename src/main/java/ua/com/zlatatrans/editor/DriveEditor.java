package ua.com.zlatatrans.editor;

import ua.com.zlatatrans.entity.Drive;
import ua.com.zlatatrans.service.DriveService;

import java.beans.PropertyEditorSupport;

public class DriveEditor extends PropertyEditorSupport {

    private final DriveService driveService;

    public DriveEditor(DriveService driveService) {
        this.driveService = driveService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Drive drive = driveService.findOne(Integer.valueOf(text));
        setValue(drive);
    }
}
