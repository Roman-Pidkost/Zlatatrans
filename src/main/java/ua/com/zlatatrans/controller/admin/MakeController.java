package ua.com.zlatatrans.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import ua.com.zlatatrans.entity.Make;
import ua.com.zlatatrans.service.MakeService;
import ua.com.zlatatrans.validator.MakeValidator;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/make")
@SessionAttributes("make")
public class MakeController {

    @Autowired
    private MakeService makeService;

    @InitBinder("make")
    public void init(WebDataBinder binder) {
        binder.setValidator(new MakeValidator(makeService));
    }

    @ModelAttribute("make")
    public Make getForm() {
        return new Make();
    }

    @GetMapping
    public String show(Model model) {
        model.addAttribute("makes", makeService.findAll());
        return "admin-make";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id) {
        makeService.delete(id);
        return "redirect:/admin/make";
    }

    @GetMapping("update/{id}")
    public String update(@PathVariable int id, Model model) {
        model.addAttribute("make", makeService.findOne(id));
        return show(model);
    }

    @PostMapping
    public String save(@ModelAttribute("make") @Valid Make make, BindingResult bindingResult, SessionStatus status, Model model) {
        if (bindingResult.hasErrors()) {
            return show(model);
        }
        makeService.save(make);
        status.setComplete();
        return "redirect:/admin/make";
    }
}