package Week 4;

public class task6 {
    
}
class Solution {
    public void moveZeroes(int[] nums) {
        int insertPos = 0;
        
        // Move non-zero elements forward
        for (int num : nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
        }
        
        // Fill remaining positions with zero
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }
}
