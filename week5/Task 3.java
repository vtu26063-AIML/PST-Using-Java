import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
public static List<Integer> maxSubarray(List<Integer> arr) {

    int maxSubarraySum = arr.get(0);
    int currentSum = arr.get(0);

    int maxSubsequenceSum = 0;
    int maxElement = arr.get(0);
    boolean hasPositive = false;

    for (int i = 0; i < arr.size(); i++) {

        int num = arr.get(i);

        // Kadane's Algorithm (Subarray)
        if (i > 0) {
            currentSum = Math.max(num, currentSum + num);
            maxSubarraySum = Math.max(maxSubarraySum, currentSum);
        }

        // Subsequence logic
        if (num > 0) {
            maxSubsequenceSum += num;
            hasPositive = true;
        }

        maxElement = Math.max(maxElement, num);
    }

    // If all numbers are negative
    if (!hasPositive) {
        maxSubsequenceSum = maxElement;
    }

    return Arrays.asList(maxSubarraySum, maxSubsequenceSum);
}
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arr = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrTemp[i]);
                arr.add(arrItem);
            }

            List<Integer> result = Result.maxSubarray(arr);

            for (int i = 0; i < result.size(); i++) {
                bufferedWriter.write(String.valueOf(result.get(i)));

                if (i != result.size() - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
