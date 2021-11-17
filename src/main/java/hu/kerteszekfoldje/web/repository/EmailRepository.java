package hu.kerteszekfoldje.web.repository;

import hu.kerteszekfoldje.web.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Integer> {
}
