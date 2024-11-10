package hu.petrik.szuperhosprojekt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Kepregeny {
    public static List<Szuperhos> szuperhosLista = new ArrayList<>();

    public static void szereplok(String fajlElérésiÚt) throws IOException {
        List<String> sorok = Files.readAllLines(Paths.get(fajlElérésiÚt));
        for (String sor : sorok) {
            String[] elemek = sor.split(" ");
            String tipus = elemek[0];
            int kutyuSzam = Integer.parseInt(elemek[1]);

            Szuperhos szuperhos;
            if ("Vasember".equalsIgnoreCase(tipus)) {
                szuperhos = new Vasember();
            } else if ("Batman".equalsIgnoreCase(tipus)) {
                szuperhos = new Batman();
            } else {
                continue;
            }

            for (int i = 0; i < kutyuSzam; i++) {
                if (szuperhos instanceof Milliardos) {
                    ((Milliardos) szuperhos).kutyutKeszit();
                }
            }
            szuperhosLista.add(szuperhos);
        }
    }

    public static void szuperhosok() {
        for (Szuperhos szuperhos : szuperhosLista) {
            System.out.println(szuperhos);
        }
    }
}
