package br.com.projuris.desafio.controller;

import br.com.projuris.desafio.service.FindArray;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("find-array")
public class MyFindArrayController {

    private FindArray findArray;

    public MyFindArrayController (FindArray findArray) {
        this.findArray = findArray;
    }

    @RequestMapping(value = "/position", method = RequestMethod.GET)
    public int getPosition(@RequestParam int[] array, @RequestParam int[] subArray) {
        return findArray.findArray(array, subArray);
    }
}