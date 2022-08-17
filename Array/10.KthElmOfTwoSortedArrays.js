//https://practice.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1#
class Solution {
  kthElement(ar1, ar2, n, m, k) {
    //code here
    let arx = [];
    let a = 0,
      b = 0;
    while (a < n && b < m) {
      if (ar1[a] < ar2[b]) {
        arx.push(ar1[a]);
        a++;
      } else if (ar1[a] > ar2[b]) {
        arx.push(ar2[b]);
        b++;
      } else if (ar1[a] == ar2[b]) {
        arx.push(ar1[a++]);
        arx.push(ar2[b++]);
      }
    }
    if (n < m) {
      while (b < m) arx.push(ar2[b++]);
    } else if (n > m) {
      while (a < n) arx.push(ar1[a++]);
    }

    return arx[k - 1];
  }
}
