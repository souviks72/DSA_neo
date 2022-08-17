//https://practice.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1
class Solution {
  //Function to find the leaders in the array.
  leaders(arr, n) {
    let arx = [],
      max = arr[n - 1];
    arx.unshift(max);
    for (let i = n - 1; i > 0; i--) {
      if (arr[i - 1] > arr[i] && arr[i - 1] >= max) {
        arx.push(arr[i - 1]);
        max = arr[i - 1];
      }
    }
    arx.reverse();
    return arx;
  }
}
