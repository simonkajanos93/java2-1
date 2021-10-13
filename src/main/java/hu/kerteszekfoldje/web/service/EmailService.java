package hu.kerteszekfoldje.web.service;

import hu.kerteszekfoldje.web.model.Email;
import hu.kerteszekfoldje.web.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
public class EmailService {
    @Autowired
    private EmailRepository emailRepository;

    public void restSendEmail() {
        Email mail = new Email();
        mail.setMessage("Teszt üzenet");
        mail.setTarget("kovacs@adat.hu");
        emailRepository.save(mail);
    }

    public Iterable<Email> fetchAllEmail() {
        return emailRepository.findAll();
    }

    /*@GetMapping(path = "/add")
    public @ResponseBody
    String addNewUser() {
        Email n = new Email();
        n.setMessage("Teszt üzenet");
        n.setTarget("kovacs@adat.hu");
        emailRepository.save(n);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Email> getAllEmails() {
        return emailRepository.findAll();
    }*/
}
