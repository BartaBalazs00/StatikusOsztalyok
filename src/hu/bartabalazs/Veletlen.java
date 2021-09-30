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

    private static List<String> vezetekNev = feltolt("files/veznev.txt");
    private static List<String> ferfiKerNevek = feltolt("files/ferfikernev.txt");
    private static List<String> egyesulet = feltolt("files/egyesulet.txt");
    private static List<String> esemenyTipus = feltolt("files/esemenytipus.txt");
    private static List<String> noiKernev = feltolt("files/noikernev.txt");
    private static List<String> sportag = feltolt("files/sportag.txt");
    private Veletlen() {}

    private static List<String> feltolt(String fajlnev){
        List<String> fajlSorai = new ArrayList<>();
        try {
            fajlSorai = Files.readAllLines(Paths.get(fajlnev));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return fajlSorai;
    }

}