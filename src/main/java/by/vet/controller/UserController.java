package by.vet.controller;


import by.vet.entity.User;
import by.vet.service.impl.ServiceImpl;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Data
@RequestMapping
public class UserController {
    private final ServiceImpl service;
    @GetMapping
    public List<User> readAll() {return service.getAllUsers();}

    @GetMapping("/hello")
    public String read() {return "hello";}
}
