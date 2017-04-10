package ua.com.zlatatrans.editor;

import ua.com.zlatatrans.entity.FuelType;
import ua.com.zlatatrans.service.FuelTypeService;

import java.beans.PropertyEditorSupport;

public class FuelTypeEditor extends PropertyEditorSupport {

    private final FuelTypeService fuelTypeService;

    public FuelTypeEditor(FuelTypeService fuelTypeService) {
        this.fuelTypeService = fuelTypeService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        FuelType fuelType = fuelTypeService.findOne(Integer.valueOf(text));
        setValue(fuelType);
    }
}
