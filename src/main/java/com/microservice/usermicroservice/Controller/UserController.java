package com.microservice.usermicroservice.Controller;

import com.microservice.usermicroservice.Entity.User;
import com.microservice.usermicroservice.Service.UserService;
import com.microservice.usermicroservice.ValueObject.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public User saveUser(@RequestBody User user){
        log.info("Save method of UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") Long userId){
        log.info("Get users method of UserController");
        return userService.findUserById(userId);
    }

    @GetMapping("/userWithTasks/{id}")
    public ResponseTemplateVO getTasksbyUserId(@PathVariable("id") Long userId){
        log.info("Get users with tasks method of UserController");
        return userService.getTasksbyUserId(userId);
    }

    @PostMapping("/login")
    public Object login(@RequestBody User user){
        log.info("Save method of UserController");

        User authUser = userService.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
        System.out.println(authUser);
        if (Objects.nonNull(authUser)){
            return authUser;
        }
        else {
            return "error";
        }
    }




}
