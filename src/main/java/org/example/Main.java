package org.example;

import java.awt.desktop.SystemEventListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int option;
        int optionCurrency;
        do {
            System.out.println("-------- Welcome --------");
            System.out.println("      Choose an option:");
            System.out.println("      1. Currency Converter");
            System.out.println("      2. BMI Calculator");
            System.out.println("      3. Hangman Game");
            System.out.println("      4. Quit");
            System.out.println("--------------------------");
            option = keyboard.nextInt();

            switch (option) {
                case 1:
                    do {
                        CurrencyConverter currencyConverter = new CurrencyConverter();
                        System.out.println("--- Welcome to the Currency converter for brazilian real ---");
                        System.out.println("                  Choose an option:");
                        System.out.println("                  1. Dolar");
                        System.out.println("                  2. Euro");
                        System.out.println("                  3. Iene");
                        System.out.println("                  4. Won");
                        System.out.println("                  5. Peso");
                        System.out.println("                  6. Quit");
                        System.out.println("------------------------------------------------------------");
                        optionCurrency = keyboard.nextInt();
                        switch (optionCurrency) {
                            case 1:
                                System.out.println("Enter dollar value:");
                                float valueD = keyboard.nextFloat();
                                System.out.println("Value: " + currencyConverter.dolarConverter(valueD));
                                break;
                            case 2:
                                System.out.println("Enter euro value:");
                                float valueE = keyboard.nextFloat();
                                System.out.println("Value: " + currencyConverter.euroConverter(valueE));
                                break;
                            case 3:
                                System.out.println("Enter iene value:");
                                float valueI = keyboard.nextFloat();
                                System.out.println("Value: " + currencyConverter.ieneConverter(valueI));
                                break;
                            case 4:
                                System.out.println("Enter won value:");
                                float valueW = keyboard.nextFloat();
                                System.out.println("Value: " + currencyConverter.wonConverter(valueW));
                                break;
                            case 5:
                                System.out.println("Enter peso value:");
                                float valueP = keyboard.nextFloat();
                                System.out.println("Value: " + currencyConverter.pesoConverter(valueP));
                                break;
                            case 6:
                                System.out.println("Bye bye!!");
                                break;
                            default:
                                System.out.println("Invalid option!");
                                break;
                        }
                    } while (optionCurrency != 6);
                    break;
                case 2:
                    System.out.println("--- Welcome to the BMI Calculator ---");
                    IMCCalc imcCalc = new IMCCalc();
                    System.out.println("Enter the height:");
                    double height = keyboard.nextDouble();
                    System.out.println("Enter the weight:");
                    float weight = keyboard.nextFloat();
                    System.out.println("BMI = " + imcCalc.calcImc(height, weight));
                    break;
                case 3:
                    System.out.println("--- Welcome to the Hangman Game ---");
                    System.out.println("how many letters do you want to play? Accepted 3, 4 or 5 letters");

                    int letterSize = keyboard.nextInt();

                    WordLoader wordLoader = new WordLoader(letterSize);
                    String wordToPlay = wordLoader.load();
                    String letterUsed = "";

                    GuessWord guessWord = new GuessWord(wordToPlay);
                    int maxAttempts = 6;
                    int currentAttempts = 0;

                    List<Character> currentGuessedWord = new ArrayList<>();
                    for (int index = 0; index < wordToPlay.length(); index++) {
                        currentGuessedWord.add('_');
                    }
                    boolean win = false;
                    for (int attempt = 0; attempt < maxAttempts; attempt++) {
                        // todo desenhar o boneco
                        System.out.print("Letters used: " + letterUsed + "\nType a letter: ");
                        String letter = keyboard.next();
                        keyboard.nextLine();
                        letterUsed += " " + letter;
                        if (letter.length() > 1) {
                            System.out.println("Invalid letter: enter just one letter");
                        }
                        Integer[] positionsFound = guessWord.letterExist(letter.charAt(0));
                        List<Integer> positions = new ArrayList<>(List.of(positionsFound));
                        if (positions.isEmpty()) {
                            currentAttempts++;
                            System.out.println("You made a mistake now you have " + (maxAttempts - currentAttempts) + " attempts");
                            printForca(currentGuessedWord, wordToPlay, positions, letter.charAt(0));
                        } else {
                            System.out.println();
                            printForca(currentGuessedWord, wordToPlay, positions, letter.charAt(0));
                        }

                        if (currentGuessedWord.stream().noneMatch((a) -> a.equals('_'))) {
                            win = true;
                            System.out.println("You won!! Congratulations!!");
                            break;
                        }
                    }
                    if (!win) {
                        System.out.println("The word was: " + wordToPlay);
                        System.out.println("Game over!!");
                    }
                    break;
                case 4:
                    System.out.println("Bye bye!!");
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        } while (option != 4);
    }

    private static void printForca(List<Character> guessedLetters, String wordToPlay, List<Integer> positions, Character letter) {
        for (int index = 0; index < wordToPlay.length(); index++) {
            int finalIndex = index;
            boolean positionExists = positions.stream().anyMatch((pos) -> finalIndex == pos);
            if (positionExists) {
                guessedLetters.set(index, letter);
                System.out.print(letter);
            } else {
                System.out.print(guessedLetters.get(index));
            }
        }
        System.out.println();
    }
}