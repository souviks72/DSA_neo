function mergeSort(arr, left, right){
  if (left < right){
    let mid = Math.floor((left+right)/2);

    mergeSort(arr,left,mid);
    mergeSort(arr,mid+1,right);
    merge(arr,left,right,mid);
  }
}

function merge(arr,left,right,mid){
  let n1 = mid - left + 1;
  let n2 = right - mid;

  let L=[], R=[];

  for(let i=0;i<n1;i++){
    L[i] = arr[left+i];
  }
  for(let i=0;i<n2;i++){
    R[i] = arr[mid+1+i]
  }

  let i=0,j=0,k=left;

  while(i<n1 && j<n2){
    if (L[i]<=R[j]){
      arr[k] = L[i];
      i++;
    }else if(L[i]>R[j]){
      arr[k] = R[j];
      j++;
    }
    k++;
  }

  while(i<n1){
    arr[k]=L[i];
    i++;
    k++;
  }

  while(j<n2){
    arr[k]=R[j];
    j++;
    k++;
  }
}

let arr = [100,56, 64,89, 99, 96, 88, 78, 1, 2];
mergeSort(arr,0,9);
console.log(arr);