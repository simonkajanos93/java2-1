package hu.kerteszekfoldje.web.repository;

import hu.kerteszekfoldje.web.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}