//https://practice.geeksforgeeks.org/problems/equilibrium-point-1587115620/1#
class Solution {
  // Function to find equilibrium point in the array.
  equilibriumPoint(arr, n) {
    if (n == 1) return 1;
    if (n == 2) return -1;

    let s1 = getSubarraySum(arr, 0, 0);
    let s2 = getSubarraySum(arr, 2, n - 1);
    for (let i = 1; i < n - 1; i++) {
      if (s1 === s2) return i + 1;
      s1 = s1 + arr[i];
      s2 = s2 - arr[i + 1];
    }

    return -1;
  }
}

function getSubarraySum(arr, a, b) {
  let s = 0;
  for (let i = a; i <= b; i++) s += arr[i];
  return s;
}
