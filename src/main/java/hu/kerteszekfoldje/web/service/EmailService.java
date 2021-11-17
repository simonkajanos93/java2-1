package hu.kerteszekfoldje.web.service;

import hu.kerteszekfoldje.web.model.Email;
import hu.kerteszekfoldje.web.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private EmailRepository emailRepository;

    public void restSendEmail(Email mail) {
        emailRepository.save(mail);
    }

    public Iterable<Email> fetchAllEmail() {
        return emailRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
    }
}
