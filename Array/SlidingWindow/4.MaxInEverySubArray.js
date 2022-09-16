//https://www.interviewbit.com/problems/sliding-window-maximum/
//https://www.youtube.com/watch?v=xFJXtB5vSmM&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=6
module.exports = { 
 //param A : array of integers
 //param B : integer
 //return a array of integers
	slidingMaximum : function(arr, k){
        if (k==1) return arr;
        let res = [];
        let ls = [];
        let i=0,j=0;
        while(j < arr.length){
            let x = arr[j];
            
            while(ls.length>0 && ls[ls.length-1]<x){
                ls.pop();
            }
            
            ls.push(x);
            
            if(j-i+1<k){
                j++;
            }else{
                res.push(ls[0]);
                
                if(arr[i] === ls[0]){
                    ls.shift();
                }
                i++;
                j++;
            }
            
        }
        
        return res;
	}
};