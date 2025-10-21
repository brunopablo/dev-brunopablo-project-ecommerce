package dev.bruno.ecommerce.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.bruno.ecommerce.controller.dto.CreateOrUpdateUserRequest;
import dev.bruno.ecommerce.entity.UserEntity;
import dev.bruno.ecommerce.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Void> createUser(
            @RequestBody CreateOrUpdateUserRequest createOrUpdateUserRequest) {

        var userId = userService.createUser(createOrUpdateUserRequest);

        return ResponseEntity.created(URI.create("/ecommerce/" + userId)).build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserEntity> listUser(@PathVariable Long userId) {

        var response = userService.findUser(userId);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(
            @PathVariable Long userId) {

        userService.deleteUser(userId);

        return ResponseEntity.noContent().build();
    }
}
