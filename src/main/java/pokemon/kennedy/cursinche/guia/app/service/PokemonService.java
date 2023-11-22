package pokemon.kennedy.cursinche.guia.app.service;

import java.time.Duration;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pokemon.kennedy.cursinche.guia.app.dto.ClienteDTO;
import pokemon.kennedy.cursinche.guia.app.dto.PokemonDTO;

@Service
public class PokemonService {

	@Autowired
	private WebClientPokemon webClientPokemon;

	public List<PokemonDTO> listar() {

		ClienteDTO client = webClientPokemon.getClientPokemon()
				.delayElement(Duration.ofSeconds(2))
				.block();

		return client.getResults();

	}

}
