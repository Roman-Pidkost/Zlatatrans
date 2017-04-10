package ua.com.zlatatrans.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ua.com.zlatatrans.entity.Color;
import ua.com.zlatatrans.service.ColorService;

public class ColorValidator implements Validator {

    private final ColorService colorService;

    public ColorValidator(ColorService colorService) {
        this.colorService = colorService;
    }

    public boolean supports(Class<?> aClass) {
        return aClass.equals(Color.class);
    }

    public void validate(Object o, Errors errors) {
        Color color = (Color) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Cannot be empty");
        Color find = colorService.findOne(color.getName());
        if (find != null) {
            if (find.getName().equals(color.getName()))
                errors.rejectValue("name", "", "Вже існує");
        }
    }
}
