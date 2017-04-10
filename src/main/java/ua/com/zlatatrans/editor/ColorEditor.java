package ua.com.zlatatrans.editor;


import ua.com.zlatatrans.entity.Color;
import ua.com.zlatatrans.service.ColorService;

import java.beans.PropertyEditorSupport;

public class ColorEditor extends PropertyEditorSupport {

    final private ColorService colorService;

    public ColorEditor(ColorService colorService) {
        this.colorService = colorService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Color color = colorService.findOne(Integer.valueOf(text));
        setValue(color);
    }
}
