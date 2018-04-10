package com.example.sportson.sportsonbeta;

import java.util.Random;

/**
 * Created by Rainer on 09/04/2018.
 */

public class codeGenerate {
    public String GenerateC(int len){
        Random rn = new Random();
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "abcdefghijklmnopqrstuvwxyz"
                + "0123456789";
        int s = chars.length();
        String str = "";
        for(int i = 0; i<len; i++){
            int r = rn.nextInt(s);
            str = str + chars.charAt(r);
        }
        return str;
    }
}
