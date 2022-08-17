class Solution {
  removeDups(str) {
    //code here
    let s = "";
    for (let i = 0; i < str.length; i++) {
      let ch = str.charAt(i);
      if (str.indexOf(ch) === i) {
        s += ch;
      }
    }
    return s;
  }
}
//https://practice.geeksforgeeks.org/problems/remove-duplicates3034/1
