package com.lmcteam.ohmyhmclpe;

public class A {
    public static String a(String d){
        char[] result = d.toCharArray();
for (int i = 0; i < result.length; i++) {
			if(result[i]!='\0'){
				result[i]+=1;
				result[i]|=1;
			}
		}
        return  String.valueOf(result);
    }
}
