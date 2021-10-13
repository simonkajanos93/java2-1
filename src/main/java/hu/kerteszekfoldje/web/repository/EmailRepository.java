package hu.kerteszekfoldje.web.repository;

import hu.kerteszekfoldje.web.model.Email;
import org.springframework.data.repository.CrudRepository;

public interface EmailRepository extends CrudRepository<Email, Integer> {
}
