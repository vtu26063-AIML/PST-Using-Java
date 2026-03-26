import java.util.*;

public class Task10 {

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            int x = sc.nextInt();
            int y = sc.nextInt();

            System.out.println(x / y);

        } catch (InputMismatchException e) {
            System.out.println(e.getClass().getName());
        } catch (ArithmeticException e) {
            System.out.println(e);
        }
    }
}