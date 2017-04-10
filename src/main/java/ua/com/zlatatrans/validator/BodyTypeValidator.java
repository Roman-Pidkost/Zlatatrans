package ua.com.zlatatrans.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ua.com.zlatatrans.entity.BodyType;
import ua.com.zlatatrans.service.BodyTypeService;

public class BodyTypeValidator implements Validator {

    private final BodyTypeService bodyTypeService;

    public BodyTypeValidator(BodyTypeService bodyTypeService) {
        this.bodyTypeService = bodyTypeService;
    }

    public boolean supports(Class<?> aClass) {
        return aClass.equals(BodyType.class);
    }

    public void validate(Object o, Errors errors) {
        BodyType bodyType = (BodyType) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Поле не може бути пустим");
        BodyType find = bodyTypeService.findOne(bodyType.getName());
        if (find != null) {
            if (find.getName().equals(bodyType.getName()))
                errors.rejectValue("name", "", "Вже існує");
        }
    }
}
