package ua.com.zlatatrans.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import ua.com.zlatatrans.entity.BodyType;
import ua.com.zlatatrans.service.BodyTypeService;
import ua.com.zlatatrans.validator.BodyTypeValidator;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/bodyType")
@SessionAttributes("bodyType")
public class BodyTypeController {

    @Autowired
    private BodyTypeService bodyTypeService;

    @InitBinder("bodyType")
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(new BodyTypeValidator(bodyTypeService));
    }

    @ModelAttribute("bodyType")
    public BodyType getForm() {
        return new BodyType();
    }

    @GetMapping
    public String show(Model model) {
         model.addAttribute("bodyTypes", bodyTypeService.findAll());
        return "admin-bodyType";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id) {
        bodyTypeService.delete(id);
        return "redirect:/admin/bodyType";
    }

    @GetMapping("update/{id}")
    public String update(@PathVariable int id, Model model) {
        model.addAttribute("bodyType", bodyTypeService.findOne(id));
        return show(model);
    }

    @PostMapping
    public String save(@ModelAttribute("bodyType")  @Valid BodyType bodyType, BindingResult bindingResult, SessionStatus status, Model model) {
        if (bindingResult.hasErrors()) {
            return show(model);
        }
        bodyTypeService.save(bodyType);
        status.setComplete();
        return "redirect:/admin/bodyType";
    }
}
