import java.util.Random;
import java.util.Scanner;

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


        // boolean pentru JOC ACTIV in WHILE (LOOP MARE)
        boolean jocActiv = true;

        while (jocActiv=true){

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

            do {
                char c = input.nextLine().charAt(0);
                boolean flag = false;
                for (int i = 0; i < str.length(); i++) {
                    if (c == str.charAt(i)) {
                        flag = true;
                        sb.setCharAt(i, c);
                        System.out.println("Bravo, ai ghicit litera "+c+" :) Incearca alta litera:");
                    }

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
                for (int j = 0; j < omulet.length; j++) {
                    for (int k = 0; k < omulet.length; k++) {
                        System.out.print(omulet[j][k]);
                    }
                    System.out.println();

                }
            } while (sb.toString().contains("-"));
            System.out.println("Ati gresit de " + count + " ori.");

            // cod reinitializare joc dupa primul loop

            System.out.println("Vrei sa mai incerci o data? Tasteaza Da sau Nu:");

            String reluareJoc= input.nextLine();
            if(reluareJoc.equalsIgnoreCase("da")) {
                System.out.println("Bine ai revenit in joc, " + numeJucator + "!");
                System.out.println("Ai grija, poti gresi doar de 7 ori pana spanzuri omul :(  Succes!");
                System.out.println();
                jocActiv = true;


            }
            else if(reluareJoc.equalsIgnoreCase("nu")){
                jocActiv=false;
                System.out.println("Ne mai jucam si data viitoare :) ");

                break;
            }

        }

    }

}

