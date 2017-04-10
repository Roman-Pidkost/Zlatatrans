package ua.com.zlatatrans.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import ua.com.zlatatrans.entity.Transmission;
import ua.com.zlatatrans.service.TransmissionService;
import ua.com.zlatatrans.validator.TransmissionValidator;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/transmission")
@SessionAttributes("transmission")
public class TransmissionController {

    @Autowired
    private TransmissionService transmissionService;

    @InitBinder("transmission")
    public void init(WebDataBinder binder) {
        binder.setValidator(new TransmissionValidator(transmissionService));
    }

    @ModelAttribute("transmission")
    public Transmission getForm() {
        return new Transmission();
    }

    @GetMapping
    public String show(Model model) {
        model.addAttribute("transmissions", transmissionService.findAll());
        return "admin-transmission";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id) {
        transmissionService.delete(id);
        return "redirect:/admin/transmission" ;
    }

    @GetMapping("update/{id}")
    public String update(@PathVariable int id, Model model) {
        model.addAttribute("transmission", transmissionService.findOne(id));
        return show(model);
    }

    @PostMapping
    public String save(@ModelAttribute("transmission") @Valid Transmission transmission, BindingResult bindingResult, SessionStatus status, Model model) {
        if (bindingResult.hasErrors()) {
            return show(model);
        }
        transmissionService.save(transmission);
        status.setComplete();
        return "redirect:/admin/transmission";
    }
}
