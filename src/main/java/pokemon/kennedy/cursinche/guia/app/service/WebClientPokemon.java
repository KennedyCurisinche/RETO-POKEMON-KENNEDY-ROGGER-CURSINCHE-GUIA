package pokemon.kennedy.cursinche.guia.app.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import pokemon.kennedy.cursinche.guia.app.dto.ClienteDTO;
import reactor.core.publisher.Mono;

@Service
public class WebClientPokemon {
	
	private final WebClient webClient;
	
	public WebClientPokemon(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.baseUrl("https://pokeapi.co/").build();
	}
	
	public Mono<ClienteDTO> getClientPokemon() {
		return this.webClient.get().uri("/api/v2/pokemon-species")
						.retrieve().bodyToMono(ClienteDTO.class);
	}

}
