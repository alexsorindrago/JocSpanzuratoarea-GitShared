package com.company;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        // scanner introducere date
        Scanner input = new Scanner((System.in));
        // introducere
        System.out.println("Te rog introdu un nume.");
        String numeJucator;
        numeJucator = input.nextLine();
        System.out.println("Salut, " + numeJucator + "! Bine ai venit in joc :) ");
        System.out.println("Ghiceste cuvantul sau o sa fii spanzurat!");
        System.out.println("Grija! Poti gresi doar de 7 ori pana la spanzuratoare :(  Succes!");
        System.out.println();

        //am renuntat la variabila jocActiv, nu era necesar
        while (true){

            // array care contine constructia omuletului (spanzuratului)
            String[][] omulet = new String[3][3];
            for (int j = 0; j < omulet.length; j++) {
                for (int k = 0; k < omulet.length; k++) {
                    omulet[j][k] = " ";
                }

            }

            // array de string cuvinte si generator RANDOM din cuvintele date
            String[] cuvinte = {"ponei", "maimuta", "constanta", "cotropitor", "pasune", "armata"};
            int x = new Random().nextInt(cuvinte.length);

            // inlocuire litere cuvant RANDOM cu -
            String str = cuvinte[x];
            String toGuess = str.replaceAll("[a-zA-Z]", "-");
            StringBuilder sb = new StringBuilder(toGuess);


            //counter nr de ghiciri
            int count = 0;

            System.out.println("Introdu o litera ca sa incepem:");
            System.out.println(toGuess);
            //literele deja introduse
            StringBuilder letters=new StringBuilder();
            do {
                char c;
                //in do-while introducem pana introduce un singur
                //caracter, care e litera si care nu a mai fost
                //introdus in trecut;
                //in felul asta nu termini jocul introducand aceeasi litera de 7 ori
                //si nici nu mai faci verificarile urmatoare daca introduce o litera
                //pe care cuvantul o are
                do {
                    String in = input.nextLine();
                    if(!Pattern.matches("[a-z]",in.trim())){
                        System.out.println("Input incorect!Introduceti o litera!");
                        continue;
                    }
                    c=in.charAt(0);
                    if(letters.indexOf(c+"")==-1){
                        letters.append(c);
                        break;
                    }
                    System.out.println("Ati mai introdus litera!");
                }while (true);

                boolean flag = false;
                for (int i = 0; i < str.length(); i++) {
                    if (c == str.charAt(i)) {
                        flag = true;
                        sb.setCharAt(i, c);
                    }
                }
                //am scos aici ca sa afiseze o singura data mesajul in loc sa afisez in for
                if(flag && sb.toString().contains("-")){
                    System.out.println("Bravo, ai ghicit litera "+c+" :) Incearca alta litera:");
                } else if(flag){
                    System.out.println("Ai castigat!");
                    break;
                }
                if (!flag) {
                    count++;
                    if (count == 1) omulet[0][1] = "o";
                    if (count == 2) omulet[1][1] = "|";
                    if (count == 3) omulet[1][0] = "/";
                    if (count == 4) omulet[1][2] = "\\";
                    if (count == 5) omulet[2][0] = "/";
                    if (count == 6) omulet[2][2] = "\\";
                    if (count > 6) {
                        System.out.println("Nu ati ghicit si ati fost spanzurat, cuvantul era: " + str);
                        break;
                    }

                }

                System.out.println(sb);
                for (String[] line:omulet) {
                    for (String o:line) {
                        System.out.print(o);
                    }
                    System.out.println();

                }
            } while (sb.toString().contains("-"));

            // cod reinitializare joc dupa primul loop

            System.out.print("Vrei sa mai incerci o data? ");
            String reluareJoc;
            //introducem pana se introduce da/nu
            do {
                System.out.println("Da/Nu?");
                reluareJoc = input.nextLine();
            } while(!(reluareJoc.equalsIgnoreCase("da") ||
                    reluareJoc.equalsIgnoreCase("nu")));
            if(reluareJoc.equalsIgnoreCase("da")) {
                System.out.println("Bine ai revenit in joc, " + numeJucator + "!");
                System.out.println("Ai grija, poti gresi doar de 7 ori pana spanzuri omul :(  Succes!");
                System.out.println();


            }
            else if(reluareJoc.equalsIgnoreCase("nu")){
                System.out.println("Ne mai jucam si data viitoare :) ");
                break;
            }

        }
    }

}

