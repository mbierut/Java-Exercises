import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class LOTTO {
    public static void main(String[] args) {
        lotto();

    }

    static void lotto() {
        Scanner scan = new Scanner(System.in);
        int[] chosen = new int[6];
        int counter = 0;
        int num;
        System.out.println("Proszę wybrać 6 liczb");
        while (counter < 6) {
            System.out.println("Podaj liczbę");
            num = getNumber(scan);
            if (num < 1 || num > 49) {
                System.out.println("Liczba z poza zakresu");
            } else if (contains(chosen, num)) {
                System.out.println("Liczba powtórzona");
            } else {
                chosen[counter] = num;
                counter++;
            }
        }

        Arrays.sort(chosen);
        int[] generated = generateNumbers();
        checkScore(generated, chosen);

    }

    static boolean contains(int[] tab, int n) {
        for (int elem : tab) {
            if (elem == n) {
                return true;
            }
        }
        return false;
    }


    static int[] generateNumbers() {
        Integer[] arr = new Integer[49];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
//        System.out.println(Arrays.toString(arr));
        Collections.shuffle(Arrays.asList(arr));
//        System.out.println(Arrays.toString(arr));
        int[] generated = new int[6];
        for (int i = 0; i < 6; i++) {
            generated[i] = arr[i];
        }
        return generated;

    }


    static int getNumber(Scanner scan) {
        while (!scan.hasNextInt()) {
            System.out.println("To nie jest liczba");
            scan.next();
        }
        return scan.nextInt();
    }

    static void checkScore(int[] generated, int[] chosen) {
        int score = 0;
        for (int elem : chosen) {
            if (contains(generated, elem)) {
                score++;
            }
        }
        switch (score) {
            case 3:
                System.out.println("Trafiłeś 3");
                break;
            case 4:
                System.out.println("Trafiłeś 4");
                break;
            case 5:
                System.out.println("Trafiłeś 5");
                break;
            case 6:
                System.out.println("Trafiłeś 6");
                break;
            default:
                System.out.println("Trafiłeś " + score + ", nic nie wygrałeś");
        }
    }


}
