package org.example.redis_start.servlet;

import org.example.redis_start.pojo.User;
import org.example.redis_start.service.UserSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserSessionServlet {
    @Autowired
    private UserSessionService userSessionService;

    @RequestMapping("/get")
    public String getSession(String userId) {
        System.out.println(userSessionService.getSession(userId));
        return userSessionService.getSession(userId);
    }
    @GetMapping("/save")
    public void saveSession(
            @RequestParam String userId,
            @RequestParam String token
    ) {
        userSessionService.saveSession(userId, token);
    }
    @RequestMapping("/delete")
    public void deleteSession(String userId) {
        userSessionService.deleteSession(userId);
    }
    @PostMapping("/saveUser")
    public String saveUser(@RequestBody User user) {
        userSessionService.saveUser(user);
        userSessionService.saveSession(user.getUserId(), "token_" + user.getUserId());
        return "User saved!";
    }

    @GetMapping("/getUser/{userId}")
    public User getUser(@PathVariable String userId) {

        return userSessionService.getUser(userId);
    }

    @DeleteMapping("/deleteUser/{userId}")
    public String deleteUser(@PathVariable String userId) {
        userSessionService.deleteUser(userId);
        userSessionService.deleteSession(userId);
        return "User deleted!";
    }
}
