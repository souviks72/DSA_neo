//https://leetcode.com/problems/create-target-array-in-the-given-order
var createTargetArray = function(nums, index) {
    let arr = [];
    
    nums.forEach((n,i)=>{
       if (arr[index[i]]!==0 && !arr[index[i]]){
           arr[index[i]] = n; 
       }else{
           insertHere(arr,index[i],n)
       } 
        console.log(arr);
    });
    return arr;
};

var insertHere = function(arr,j,x){
    let t = arr[j];
    arr[j] = x;
    x = t;
    let l = arr.length
    for(let i=j+1;i<arr.length;i++){
        t = arr[i];
        arr[i] = x;
        x = t;
    }
    if (l === arr.length)
        arr.push(x);
}