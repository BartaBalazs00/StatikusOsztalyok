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

    private static List<String> vezetekNevek = feltolt("files/veznev.txt");
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


    public static int velEgesz(int min, int max){
        return random.nextInt(max-min+1)+min;
    }

    public static char velKarakter(char min, char max){
        return (char)velEgesz(min, max);
    }

    public static String velVezeteknev(){
        return vezetekNevek.get(random.nextInt(vezetekNevek.size()));
    }

    /*Véletlen keresztnevet generáló föggvény
    @param nem nem a név neme amit szeretnénk generálni : true-férfi, false-nő
    @return a generált keresztnév String*/
    public static String velKeresztnev(boolean nem){
        String keresztNev;
        if(nem){
            keresztNev = ferfiKerNevek.get(random.nextInt(ferfiKerNevek.size()));
        } else {
            keresztNev = noiKernev.get(random.nextInt(noiKernev.size()));
        }
        return keresztNev;
    }
    public static String  velKeresztnev(){
        return velKeresztnev(random.nextBoolean());
    }

    public static String velTeljesnev(boolean nem){
        return String.format("%s %s",velVezeteknev(), velKeresztnev(nem));
    }
    public static String velTeljesnev(){
        return String.format("%s %s",velVezeteknev(), velKeresztnev());
    }
}