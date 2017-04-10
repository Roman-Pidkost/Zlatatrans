package ua.com.zlatatrans.editor;

import ua.com.zlatatrans.entity.BodyType;
import ua.com.zlatatrans.service.BodyTypeService;

import java.beans.PropertyEditorSupport;

public class BodyTypeEditor extends PropertyEditorSupport {

    private final BodyTypeService bodyTypeService;

    public BodyTypeEditor(BodyTypeService bodyTypeService) {
        this.bodyTypeService = bodyTypeService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        BodyType bodyType = bodyTypeService.findOne(Integer.valueOf(text));
        setValue(bodyType);
    }
}
