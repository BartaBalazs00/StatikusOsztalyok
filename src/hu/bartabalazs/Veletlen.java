package hu.bartabalazs;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class Veletlen {
    private static Random random = new Random();

    private Veletlen() {}

    private List<String> feltolt(String fajlnev){
        List<String> fajlSorai = new ArrayList<>();
        try {
            fajlSorai = Files.readAllLines(Paths.get(fajlnev));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return fajlSorai;
    }
}