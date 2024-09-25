package com.htphatz.identity_service.controller;

import com.htphatz.identity_service.dto.request.AuthenticationRequest;
import com.htphatz.identity_service.dto.request.IntrospectRequest;
import com.htphatz.identity_service.dto.response.AuthenticationResponse;
import com.htphatz.identity_service.dto.response.IntrospectResponse;
import com.htphatz.identity_service.service.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) throws JOSEException {
        String token = authenticationService.login(request);
        return ResponseEntity.status(HttpStatus.OK).body(new AuthenticationResponse(HttpStatus.OK.value(), "Login successfully", token));
    }

    @PostMapping("/introspect")
    public ResponseEntity<IntrospectResponse> login(@RequestBody IntrospectRequest request) throws JOSEException, ParseException {
        boolean valid = authenticationService.introspect(request);
        return ResponseEntity.status(HttpStatus.OK).body(new IntrospectResponse(valid));
    }
}
