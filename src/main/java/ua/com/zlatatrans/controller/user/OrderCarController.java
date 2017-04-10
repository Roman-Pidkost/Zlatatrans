package ua.com.zlatatrans.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.zlatatrans.mail.MailOrder;
import ua.com.zlatatrans.mail.MailService;

@Controller
@RequestMapping("/orderCar")
public class OrderCarController {

    @ModelAttribute("order")
    public MailOrder getOrder() {
        return new MailOrder();
    }

    @GetMapping()
    public String show() {
        return "user-orderCar";
    }

    @PostMapping
    public String orderCar(@ModelAttribute("order") MailOrder order, Model model) {
        MailService mail = new MailService();
        mail.sendMail(order);
        model.addAttribute("sended", "Ми отримали ваше замовлення.");
        return "user-orderCar";
    }


}
