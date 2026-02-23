import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    public static void matrixRotation(List<List<Integer>> matrix, int r) {
        int m = matrix.size();
        int n = matrix.get(0).size();
        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {
            List<Integer> elements = new ArrayList<>();

            for (int j = layer; j < n - layer; j++) {
                elements.add(matrix.get(layer).get(j));
            }

            for (int i = layer + 1; i < m - layer - 1; i++) {
                elements.add(matrix.get(i).get(n - layer - 1));
            }

            for (int j = n - layer - 1; j >= layer; j--) {
                elements.add(matrix.get(m - layer - 1).get(j));
            }

            for (int i = m - layer - 2; i > layer; i--) {
                elements.add(matrix.get(i).get(layer));
            }

            int len = elements.size();
            int rot = r % len;

            List<Integer> rotated = new ArrayList<>();
            rotated.addAll(elements.subList(rot, len));
            rotated.addAll(elements.subList(0, rot));

            int index = 0;

            for (int j = layer; j < n - layer; j++) {
                matrix.get(layer).set(j, rotated.get(index++));
            }

            for (int i = layer + 1; i < m - layer - 1; i++) {
                matrix.get(i).set(n - layer - 1, rotated.get(index++));
            }

            for (int j = n - layer - 1; j >= layer; j--) {
                matrix.get(m - layer - 1).set(j, rotated.get(index++));
            }

            for (int i = m - layer - 2; i > layer; i--) {
                matrix.get(i).set(layer, rotated.get(index++));
            }
        }

        for (List<Integer> row : matrix) {
            for (int j = 0; j < row.size(); j++) {
                System.out.print(row.get(j));
                if (j != row.size() - 1)
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        int r = Integer.parseInt(firstMultipleInput[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String[] matrixRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> matrixRowItems = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int matrixItem = Integer.parseInt(matrixRowTempItems[j]);
                matrixRowItems.add(matrixItem);
            }

            matrix.add(matrixRowItems);
        }

        Result.matrixRotation(matrix, r);

        bufferedReader.close();
    }
}
