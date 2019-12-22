package br.com.projuris.desafio.service.impl;

import br.com.projuris.desafio.service.FindCharacter;
import org.springframework.stereotype.Service;

@Service
public class MyFindChar implements FindCharacter {

    @Override
    public char findChar(String word) {
        char[] charArray = word.toCharArray();
        char letter = '"';
        int cont= 0;
        for (char test : charArray) {
            for (char c : charArray) {
                if (test == c) {//Note que esta comparacao trata maiusculas e minusculas como diferentes.
                    cont++;
                }
            }
            if (cont == 1) {
                letter = test;
                break;
            }
            cont = 0;
        }
        return letter;
    }
}
