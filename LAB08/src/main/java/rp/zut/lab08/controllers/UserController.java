package rp.zut.lab08.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import rp.zut.lab08.domain.User;
import rp.zut.lab08.repositories.UserRepository;

import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/adduser")
    public String userForm(Model model) {
        model.addAttribute("user", new User());
        return "add-user";
    }
    @PostMapping("/adduser")
    public String userSubmit(@ModelAttribute @Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "add-user";
        }
        userRepository.save(user);
        model.addAttribute("user", user);
        return "user-info";
    }
    @GetMapping("/userinfo/{id}")
    public String getUserInfo(@PathVariable Long id, Model model) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
            return "user-info";
        } else {
            return "user-not-found";
        }
    }
}