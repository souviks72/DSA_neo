//https://practice.geeksforgeeks.org/problems/reverse-words-in-a-given-string5459/1
class Solution {
  //Function to reverse words in a given string.
  reverseWords(s) {
    // code here
    let arr = s.split(".");
    let str = "";
    for (let i = arr.length - 1; i > 0; i--) {
      str += arr[i] + ".";
    }
    str += arr[0];
    return str;
  }
}
