package by.zmeyka.SecurityAPI.controller;

import by.zmeyka.SecurityAPI.model.Person;
import by.zmeyka.SecurityAPI.service.PeopleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {
    private PeopleService peopleService;
     @Autowired
    public AuthController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/registration")
    public String registration(@ModelAttribute("person") Person person){
        return "registration";
    }

    @PostMapping("/registration")
    public String makeRegistration(@ModelAttribute("person") Person person){

         peopleService.add(person);
        return "redirect:/auth/login";
    }
}
