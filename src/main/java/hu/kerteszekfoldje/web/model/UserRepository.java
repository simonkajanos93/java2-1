package hu.kerteszekfoldje.web.model;

import hu.kerteszekfoldje.web.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}