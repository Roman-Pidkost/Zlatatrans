package ua.com.zlatatrans.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import ua.com.zlatatrans.dto.filter.SimpleFilter;
import ua.com.zlatatrans.entity.FuelType;
import ua.com.zlatatrans.service.FuelTypeService;
import ua.com.zlatatrans.validator.FuelTypeValidator;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/fuelType")
@SessionAttributes("fuelType")
public class FuelTypeController {

    @Autowired
    private FuelTypeService fuelTypeService;

    @InitBinder("fuelType")
    public void init(WebDataBinder binder) {
        binder.setValidator(new FuelTypeValidator(fuelTypeService));
    }

    @ModelAttribute("fuelType")
    public FuelType getForm() {
        return new FuelType();
    }

    @GetMapping
    public String show(Model model) {
        model.addAttribute("fuelTypes", fuelTypeService.findAll());
        return "admin-fuelType";
    }

    @GetMapping("update/{id}")
    public String update(@PathVariable int id, Model model) {
        model.addAttribute("fuelType", fuelTypeService.findOne(id));
        return show(model);
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
        fuelTypeService.delete(id);
        return "redirect:/admin/fuelType";
    }

    @PostMapping
    public String save(@ModelAttribute("fuelType") @Valid FuelType fuelType, BindingResult bindingResult, SessionStatus status, Model model) {
        if (bindingResult.hasErrors()) {
            return show(model);
        }
        fuelTypeService.save(fuelType);
        status.setComplete();
        return "redirect:/admin/fuelType";
    }

}
