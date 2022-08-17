class Solution {
  duplicates(arr, n) {
    arr.sort(function (a, b) {
      return a - b;
    });
    let dupArr = [];
    for (let i = 0; i < n - 1; i++)
      if (arr[i] == arr[i + 1] && dupArr.indexOf(arr[i]) == -1)
        dupArr.push(arr[i]);

    return dupArr;
  }
}
//https://practice.geeksforgeeks.org/problems/find-duplicates-in-an-array/1/?page=1&difficulty[]=0&category[]=Arrays&sortBy=submissions
