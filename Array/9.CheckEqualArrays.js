//https://practice.geeksforgeeks.org/problems/check-if-two-arrays-are-equal-or-not3847/1
class Solution {
  //Function to check if two arrays are equal or not.
  check(ar1, ar2, n) {
    // code here
    let obj1 = {},
      obj2 = {};
    for (let i = 0; i < n; i++) {
      if (obj1.hasOwnProperty(ar1[i])) {
        obj1[ar1[i]]++;
      } else {
        obj1[ar1[i]] = 1;
      }

      if (obj2.hasOwnProperty(ar2[i])) {
        obj2[ar2[i]]++;
      } else {
        obj2[ar2[i]] = 1;
      }
    }

    let keys1 = Object.keys(obj1);
    let keys2 = Object.keys(obj2);
    if (keys1.length !== keys2.length) return false;

    for (let i = 0; i < keys1.length; i++) {
      if (obj1[keys1[i]] !== obj2[keys1[i]]) {
        return false;
      }
    }

    return true;
  }
}
