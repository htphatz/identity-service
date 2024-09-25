package com.htphatz.identity_service.controller;

import com.htphatz.identity_service.dto.request.UserDTO;
import com.htphatz.identity_service.dto.response.APIResponse;
import com.htphatz.identity_service.entity.User;
import com.htphatz.identity_service.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDTO userDTO) {
        User newUser = userService.register(userDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new APIResponse<>(HttpStatus.OK.value(), "Register successfully", newUser));
    }
}
