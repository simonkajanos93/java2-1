package hu.kerteszekfoldje.web.controller;

import hu.kerteszekfoldje.web.model.User;
import hu.kerteszekfoldje.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/demo") // This means URL's start with /demo (after Application path)
public class MainController {
    @Autowired // This means to get the bean called userRepository
    private UserRepository userRepository;

    @GetMapping(path = "/add")
    public @ResponseBody
    String addNewUser() {
        User n = new User();
        n.setName("Kovács Antal");
        n.setEmail("kovacs@adat.hu");
        userRepository.save(n);
        n = new User();
        n.setName("Nagy Péter");
        n.setEmail("nagy@adat.hu");
        userRepository.save(n);
        n = new User();
        n.setName("Tóth Éva");
        n.setEmail("toth@adat.hu");
        userRepository.save(n);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<User> getAllUsers() {
// This returns a JSON or XML with the users
        return userRepository.findAll();
    }

    @GetMapping(path = "/teszt")
    public @ResponseBody
    String teszt() {
        String str = "Rekordok száma:" + userRepository.count();
        // Módosítsuk az ID=1-es rekordot.
        // findById eredménye: Optional: lásd: Lambda kifejezések, Stream
        User user = userRepository.findById(1).get();
        user.setName("Kovács János");
        userRepository.save(user);
        str += " Módosítva az ID=1";
        // Töröljük az ID=3-as rekordot.
        //userRepository.deleteById(3);
        str += " Törölve az ID=3";
        return str;
    }
}