package com.thinuka.SwagHouse_backend.auth.controller;

import com.thinuka.SwagHouse_backend.auth.config.JWTTokenHelper;
import com.thinuka.SwagHouse_backend.auth.dto.LoginRequest;
import com.thinuka.SwagHouse_backend.auth.dto.RegistrationRequest;
import com.thinuka.SwagHouse_backend.auth.dto.RegistrationResponse;
import com.thinuka.SwagHouse_backend.auth.dto.UserToken;
import com.thinuka.SwagHouse_backend.auth.entities.User;
import com.thinuka.SwagHouse_backend.auth.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JWTTokenHelper jwtTokenHelper;

    @PostMapping("/login")
    public ResponseEntity<UserToken> login(@RequestBody LoginRequest loginRequest) {
        try {
            // Authenticate user
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword())
            );

            if (authentication.isAuthenticated()) {
                Object principal = authentication.getPrincipal();

                // If your custom User implements UserDetails, casting is fine
                User user = (User) principal;

                if (!user.isEnabled()) {
                    return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
                }

                // Generate JWT
                String token = jwtTokenHelper.generateToken(user.getEmail());
                UserToken userToken = UserToken.builder().token(token).build();

                return new ResponseEntity<>(userToken, HttpStatus.OK);
            }
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/register")
    public ResponseEntity<RegistrationResponse> register(@RequestBody RegistrationRequest request) {
        RegistrationResponse registrationResponse = registrationService.createUser(request);

        return new ResponseEntity<>(
                registrationResponse,
                registrationResponse.getCode() == 200 ? HttpStatus.OK : HttpStatus.BAD_REQUEST
        );
    }

    @PostMapping("/verify")
    public ResponseEntity<?> verifyCode(@RequestBody Map<String, String> map) {
        String userName = map.get("userName");
        String code = map.get("code");

        User user = (User) userDetailsService.loadUserByUsername(userName);

        if (user != null && code != null && code.equals(user.getVerificationCode())) {
            registrationService.verifyUser(userName);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
