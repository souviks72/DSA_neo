let arr = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1];

let binSearch = (x, arr) => {
  let start = 0,
    end = 9;
  let mid = start + Math.floor((end - start) / 2);
  console.log(start, end, mid);
  console.log("....");
  while (start <= end) {
    mid = start + Math.floor((end - start) / 2);
    if (arr[mid] == x) {
      return mid;
    } else if (x > arr[mid]) {
      end = mid - 1;
    } else {
      start = mid + 1;
    }
  }
  return -1;
};
let a = binSearch(10, arr);
console.log(a);
