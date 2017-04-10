package ua.com.zlatatrans.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ua.com.zlatatrans.entity.Model;
import ua.com.zlatatrans.service.ModelService;

public class ModelValidator implements Validator {

    private final ModelService modelService;

    public ModelValidator(ModelService modelService) {
        this.modelService = modelService;
    }

    public boolean supports(Class<?> aClass) {
        return aClass.equals(Model.class);
    }

    public void validate(Object o, Errors errors) {
        Model model = (Model) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Не може бути пустим");
        Model find = modelService.findOne(model.getName());
        if (find != null) {
            if (find.getName().equals(model.getName()))
                errors.rejectValue("name", "", "Вже існує");
        }
    }
}
