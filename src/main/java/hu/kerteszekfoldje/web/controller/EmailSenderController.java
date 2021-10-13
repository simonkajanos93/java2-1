package hu.kerteszekfoldje.web.controller;

import hu.kerteszekfoldje.web.model.Email;
import hu.kerteszekfoldje.web.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/email")
public class EmailSenderController {
    @Autowired
    private EmailService emailService;

    @GetMapping(path = "/")
    public String main() {
        return "email";
    }


    @GetMapping(path = "/add")
    public @ResponseBody
    String sendEmail() {
        emailService.restSendEmail();
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Email> getEmails() {
        return emailService.fetchAllEmail();
    }
}