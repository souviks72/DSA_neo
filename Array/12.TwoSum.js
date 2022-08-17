/**https://leetcode.com/problems/two-sum/
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
 var twoSum = function(nums, target) {
    let arr = [...nums].sort((a,b) => a-b);
    let s=0,e=arr.length-1;
    
    while(s<=e){
        let sum = arr[s]+arr[e];
        if (sum < target){
            s++;
        }else if(sum > target){
            e--;
        }else{
            let a = nums.indexOf(arr[s]);
            let b = nums.indexOf(arr[e]);
            if (a == b){ 
                //without this check, output of [3,3], target = 6 will be [0,0] while actual answer is [0,1]
                b = nums.indexOf(arr[e],a+1);
            }
            return [a,b];
        }
    }
    return -1;
};