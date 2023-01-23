//leetcode.com/problems/subsets
//https://leetcode.com/problems/subsets/solutions/27281/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning/
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
https: var subsets = function (nums) {
  let ar = [];
  let arr = [];
  getSubsets(arr, nums, ar);
  return ar;
};

var getSubsets = function (arr, nums, ar) {
  if (nums.length === 0) {
    ar.push(arr);
    return;
  } else {
    let a = nums[0];

    let numLeft = nums.slice(1);
    getSubsets(arr, numLeft, ar);
    let s = [...arr, a];
    getSubsets(s, numLeft, ar);
  }
};
