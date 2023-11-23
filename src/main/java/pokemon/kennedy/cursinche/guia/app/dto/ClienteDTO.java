package pokemon.kennedy.cursinche.guia.app.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ClienteDTO {

    private Integer count;
    private String next;
    private String previous;
    private List<PokemonDTO> results;

}
