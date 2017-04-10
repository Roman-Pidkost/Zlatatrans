package ua.com.zlatatrans.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import ua.com.zlatatrans.entity.Color;
import ua.com.zlatatrans.service.ColorService;
import ua.com.zlatatrans.validator.ColorValidator;

import javax.validation.Valid;

@Service
@RequestMapping("/admin/color")
@SessionAttributes("color")
public class ColorController {

    @Autowired
    ColorService colorService;

    @ModelAttribute("color")
    public Color getForm() {
        return new Color();
    }

    @InitBinder("color")
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(new ColorValidator(colorService));
    }

    @GetMapping
    public String show(Model model) {
        model.addAttribute("colors", colorService.findAll());
        return "admin-color";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id) {
        colorService.delete(id);
        return "redirect:/admin/color";
    }

    @GetMapping("update/{id}")
    public String update(@PathVariable int id, Model model) {
        model.addAttribute("color", colorService.findOne(id));
        return show(model);
    }

    @PostMapping
    public String save(@ModelAttribute("color") @Valid Color color, BindingResult bindingResult, SessionStatus status, Model model) {
        if (bindingResult.hasErrors()) {
            return show(model);
        }
        colorService.save(color);
        status.setComplete();
        return "redirect:/admin/color";
    }
}
