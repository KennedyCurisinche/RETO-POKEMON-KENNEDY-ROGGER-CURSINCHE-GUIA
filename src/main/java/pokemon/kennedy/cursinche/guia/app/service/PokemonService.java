package pokemon.kennedy.cursinche.guia.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pokemon.kennedy.cursinche.guia.app.client.WebClientPokemon;
import pokemon.kennedy.cursinche.guia.app.dto.ClienteDTO;

import java.time.Duration;

@Service
public class PokemonService {

    @Autowired
    private WebClientPokemon webClientPokemon;

    public ClienteDTO data() {

        return webClientPokemon.getClientPokemon().block();

    }

}
