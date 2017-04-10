package ua.com.zlatatrans.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ua.com.zlatatrans.entity.Transmission;
import ua.com.zlatatrans.service.TransmissionService;

public class TransmissionValidator implements Validator {

    private final TransmissionService transmissionService;

    public TransmissionValidator(TransmissionService transmissionService) {
        this.transmissionService = transmissionService;
    }

    public boolean supports(Class<?> aClass) {
        return aClass.equals(Transmission.class);
    }

    public void validate(Object o, Errors errors) {
        Transmission transmission = (Transmission) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Не може бути пустим");
        Transmission find = transmissionService.findOne(transmission.getName());
        if (find != null) {
            if (find.getName().equals(transmission.getName()))
                errors.rejectValue("name", "", "Вже існує");
        }
    }
}
