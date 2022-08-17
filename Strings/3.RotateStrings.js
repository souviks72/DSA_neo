//https://practice.geeksforgeeks.org/problems/check-if-string-is-rotated-by-two-places-1587115620/1
class Solution {
  //Function to check if a string can be obtained by rotating
  //another string by exactly 2 places.
  isRotated(str1, str2) {
    // code here

    let a = rotateRight(str1, str2);
    let b = rotateLeft(str1, str2);

    return a || b;
  }
}

function rotateRight(s1, s2) {
  let l = s1.length;
  let s = s1.substring(l - 2, l) + s1.substring(0, l - 2);

  if (s === s2) return true;
  return false;
}

function rotateLeft(s1, s2) {
  let l = s1.length;
  let s = s1.substring(2, l) + s1.substring(0, 2);

  if (s === s2) return true;
  return false;
}
