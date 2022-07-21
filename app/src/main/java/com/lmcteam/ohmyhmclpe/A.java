package com.lmcteam.ohmyhmclpe;

public class A {
    public static String a(String d){
        char[] c = d.toCharArray();
        for (char s:
             c) {
            if(s!='\0'){
                s+=1;
                s|=1;
            }
        }
        return  String.valueOf(c);
    }
}
