package com.geekbrains.webapp.core.controllers;


import com.geekbrains.webapp.api.dtos.AuthRequest;
import com.geekbrains.webapp.api.dtos.AuthResponse;
import com.geekbrains.webapp.api.exception.MarketError;
import com.geekbrains.webapp.core.models.User;
import com.geekbrains.webapp.core.services.UserService;
import com.geekbrains.webapp.core.utils.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final JwtTokenUtil jwtTokenUtil;
    private final AuthenticationManager authenticationManager;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/auth")
    public ResponseEntity<?> createAuthToken(@RequestBody AuthRequest authRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        } catch (BadCredentialsException ex) {
            return new ResponseEntity<>(new MarketError("Incorrect username or password"), HttpStatus.UNAUTHORIZED);
        }
        UserDetails userDetails = userService.loadUserByUsername(authRequest.getUsername());
        String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthResponse(token));
    }

    @PostMapping("/registration")
    public ResponseEntity<?> userRegistration (@RequestBody AuthRequest authRequest) {
        if (userService.findByUsername(authRequest.getUsername()).isPresent()) {
            return new ResponseEntity<>(new MarketError("Username already registered"), HttpStatus.BAD_REQUEST);
        }
        User newUser = new User();
        newUser.setUsername(authRequest.getUsername());
        String encodedPassword = bCryptPasswordEncoder.encode(authRequest.getPassword());
        newUser.setPassword(encodedPassword);
        userService.save(newUser);
        return ResponseEntity.ok("OK");
    }


}
