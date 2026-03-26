import java.io.*;
import java.util.*;

class UserMainCode {
    public int MostFrequentDigit(int input1, int input2, int input3, int input4) {
        // Step 1: Create a frequency array for digits 0-9
        int[] freq = new int[10];
        
        // Store inputs in an array for easy iteration
        int[] inputs = {input1, input2, input3, input4};
        
        // Step 2: Iterate through each number and count digits
        for (int num : inputs) {
            // Handle the case if a number is 0
            if (num == 0) {
                freq[0]++;
            } else {
                // If number is negative, make it positive for digit extraction
                if (num < 0) num = -num;
                
                while (num > 0) {
                    int digit = num % 10;
                    freq[digit]++;
                    num /= 10;
                }
            }
        }
        
        // Step 3: Find the digit with the max frequency
        int maxFreq = -1;
        int resultDigit = -1;
        
        // Iterate from 0 to 9. By using >=, we ensure that if 
        // frequencies are tied, the higher digit (index) wins.
        for (int i = 0; i <= 9; i++) {
            if (freq[i] >= maxFreq) {
                maxFreq = freq[i];
                resultDigit = i;
            }
        }
        
        return resultDigit;
    }
}