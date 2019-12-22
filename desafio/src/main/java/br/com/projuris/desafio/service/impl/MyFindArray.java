package br.com.projuris.desafio.service.impl;

import br.com.projuris.desafio.service.FindArray;
import org.springframework.stereotype.Component;

@Component
public class MyFindArray implements FindArray {

    @Override
    public int findArray(int[] array, int[] subArray) {
        if (validateArraysLength(array, subArray)) {
            return -1;
        }
        int i,j;
        int a = -1;
        int b = array.length;
        int c = subArray.length;
        if(c>b){
            return -2;
        }
        boolean d = true;
        for (i=0; i<=b-c+1;i++) {
            int e=i;
            for (j=0;j<c;j++){
                if (array[e]!=subArray[j]) {
                    d = false;
                    break;
                }
                e++;
            }
            if(d) {
                a = i;
            }
            d=true;
        }
        return a;
    }

    private boolean validateArraysLength(int[] array, int[] subArray) {
        return subArray.length > array.length;
    }
}
