package ua.com.zlatatrans.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ua.com.zlatatrans.entity.FuelType;
import ua.com.zlatatrans.service.FuelTypeService;

public class FuelTypeValidator implements Validator {

    private final FuelTypeService fuelTypeService;

    public FuelTypeValidator(FuelTypeService fuelTypeService) {
        this.fuelTypeService = fuelTypeService;
    }

    public boolean supports(Class<?> aClass) {
        return aClass.equals(FuelType.class);
    }

    public void validate(Object o, Errors errors) {
        FuelType fuelType = (FuelType) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Не може бути пустим");
        FuelType find = fuelTypeService.findOne(fuelType.getName());
        if (find != null) {
            if (find.getName().equals(fuelType.getName()))
                errors.rejectValue("name", "", "Вже існує");
        }
    }
}
