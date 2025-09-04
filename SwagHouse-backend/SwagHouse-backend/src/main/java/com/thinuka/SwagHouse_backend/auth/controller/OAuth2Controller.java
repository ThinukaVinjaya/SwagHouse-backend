package com.thinuka.SwagHouse_backend.auth.controller;

import com.thinuka.SwagHouse_backend.auth.config.JWTTokenHelper;
import com.thinuka.SwagHouse_backend.auth.entities.User;
import com.thinuka.SwagHouse_backend.auth.services.OAuth2Service;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:3000")
@RequestMapping("/oauth2")
public class OAuth2Controller {

    @Autowired
    private OAuth2Service oAuth2Service;

    @Autowired
    private JWTTokenHelper jwtTokenHelper;

    @GetMapping("/success")
    public void callbackOAuth2(@AuthenticationPrincipal OAuth2User oAuth2User,
                               HttpServletResponse response) throws IOException {

        if (oAuth2User == null) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "OAuth2 user not found");
            return;
        }

        String userName = oAuth2User.getAttribute("email");
        if (userName == null) {
            userName = oAuth2User.getAttribute("sub"); // fallback to Google ID
        }

        User user = oAuth2Service.getUser(userName);
        if (user == null) {
            user = oAuth2Service.createUser(oAuth2User, "google");
        }

        String token = jwtTokenHelper.generateToken(user.getUsername());

        // Redirect to frontend route (make sure React has this route)
        response.sendRedirect("http://localhost:3000/success?token=" + token);
    }
}

