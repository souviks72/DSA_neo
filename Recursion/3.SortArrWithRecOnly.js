function sortArr(arr){
    if (arr.length === 1){
        return;
    }

    let temp = arr.pop();
    sortArr(arr);
    insertIntoSortedArr(arr,temp);
}

function insertIntoSortedArr(arr,temp){
    if(arr.length === 0 || arr[arr.length - 1] <= temp){
        arr.push(temp);
    }

    let val = arr.pop();
    insertIntoSortedArr(arr,temp);
    arr.push(val);
}


let arr = [10,9,11,12,5,6,5,8]
sortArr(arr);
console.log(arr);
//---------------
// If Js does not work, JAVA WILL WORK