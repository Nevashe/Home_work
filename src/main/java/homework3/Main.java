package homework3;


import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            Random random = new Random();
        String[] words = {"apple", "orange", "lemon", "banana", "apricot",
                        "avocado", "broccoli", "carrot", "cherry", "garlic",
                        "grape", "melon", "leak", "kiwi", "mango",
                        "mushroom", "nut", "olive", "pea", "peanut",
                        "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String sekretword = words[ random.nextInt(24)];
        char [] answer = new char[15];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = '#';
            }
        System.out.println( "Try to guess the word");

        String attempt = "";
        if (scanner.hasNext()) {
            attempt = scanner.next();
        }
        scanner.nextLine();
        do {
            if (attempt.equals(sekretword)) {
                System.out.println("You win! This word is " + sekretword);
                break;
            } else {
                int n = Math.min(sekretword.length(), attempt.length() );
                for (int i = 0; i < n; i++) {
                    if (attempt.charAt(i) == sekretword.charAt(i)) {
                        answer[i] = (sekretword.charAt(i));
                    } else if (answer[i] != '#' ){
                    } else  {
                        answer[i] = '#';
                    }
                }
                System.out.println("You couldn't:(");
                System.out.println("These letters are in the right place : ");
                System.out.println(answer);
                System.out.println("Try further:)");
                attempt = scanner.next();
            }
        } while (attempt != sekretword);
        scanner.close();
    }

}
