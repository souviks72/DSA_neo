let arr = [100, 89, 78, 77, 66, 45, 34, 13, 12, 10];

let binSearch = (x, arr) => {
  let start = 0,
    end = 9;
  while (start <= end) {
    let mid = start + Math.floor((end - start) / 2);
    if (arr[mid] == x) {
      return mid;
    } else if (x > arr[mid]) {
      end = mid - 1;
    } else {
      start = mid + 1;
    }
  }
  console.log(start, end);
  return -1;
};
let a = binSearch(79, arr);
console.log(a);
