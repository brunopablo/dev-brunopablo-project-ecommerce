package dev.bruno.ecommerce.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.bruno.ecommerce.controller.dto.CreateOrUpdateUserRequest;
import dev.bruno.ecommerce.service.UserService;

@RestController
@RequestMapping("/ecommerce")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Long> createUser(
        @RequestBody CreateOrUpdateUserRequest createOrUpdateUserRequest) {
        
        var userId =userService.createUser(createOrUpdateUserRequest);

        return ResponseEntity.ok(userId);
    }
}
