package ua.com.zlatatrans.editor;

import ua.com.zlatatrans.entity.Model;
import ua.com.zlatatrans.service.ModelService;

import java.beans.PropertyEditorSupport;

public class ModelEditor extends PropertyEditorSupport {

    private final ModelService modelService;

    public ModelEditor(ModelService modelService) {
        this.modelService = modelService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Model model = modelService.findOne(Integer.valueOf(text));
        setValue(model);
    }
}
