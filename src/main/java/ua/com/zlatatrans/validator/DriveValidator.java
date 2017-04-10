package ua.com.zlatatrans.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ua.com.zlatatrans.entity.Drive;
import ua.com.zlatatrans.service.DriveService;

public class DriveValidator implements Validator {

    private final DriveService driveService;

    public DriveValidator(DriveService driveService) {
        this.driveService = driveService;
    }

    public boolean supports(Class<?> aClass) {
        return aClass.equals(Drive.class);
    }

    public void validate(Object o, Errors errors) {
        Drive drive = (Drive) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Поле не може бути пустим");
        Drive find = driveService.findOne(drive.getName());
        if (find != null) {
            if (find.getName().equals(drive.getName()))
                errors.rejectValue("name", "", "Вже існує");
        }
    }
}
