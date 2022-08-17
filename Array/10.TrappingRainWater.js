//https://practice.geeksforgeeks.org/problems/trapping-rain-water-1587115621/1
class Solution {
  // Function to find the trapped water between the blocks.
  trappingWater(arr, n) {
    //your code here
    let left = 0,
      right = 0,
      i = 0,
      sum = 0;
    n--;
    while (i < n) {
      if (arr[i] < arr[n]) {
        if (arr[i] >= left) left = arr[i];
        else sum += left - arr[i];
        i++;
      } else {
        if (arr[n] >= right) right = arr[n];
        else sum += right - arr[n];
        n--;
      }
    }
    return sum;
  }
}
