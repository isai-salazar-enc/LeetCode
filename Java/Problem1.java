package Java;

//Median of Two Sorted Arrays
//Two pointers method -> O(m+n) complexity
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size1 = nums1.length;
        int size2 = nums2.length;
        int pointer1 = 0;
        int pointer2 = 0;
        int fullLength = size1 + size2;

        // We simulate the middle position of a ficticious new array that sums the other 2 arrays
        int middle = fullLength/2;
        float prevNumber = 0, median = 0;


        // We iterate on the arrays using both pointers to find the sorted middle value
        for(int i = 0; i<=middle; i++){
            prevNumber = median; // We store the middle-1 number in case the array is even

            // If array1 is out of elements
            if(pointer1==size1){
                median = nums2[pointer2];
                pointer2++;
                continue;
            }

             // If array2 is out of elements 
            if(pointer2==size2){
                median = nums1[pointer1];
                pointer1++;
                continue;
            }


            if( nums1[pointer1] < nums2[pointer2]) {
                median = nums1[pointer1];
                pointer1++;
            }
            else{
                median = nums2[pointer2];
                pointer2++;
            }
        }

        // If length is even, return the mean of 2 middle elements
        if(fullLength%2==0){
            median = (median + prevNumber) / 2;
        }
        return median;
    }
}