package Java;
import java.util.HashMap;

// Longest Substring Without Repeating Characters
// 2 Pointer solution
// We use 2 pointers as a windows to iterate through our string to find the longest substring
// We use a hashmap to store the position of each letter
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int stringLength = s.length();
        int max = 0;
        int leftPointer = 0;
        int rightPointer = 0;

        HashMap<Character, Integer> myHashMap = new HashMap<Character, Integer>();

        while(rightPointer < stringLength){
            // If the substring does not contain the current character or if it does contain it but before of the leftPointer, add it, compare the length of the substring to the max value, and move the right pointer.
            if( !myHashMap.containsKey(s.charAt(rightPointer)) || myHashMap.get(s.charAt(rightPointer)) < leftPointer ){
                myHashMap.put(s.charAt(rightPointer), rightPointer); //Add character and positon
                max = Math.max(rightPointer - leftPointer + 1, max);
                rightPointer++;
            }
            // Else, move leftPointer to the last position of the repeated character + 1 and update the index of the character
            else{
                leftPointer = myHashMap.get(s.charAt(rightPointer)) + 1;
                myHashMap.put(s.charAt(rightPointer), rightPointer);
                rightPointer++;
            }
        }

        return max;
    }
}
