//https://leetcode.com/problems/sum-of-all-odd-length-subarrays
//https://leetcode.com/problems/sum-of-all-odd-length-subarrays/discuss/867779/Java-O(n)-time-with-Video-explanation
var sumOddLengthSubarrays = function(arr) {
    let sum = 0;
    for(let i=0;i<arr.length;i++){
        let endsHere = i+1;
        let startsHere = arr.length-i;
        
        let totalSubarrays = endsHere*startsHere;
        let numOfOddSubarrays = Math.ceil(totalSubarrays/2);
        
        sum += numOfOddSubarrays*arr[i];
    }
    
    return sum;
};
