package ua.com.zlatatrans.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ua.com.zlatatrans.entity.Make;
import ua.com.zlatatrans.service.MakeService;

public class MakeValidator implements Validator {

    private final MakeService makeService;

    public MakeValidator(MakeService makeService) {
        this.makeService = makeService;
    }

    public boolean supports(Class<?> aClass) {
        return aClass.equals(Make.class);
    }

    public void validate(Object o, Errors errors) {
        Make make = (Make) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Не може бути пустим");
        Make find = makeService.findOne(make.getName());
        if (find != null) {
            if (find.getName().equals(make.getName()))
                errors.rejectValue("name", "", "Вже існує");
        }
    }
}
