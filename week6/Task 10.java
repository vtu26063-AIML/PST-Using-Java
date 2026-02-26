import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    public static List<Integer> circularPalindromes(String s) {
        int n = s.length();
        String doubled = s + s;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String rotated = doubled.substring(i, i + n);
            result.add(longestPalindrome(rotated));
        }

        return result;
    }

    private static int longestPalindrome(String s) {
        int maxLen = 1;

        for (int i = 0; i < s.length(); i++) {
            // Odd length
            maxLen = Math.max(maxLen, expand(s, i, i));

            // Even length
            maxLen = Math.max(maxLen, expand(s, i, i + 1));
        }

        return maxLen;
    }

    private static int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        List<Integer> result = Result.circularPalindromes(s);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}