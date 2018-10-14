
import java.util.Random;
import java.util.Scanner;

public class NumberGuess {
    public static void main(String[] args) {
        zgadnijLiczbe();
    }

    static void zgadnijLiczbe(){
        int randNumber = new Random().nextInt(101);
        Scanner scan = new Scanner(System.in);
        int number = -1;
        System.out.println("Zgadnij liczbę");

        while (number != randNumber){
            number = getNumber(scan);
            if (number > randNumber){
                System.out.println("Za dużo");
            } else {
                System.out.println("Za mało");
            }
            System.out.println("Zgadnij liczbę");
            scan.close();
        }


    }

    static int getNumber(Scanner scan){
        while(!scan.hasNextInt()){
            System.out.println("To nie jest liczba");
            System.out.println("Zgadnij liczbę");
            scan.next();
        }
        return scan.nextInt();
    }

}
