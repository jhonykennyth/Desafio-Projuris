package br.com.projuris.desafio.controller;

import br.com.projuris.desafio.service.FindCharacter;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("find-char")
public class FindCharacterController {

    private FindCharacter findCharacter;

    public FindCharacterController(FindCharacter findCharacter) {
        this.findCharacter = findCharacter;
    }

    @RequestMapping(value = "/letter/{word}", method = RequestMethod.GET)
    public char getChar(@PathVariable String word) {
        return findCharacter.findChar(word);
    }
}
