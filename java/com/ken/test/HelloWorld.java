package com.ken.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class HelloWorld{
    public static void main(String[] args){
        System.out.println("你好");
        /*
        ArrayList<String> passwords = new ArrayList<>(){
            public String get(int n){return super.get(n).replaceAll(".", ",");}
        };
        */
        /*
        String[] words = new String[]{"Mary", "had", "a", "little", "lamb"};

        Pair<String> a = ArrayAlg.minmax(words);

        System.out.println(a.getFirst());
        System.out.println(a.getSecond());

        var ceo = new Manager();
        var cfo = new Manager();

        var managerBuddies = new Pair<Manager>(ceo, cfo);
        Pair rawBuddies = managerBuddies;
        rawBuddies.setFirst(new File("parent"));

        System.out.println("End");
        */

        try {
            CollectingResults.noVowels();
        } catch (IOException e) {
            
        }

    }
}

