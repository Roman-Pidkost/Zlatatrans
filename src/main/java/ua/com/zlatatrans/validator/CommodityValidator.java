package ua.com.zlatatrans.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ua.com.zlatatrans.dto.form.CommodityForm;

import java.util.regex.Pattern;

public class CommodityValidator implements Validator {

    private static final Pattern REG = Pattern.compile("\\d{1,9}");
    private static final Pattern REG_D = Pattern.compile("(\\d{1,9}(.|,)\\d{0,9})|(\\d{1,9})");

    public boolean supports(Class<?> aClass) {
        return aClass.equals(CommodityForm.class);
    }

    public void validate(Object o, Errors errors) {
        CommodityForm form = (CommodityForm) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Поле не може бути пустим");
        if (!REG_D.matcher(form.getCapacity()).matches()) {
            errors.rejectValue("capacity", "", "Лише числа");
        }
        if (!REG.matcher(form.getKilometrage()).matches()) {
            errors.rejectValue("kilometrage", "", "Лише числа");
        }
        if (!REG.matcher(form.getPower()).matches()) {
            errors.rejectValue("power", "", "Лише числа");
        }
        if (!REG.matcher(form.getYear()).matches()) {
            errors.rejectValue("year", "", "Лише числа");
        }
        if (!REG.matcher(form.getDoorsCount()).matches()) {
            errors.rejectValue("doorsCount", "", "Лише числа");
        }
        if (!REG.matcher(form.getSeatsCount()).matches()) {
            errors.rejectValue("seatsCount", "", "Лише числа");
        }
        if (!REG.matcher(form.getPrice()).matches()) {
            errors.rejectValue("price", "", "Лише числа");
        }
    }
}
