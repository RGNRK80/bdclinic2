package by.vet.controller;


import by.vet.entity.Pet;
import by.vet.entity.User;
import by.vet.service.impl.ServiceImpl;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Data
@RequestMapping("/api/rezult")

public class UserController {

    long idUser;
    private final ServiceImpl serviceImp;

   @GetMapping("/users")
   public List<User> readAllUsers() {return serviceImp.getAllUsers();}
   @GetMapping("/pets")
   public List<Pet> readAllPets() {return serviceImp.getAllPets();}
   @GetMapping("/hello")
   public String read() {return "hello";}

    @GetMapping("/{id}")
    public String readId(@PathVariable long id){
       return String.valueOf(id);
    }
//    @GetMapping("/user")
//  public User getUserById() {return serviceImp.g}








}
