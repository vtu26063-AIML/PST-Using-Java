import java.io.*;
import java.util.*;

class UserMainCode {
    public int weightOfString(String input1, int input2) {
        int totalWeight = 0;
        // Convert to lowercase to handle case-insensitivity easily
        String str = input1.toLowerCase();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // Check if the character is a letter
            if (ch >= 'a' && ch <= 'z') {
                boolean isVowel = (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');

                // Logic for adding weight
                if (input2 == 0 && isVowel) {
                    // Option 0: Ignore vowels, do nothing
                    continue;
                } else {
                    // Calculate weight: 'a' is 97 in ASCII, so 'a' - 96 = 1
                    totalWeight += (ch - 96);
                }
            }
        }
        return totalWeight;
    }
}