package JavaCore.Base.Lesson3;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Random random = new Random();
        int numOfWord = random.nextInt(words.length);
        String word = words[numOfWord];
        System.out.println("Ваша задача - угадать слово. После каждой попытки я покажу вам буквы, которые вы угадали.");
        while (true) {
            System.out.println("Введите маленькими буквами слово на английском языке");
            String inString = scanner.nextLine();
            if (word.matches(inString)) {
                System.out.println("Слово угадано!");
                break;
            }
            System.out.println("Вы угадали следующие буквы (#) - не угаданная буква");
            int lenToCompare = Math.min(word.length(), inString.length());
            for (int i = 0; i < lenToCompare; i++) {
                if (word.charAt(i) == inString.charAt(i)) {
                    System.out.print(word.charAt(i));
                } else {
                    System.out.print("#");
                }
            }
            for (int i = 0; i < 15 - lenToCompare; i++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }
}

