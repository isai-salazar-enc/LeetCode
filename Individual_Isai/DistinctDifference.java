package Individual_Isai;
import java.util.HashSet;

// Two array solutions
class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        int[] diff = new int[nums.length];
        int[] prefixCount = new int[nums.length];
        HashSet<Integer> uniqueNums = new HashSet<Integer>();

        // Get unique prefix numbers on each position
        for(int i = 0; i<nums.length; i++){
            uniqueNums.add(nums[i]);
            prefixCount[i] = uniqueNums.size();
        }

        // The last diff value is always the total amount of unique numbers, because the last sufix is always 0
        diff[nums.length - 1] = uniqueNums.size();
        uniqueNums.clear();

        // Iterate the array in reverse order, except last position and compare
        for(int i = nums.length-2; i>-1; i--){
            uniqueNums.add(nums[i+1]);
            diff[i] = prefixCount[i] - uniqueNums.size();
        }

        return diff;
    }
}