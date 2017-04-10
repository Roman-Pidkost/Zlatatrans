package ua.com.zlatatrans.editor;

import ua.com.zlatatrans.entity.Make;
import ua.com.zlatatrans.service.MakeService;

import java.beans.PropertyEditorSupport;

public class MakeEditor extends PropertyEditorSupport {

    private final MakeService makeService;

    public MakeEditor(MakeService makeService) {
        this.makeService = makeService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Make make = makeService.findOne(Integer.valueOf(text));
        setValue(make);
    }
}
