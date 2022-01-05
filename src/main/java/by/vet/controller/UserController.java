package by.vet.controller;
import by.vet.entity.Pet;
import by.vet.entity.User;
import by.vet.service.impl.ServiceImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@Data
@RequestMapping("/")

public class UserController {

    long idUser;
    private final ServiceImpl serviceImp;

    public UserController(ServiceImpl serviceImp) {
        this.serviceImp = serviceImp;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {return serviceImp.getAllUsers();}

   @GetMapping("/pets")
   public List<Pet> getAllPets() {return serviceImp.getAllPets();}

    @GetMapping("/hello")
    public String sayHello() {return "hello";}

    //мне пришла строка
    //я распарсил строку
    // создал нового юзера и поместил значение в него
    //передал юзера в метод adduser


   //новый user
  /*@PostMapping("/adduser")
        public User addUser (@RequestBody User user) throws SQLException {
        return serviceImp.addUser(user);
    } */

    @PostMapping("/adduser")
    public User addUser (@RequestParam String login_tel, String mail) throws SQLException {
        User user = new User();
        user.setLogin_tel(login_tel);
        user.setMail(mail);
        System.out.println(user);
       // return serviceImp.addUser(user);
        return user;
    }



  /*  @GetMapping("/addpet")
    @Autowired
    public Pet addPet (Pet pet) throws SQLException {
        pet.setName("FrankDUval");
        pet.setType("Parrot");
        pet.setSex("M");
        System.out.println("to serv" + pet);
        return serviceImp.addPet(pet);
    }
*/


    @GetMapping("/{id}")   //  как этим пользоваться?
        public User readId(@PathVariable long id){
        return serviceImp.getUserById(id);
        //return String.valueOf(id);
    }



}
