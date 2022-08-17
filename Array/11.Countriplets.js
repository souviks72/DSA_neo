//https://practice.geeksforgeeks.org/problems/count-the-triplets4615/1#
class Solution {
  countTriplet(arr, n) {
    //code here
    let c = 0;
    let obj = {};
    for (let i = 0; i < n; i++) {
      obj[arr[i]] = i;
    }
    for (let i = 0; i < n; i++) {
      for (let j = i + 1; j < n; j++) {
        let sum = arr[i] + arr[j];
        if (obj.hasOwnProperty(sum)) c++;
      }
    }

    return c;
  }
}
