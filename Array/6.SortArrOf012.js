//https://practice.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1#
class Solution {
  sort012(arr, n) {
    let c1 = 0,
      c2 = 0,
      c = 0;
    for (let i = 0; i < n; i++) {
      if (arr[i] === 0) c++;
      else if (arr[i] === 1) c1++;
      else c2++;
    }
    let arx = [];
    let i = 0;
    for (; i < c; i++) {
      arr[i] = 0;
    }

    for (i = c; i < c1 + c; i++) {
      arr[i] = 1;
    }
    for (i = c + c1; i < c2 + c1 + c; i++) {
      arr[i] = 2;
    }
  }
}
