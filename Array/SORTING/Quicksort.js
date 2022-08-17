function swap(arr,i,j){
    let t = arr[i];
    arr[i] = arr[j];
    arr[j] = t;
}

function quicksort(arr,low,high){
    if (low < high){
        let pi = partition(arr,low,high);

        quicksort(arr,low,pi-1);
        quicksort(arr,pi+1,high);
    }
}

function partition(arr, low, high){
    let pivot = arr[high];

    let i = low-1;

    for(let j=low;j<high;j++){
        if (arr[j] <= pivot){
            i++;
            swap(arr,i,j);
        }
    }
    swap(arr,1+i,high);
    return i+1;
}

let arr = [100,56, 64,89, 99, 96, 88, 78, 1, 2,9];
quicksort(arr,0,10);
console.log(arr);