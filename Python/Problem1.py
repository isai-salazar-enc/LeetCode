class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        allnums = nums1 + nums2
        allnums.sort()
        index = round(len(allnums)/2)-1
        median = allnums[index]
        if len(allnums) % 2 == 0 :
            median = (median + allnums[index+1]) / 2
        
        return median
        