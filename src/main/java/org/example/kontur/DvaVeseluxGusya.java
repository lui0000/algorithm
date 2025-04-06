package org.example.kontur;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DvaVeseluxGusya {

    public double calculateTheProbabilityOfWinning () {

        int deckOfCards = 52;
        int currentDeckOfCards = deckOfCards;
        int countLetters = 0;
        int countNumbers = 0;

        Scanner scanner = new Scanner(System.in);

        int r1 = scanner.nextInt();
        int s1 = scanner.nextInt();
        int r2 = scanner.nextInt();
        int s2 = scanner.nextInt();
        scanner.nextLine();

        List<String> grayGoosePapers = new ArrayList<>();
        for (int i = 0; i < r1 + s1; i++) {
            grayGoosePapers.add(scanner.nextLine());
        }
        System.out.println(grayGoosePapers);
        String last = grayGoosePapers.get(grayGoosePapers.size() - 1);

        List<String> whiteGoosePapers = new ArrayList<>();
        for (int i = 0; i < r2 + s2; i++) {
            whiteGoosePapers.add(scanner.nextLine());
        }
        System.out.println(whiteGoosePapers);

        // удаление карт из колоды
        for (int i = 0; i < r1; i++) {
            // проверим были ли выбранные карты среди удаленных

            int letters = 0;
            if (grayGoosePapers.get(i).length() == 1) {
                if (grayGoosePapers.get(i).equals("C") || grayGoosePapers.get(i).equals("D")
                        || grayGoosePapers.get(i).equals("H") || grayGoosePapers.get(i).equals("S")) {
                    currentDeckOfCards -= 13;
                } else {
                    currentDeckOfCards -= 4;
                }
            } else {
                String paper = grayGoosePapers.get(i);
                letters = 0;
                int digits = 0;
                int specialLetter = 0;

                for (int j = 0; j < paper.length(); j++) {
                    char ch = paper.charAt(j);
                    if (Character.isLetter(ch)) {
                        if (ch == 'C' || ch == 'D' || ch == 'H' || ch == 'S') {
                            specialLetter++;
                        } else {
                            letters++;
                        }

                    } else if (Character.isDigit(ch)) {
                        digits++;
                    }
                    if (specialLetter > 0) {
                        currentDeckOfCards -= 13 * specialLetter;
                    } else if (letters > 0 && digits == 0) {
                        currentDeckOfCards -= 4;
                    } else if (digits > 0 && letters < 0) {
                        currentDeckOfCards -= 4;
                    }
                }

                if (letters > 0 && digits > 0) {
                    currentDeckOfCards -= letters * digits;
                }
            }


        }



        return 0.0;

    }

    public static void main(String[] args) {
//        DvaVeseluxGusya dvaVeseluxGusya = new DvaVeseluxGusya();
//        dvaVeseluxGusya.calculateTheProbabilityOfWinning();
    }
}
