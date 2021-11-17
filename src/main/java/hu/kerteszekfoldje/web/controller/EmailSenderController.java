package hu.kerteszekfoldje.web.controller;

import hu.kerteszekfoldje.web.model.Email;
import hu.kerteszekfoldje.web.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/email")
public class EmailSenderController {
    @Autowired
    private EmailService emailService;

    @GetMapping(path = "")
    public String main(Model model) {
        model.addAttribute("mail", new Email());
        return "email/add";
    }

    @PostMapping(path = "/")
    public String sendMail(@ModelAttribute Email mail, Model model) {
        model.addAttribute("mailSubmitted", mail);
        emailService.restSendEmail(mail);
        return "email/add";
    }

    @GetMapping(path = "/list")
    public String listMails(Model model) {
        model.addAttribute("mails", emailService.fetchAllEmail());
        return "email/list";
    }
}