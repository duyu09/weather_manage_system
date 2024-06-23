package site.duyu09.www.controller;

import org.springframework.web.bind.annotation.*;
import site.duyu09.www.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST})
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> request) {
        String phoneNum = request.get("phoneNum");
        String password = request.get("password");
        boolean success = userService.login(phoneNum, password);
        Map<String, Object> response = new HashMap<>();
        if (success) {
            response.put("status", 0);
            response.put("message", "Login Successful!");
        } else {
            response.put("status", 1);
            response.put("message", "Invalid phone number or password");
        }
        return response;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST})
    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody Map<String, String> request) {
        String phoneNum = request.get("phoneNum");
        String password = request.get("password");
        Map<String, Object> response = new HashMap<>();
        if(userService.register(phoneNum, password)) {
            response.put("status", 0);
        }
        else {
            response.put("status", 1);
        }
        return response;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST})
    @PostMapping("updatePassword")
    public Map<String, Object> updatePassword(@RequestBody Map<String, String> request) {
        String phoneNum = request.get("phoneNum");
        String oldPassword = request.get("oldPassword");
        String newPassword = request.get("newPassword");
        Map<String, Object> response = new HashMap<>();
        if (!userService.checkPassword(phoneNum, oldPassword))
        {
            response.put("status", 1);
            response.put("message", "Incorrect old password or user doesn't exist!");
            return response;
        }
        if (userService.updatePassword(phoneNum, newPassword)) {
            response.put("status", 0);
        }
        return response;
    }
}