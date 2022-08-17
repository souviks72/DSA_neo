class Solution {
  //Function to find a continuous sub-array which adds up to a given number.
  subarraySum(arr, n, s) {
    //your code here
    let p = 0,
      a = 0,
      b = 0,
      sum = 0;
    while (b <= n) {
      if (sum === s) {
        return [a + 1, b];
      } else if (sum < s) {
        sum += arr[b];
        b++;
      } else if (sum > s) {
        sum -= arr[a];
        a++;
      }
    }
    return [-1];
  }
}
//https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1/?page=1&difficulty[]=0&category[]=Arrays&sortBy=submissions#
