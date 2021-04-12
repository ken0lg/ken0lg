package com.ken.test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.*;

public class CollectingResults {
    
    public static Stream<String> noVowels() throws IOException ,InvalidPathException{
        var contents = "aaddd ddeee bbbb ccc eddds adsev";

        List<String> wordList = List.of(contents.split("\\PL+"));
        Stream<String> words = wordList.stream();
        return words.map(s -> s.replaceAll("[aeiouAEIOU]", ""));
    }
    
}
