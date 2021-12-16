package com.libraryproject.librarysystem.RESTAndroidControllers;


import com.libraryproject.librarysystem.domain.Users;
import com.libraryproject.librarysystem.repositories.UsersRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserRESTController {

    @Autowired
    private UsersRepository usersRepository;

    @PostMapping(value = "/rest/login")
    public @ResponseBody String login(@RequestParam String userName, String password) {
        Users user = usersRepository.findAll().stream().filter(u -> u.getUserName().equals(userName)).filter(u -> u.getPassword().equals(password)).findFirst().orElse(null);
        //System.out.println(user.getUserID());
        if(user == null) {
            return "Wrong login";
        } else {
            return String.valueOf(user.getUserID());
        }
    }

    @GetMapping(value = "/rest/getUser/{id}")
    public @ResponseBody String getUser(@PathVariable(name = "id") int id) {
        return usersRepository.getById(id).toString();
    }

    @PutMapping(value = "/rest/updateUser/{id}")
    public @ResponseBody String updateUser(@PathVariable(name = "id")int id, @RequestParam String email, String password, String phone, String userFullName, String userName) {
        Users user = usersRepository.getById(id);
        user.setEmail(email);
        user.setPassword(password);
        user.setUserFullName(userFullName);
        user.setPhone(phone);
        user.setUserName(userName);
        usersRepository.save(user);
        return "User updated";
    }

    @DeleteMapping(value = "/rest/deleteUser/{id}")
    public @ResponseBody String deleteUser(@PathVariable(name = "id") int id) {
        usersRepository.deleteById(id);
        return "User deleted";
    }

}
