package com.example.servingwebcontent;

import com.example.servingwebcontent.domain.Person;
import com.example.servingwebcontent.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Map<String, Object> model) {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping("/")
    public String main(Map<String, Object> model) {
        Iterable<Person> users = personRepository.findAll();
        model.put("users", users);
        return "main";
    }

    @PostMapping("/")
    public String addUser(@RequestParam String name, @RequestParam String email, Map<String, Object> model) {
        Person person = new Person(name, email);
        personRepository.save(person);
        Iterable<Person> personIterable = personRepository.findAll();
        model.put("persons", personIterable);
        return "main";
    }
}