package ua.com.zlatatrans.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import ua.com.zlatatrans.entity.Drive;
import ua.com.zlatatrans.service.DriveService;
import ua.com.zlatatrans.validator.DriveValidator;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/drive")
@SessionAttributes("drive")
public class DriveController {

    @Autowired
    private DriveService driveService;

    @InitBinder("drive")
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(new DriveValidator(driveService));
    }

    @ModelAttribute("drive")
    public Drive getForm() {
        return new Drive();
    }

    @GetMapping
    public String show(Model model) {
        model.addAttribute("drives", driveService.findAll());
        return "admin-drive";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id) {
        driveService.delete(id);
        return "redirect:/admin/drive";
    }

    @GetMapping("update/{id}")
    public String update(@PathVariable int id, Model model) {
        model.addAttribute("drive", driveService.findOne(id));
        return show(model);
    }

    @PostMapping
    public String save(@ModelAttribute("drive") @Valid Drive drive, BindingResult bindingResult, SessionStatus status, Model model) {
        if (bindingResult.hasErrors()) {
            return show(model);
        }
        driveService.save(drive);
        status.setComplete();
        return "redirect:/admin/drive";
    }
}
