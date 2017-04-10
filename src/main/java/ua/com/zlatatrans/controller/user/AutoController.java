package ua.com.zlatatrans.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ua.com.zlatatrans.service.CommodityService;

@Controller
public class AutoController {

    @Autowired
    private CommodityService commodityService;

    @GetMapping("/auto/{subpath}/{id}")
    public String show(@PathVariable int id, Model model) {
        model.addAttribute("auto", commodityService.findOne(id));
        return "user-auto";
    }
}
