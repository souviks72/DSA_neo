class Solution {
  peakElement(arr, n) {
    if (n == 1) return 0;
    if (n == 2) return arr[0] > arr[1] ? 0 : arr[1] > arr[0] ? 1 : -1;

    if (arr[0] > arr[1]) return 0;

    if (arr[n - 1] > arr[n - 2]) return n - 1;

    for (let i = 1; i < n - 1; i++) {
      if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) return i;
    }

    return -1;
  }
}
//https://practice.geeksforgeeks.org/problems/peak-element/1/?page=1&difficulty[]=0&category[]=Arrays&sortBy=submissions
