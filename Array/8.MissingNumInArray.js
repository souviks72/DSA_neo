//https://practice.geeksforgeeks.org/problems/missing-number-in-array1416/1
class Solution {
  MissingNumber(array, n) {
    let x = (n * (n + 1)) / 2;
    for (let i = 0; i < n - 1; i++) x -= array[i];

    return x;
  }
}
