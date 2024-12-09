function findMedianSortedArrays(nums1: number[], nums2: number[]): number {
    let allNums = [...nums1, ...nums2]

    allNums.sort();

    const index = Math.round(allNums.length/2)-1;
    let median = allNums[index];
    
    if(allNums.length % 2 == 0){
        median = (median + allNums[index+1])/2;
    }

    return median;
};