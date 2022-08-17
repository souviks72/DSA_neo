//https://practice.geeksforgeeks.org/problems/reverse-array-in-groups0255/1#
class Solution {
  //Function to reverse every sub-array group of size k.
  reverseInGroups(arr, n, k) {
    let rem = n % k;

    for (let i = 0; i < n - rem; i += k) {
      let arx = [],
        c = 0;
      for (let j = i + k - 1; j >= i; j--) {
        arx[c++] = arr[j];
      }
      c = 0;
      for (let j = i; j <= i + k - 1; j++) {
        arr[j] = arx[c++];
      }
    }

    let arx = [],
      c = 0;
    for (let i = n - 1; i >= n - rem; i--) {
      arx[c++] = arr[i];
    }
    c = 0;
    for (let i = n - rem; i <= n - 1; i++) {
      arr[i] = arx[c++];
    }
  }
}
