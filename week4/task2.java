import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();
            System.out.println(isLapindrome(s) ? "YES" : "NO");
        }

        sc.close();
    }

    private static boolean isLapindrome(String s) {
        int n = s.length();
        int mid = n / 2;

        String firstHalf;
        String secondHalf;

        if (n % 2 == 0) {
            firstHalf = s.substring(0, mid);
            secondHalf = s.substring(mid);
        } else {
            firstHalf = s.substring(0, mid);
            secondHalf = s.substring(mid + 1);
        }

        int[] freq = new int[26];

        // Count frequency of first half
        for (char c : firstHalf.toCharArray()) {
            freq[c - 'a']++;
        }

        // Subtract frequency of second half
        for (char c : secondHalf.toCharArray()) {
            freq[c - 'a']--;
        }

        // Check if all frequencies are zero
        for (int count : freq) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
