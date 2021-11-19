package com.company;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> text = new HashMap<>();
        (new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8))).lines().flatMap(l -> Stream.of(l.split("[\\p{Punct}\\s]+"))).map(w -> w.toLowerCase()).forEach(w -> {
                    if(text.containsKey(w)) text.put(w, text.get(w) + 1);
                    else text.put(w, 1);
                });
        text.entrySet().stream().sorted((e1, e2) -> {
                    if(e1.getValue() == e2.getValue()) return e1.getKey().compareTo(e2.getKey());
                    else return e2.getValue().compareTo(e1.getValue());}).limit(10).forEach(e -> System.out.println(e.getKey()));
    }
}