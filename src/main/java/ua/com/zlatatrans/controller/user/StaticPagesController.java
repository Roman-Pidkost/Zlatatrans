package ua.com.zlatatrans.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaticPagesController {

    @GetMapping("/contacts")
    public String contacts() {
        return "user-contacts";
    }

    @GetMapping("/howToBuy")
    public String howToBy() {
        return "user-howToBuy";
    }

}
