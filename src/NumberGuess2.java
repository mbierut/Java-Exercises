import java.util.Scanner;

public class NumberGuess2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Pomyśl liczbę od 0 do 1000, a ja ją zgadnę w max 10 próbach");
        int min = 0;
        int max = 1000;
        int counter = 0;
        boolean result = false;

        while (!result && counter<10){
            int guess = ((max - min)/2) + min;
            System.out.println("Zgaduję: " + guess);
            String option = scan.nextLine();
            counter++;

            switch (option){
                case "zgadłeś":
                    result = true;
                    System.out.println("Wygrałem!");
                    break;
                case "za dużo":
                    max = guess;
                    break;
                case "za mało":
                    min = guess;
                    break;
                    default:
                        counter--;
                        System.out.println("Dozwolone wartości to ");
            }

        }
        scan.close();
        System.out.println("Koniec gry");

    }
}
