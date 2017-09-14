package imie.tp.galactic.ws.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import imie.tp.galactic.ws.model.general.Player;
import imie.tp.galactic.ws.resources.PlayerCreationRequest;
import imie.tp.galactic.ws.services.PlayerService;
import imie.tp.galactic.ws.views.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Set;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    @JsonView(Views.Player.class)
    public Set<Player> getAllPlayers() {
        return playerService.findAll();
    }

    @PutMapping
    public ResponseEntity createPlayer(
            @RequestBody @Valid PlayerCreationRequest request)
    {
        long id = playerService.createPlayer(request);

        if (id > 0L) {
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(id)
                    .toUri();

            return ResponseEntity.created(location).build();
        } else {
            return ResponseEntity.noContent().build();
        }
    }

}
