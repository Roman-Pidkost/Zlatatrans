package ua.com.zlatatrans.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import ua.com.zlatatrans.dto.form.WaterMarkForm;
import ua.com.zlatatrans.service.FileWriter;

import java.util.List;

@Controller
@RequestMapping("/admin/waterMark")
@SessionAttributes("waterMark")
public class WaterMarkController {

    @Autowired
    FileWriter fileWriter;

    @ModelAttribute("waterMark")
    public WaterMarkForm getForm() {
        return new WaterMarkForm();
    }

    @GetMapping
    public String show() {
        return "admin-waterMark";
    }

    @PostMapping
    public String save(@ModelAttribute("waterMark") WaterMarkForm form, SessionStatus status) {
        List<MultipartFile> images = form.getImages();
        fileWriter.writeZip(images, form.getPosition());
        status.setComplete();
        return "redirect:/admin/waterMark";
    }
}
