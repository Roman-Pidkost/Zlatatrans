package ua.com.zlatatrans.mail;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class MailService {

    private ApplicationContext context = new GenericXmlApplicationContext(new ClassPathResource("mail.xml"));

    private MailSender mailSender = context.getBean("mailSender", JavaMailSender.class);
    private SimpleMailMessage template = context.getBean("templateMessage", SimpleMailMessage.class);

    public void sendMail(MailOrder order) {
        SimpleMailMessage message = new SimpleMailMessage(template);
        message.setText("Марка: " + order.getMake() + "\n"
                + "Модель: " + order.getModel() + "\n"
                + "Рік: " + order.getYear() + "\n"
                + "Основні характаристики: " + order.getMainOptions() + "\n"
                + "Додаткове: " + order.getOtherOptions() + "\n"
                + "Контакти: " + order.getContacts());
        try {
            mailSender.send(message);
        } catch (MailException mailException) {
            mailException.printStackTrace();
        }
    }
}
