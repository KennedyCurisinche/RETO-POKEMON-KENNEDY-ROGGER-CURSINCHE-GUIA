package pokemon.kennedy.cursinche.guia.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pokemon.kennedy.cursinche.guia.app.dto.ClienteDTO;
import pokemon.kennedy.cursinche.guia.app.service.PokemonService;

@Controller
@RequestMapping("/pokemon")
public class PokemonController {

    @Autowired
    private PokemonService service;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("dataPokemon", service.data());
        return "home";
    }

}
