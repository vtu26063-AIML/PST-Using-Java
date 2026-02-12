import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter how many numbers: ");
        int n = sc.nextInt();

        int number;
        int max = 0;
        int min = 0;
        int sum = 0;

        if (n <= 0) {
            System.out.println("Invalid input");
            return;
        }

        System.out.println("Enter the numbers:");

        for (int i = 1; i <= n; i++) {

            number = sc.nextInt();

            if (i == 1) {
                max = number;
                min = number;
            }

            if (number > max) {
                max = number;
            }

            if (number < min) {
                min = number;
            }

            sum = sum + number;
        }

        double average = (double) sum / n;

        System.out.println("\n----- Result -----");
        System.out.println("Maximum  : " + max);
        System.out.println("Minimum  : " + min);
        System.out.printf("Average  : %.2f", average);

        sc.close();
    }
}

output:
Enter how many numbers: 5
Enter 5 numbers:
10
20
5
8
15
