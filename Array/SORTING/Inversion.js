function invertionSort(arr) {
  for (let i = 1; i < arr.length; i++) {
    let v = arr[i];
    let j = i;

    while (j >= 1 && arr[j - 1] > v) {
      arr[j] = arr[j - 1];
      j--;
    }
    arr[j] = v;
  }
}

let arr = [8, 3, 9, 2, 5, 6, 4];
invertionSort(arr);
console.log(arr);
