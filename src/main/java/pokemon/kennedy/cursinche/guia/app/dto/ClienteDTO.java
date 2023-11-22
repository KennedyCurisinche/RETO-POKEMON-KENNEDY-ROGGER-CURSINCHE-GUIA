package pokemon.kennedy.cursinche.guia.app.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClienteDTO {
	
	private List<PokemonDTO> results;
	
}
