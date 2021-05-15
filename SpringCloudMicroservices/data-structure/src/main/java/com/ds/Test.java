package com.ds;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Test {

    public static String toCpp(String javaVariable) {
        String word = javaVariable.charAt(0) + "";
        List<String> words = new ArrayList<>();
        for (int i = 1; i < javaVariable.length(); i++) {
            if (Character.isUpperCase(javaVariable.charAt(i))) {
                words.add(word.trim().toLowerCase());
                word = "" + javaVariable.charAt(i);
            } else {
                word = word + javaVariable.charAt(i);
            }
        }
        words.add(word.trim().toLowerCase());
        String cppVariable = words.stream().collect(Collectors.joining("_"));
        return cppVariable;
    }

    public  static void countLetters(String str){

        TreeMap<Character,Integer> counts=new TreeMap<>();

        for(int i=0;i<str.length();i++){
            Character chr=str.charAt(i);
            if(Character.isLetter(chr)){
                if(counts.containsKey(chr)){
                    int currCount = counts.get(chr);
                    currCount++;
                    counts.put(chr,currCount);
                }else{
                    counts.put(chr,1);
                }
            }
        }

        System.out.println(counts);
    }

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println(toCpp("helloWorld"));
        System.out.println("========================================");
        System.out.println(toCpp("helloWorld"));

        countLetters("aabbcdeab");
    }
}
