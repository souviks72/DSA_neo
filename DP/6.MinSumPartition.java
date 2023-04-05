//https://practice.geeksforgeeks.org/problems/minimum-sum-partition3317/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
//https://www.youtube.com/watch?v=-GtpxG6l_Mc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=10
class Solution
{

	public int minDifference(int nums[], int n) 
	{ 
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += nums[i];
        }

        boolean t[][] = new boolean[n+1][sum+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
                if(i==0) t[i][j] = false;
                if(j==0) t[i][j] = true;
            }
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if (nums[i-1] <= j){
                    t[i][j] = t[i-1][j-nums[i-1]] || t[i-1][j];
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }

        int s = (int)Math.ceil(sum/2), min = Integer.MAX_VALUE;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<=s;i++){
            if(t[n][i]==true){
                arr.add(i);
            }
        }

        for(int i: arr){
            min = Math.min(min, sum - 2*i);
        }

        return min;
	} 
}