https://leetcode.com/problems/subsets
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsets = function(nums) {
    let ar = [];
    let arr = []
    getSubsets(arr,nums,ar);
    return ar;
};

var getSubsets = function(arr,nums,ar){
    if (nums.length === 0){
        ar.push(arr);
        return;
    }else{
        let a = nums[0];
        
        let numLeft = nums.slice(1);
        getSubsets(arr,numLeft,ar);
        let s = [...arr,a];
        getSubsets(s,numLeft,ar);
    }
}

