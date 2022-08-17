//https://practice.geeksforgeeks.org/problems/-rearrange-array-alternately-1587115620/1#
class Solution {
  //Function to rearrange  the array elements alternately.
  rearrange(arr, n) {
    // code here
    if (n > 1) {
      let arx = [];
      let a = 0,
        b = n - 1,
        i = 0;
      while (a <= b) {
        if (a != b) {
          arx[i] = arr[b--];
          arx[i + 1] = arr[a++];
          i += 2;
        } else {
          arx[n - 1] = arr[a];
          break;
        }
      }

      for (let i = 0; i < n; i++) {
        arr[i] = arx[i];
      }
    }
  }
}
