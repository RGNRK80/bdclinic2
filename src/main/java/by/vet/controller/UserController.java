package by.vet.controller;


import by.vet.entity.Pet;
import by.vet.entity.User;
import by.vet.service.impl.ServiceImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@Data
@RequestMapping("/api/rezult")

public class UserController {

    long idUser;
    private final ServiceImpl serviceImp;

   @GetMapping("/users")
   public List<User> getAllUsers() {return serviceImp.getAllUsers();}
   @GetMapping("/pets")
   public List<Pet> getAllPets() {return serviceImp.getAllPets();}
   @GetMapping("/hello")
   public String sayHello() {return "hello";}

   //новый user
    @GetMapping("/user")
        @Autowired
        public User addUser (User user) throws SQLException {
        user.setTel("3755000000004");
        user.setMail("JS4@gmail.com");
        System.out.println("to serv" + user);
        return serviceImp.addUser(user);
    }

    @GetMapping("/{id}")   //  как этим пользоваться?
    public String readId(@PathVariable long id){
       return String.valueOf(id);
    }



//    @GetMapping("/user")
//  public User getUserById() {return serviceImp.g}








}
