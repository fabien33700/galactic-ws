package imie.tp.galactic.ws.controllers;

import imie.tp.galactic.ws.core.InMemoryModel;
import imie.tp.galactic.ws.exceptions.UnauthorizedException;
import imie.tp.galactic.ws.model.general.Player;
import imie.tp.galactic.ws.resources.LoginRequest;
import imie.tp.galactic.ws.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Set;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    private LoginService loginService;
    private InMemoryModel inMemoryModel;



    @Autowired
    public LoginController(LoginService loginService, InMemoryModel inMemoryModel) {
        this.loginService = loginService;
        this.inMemoryModel = inMemoryModel;

    }

    @PostMapping
    public ResponseEntity connect(@RequestBody @Valid LoginRequest request) {

        String auth = loginService
                .authenticationAttempt(request.getPseudo(), request.getHashPass());

        return ResponseEntity
                .ok()
                .header(HttpHeaders.AUTHORIZATION, auth)
                .build();
    }
}
