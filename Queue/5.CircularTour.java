//https://practice.geeksforgeeks.org/problems/circular-tour-1587115620/1
//https://www.youtube.com/watch?v=_gJ3to4RyeQ&t=2464s
class Solution
{
    //Function to find starting point where the truck can start to get through
    //the complete circle without exhausting its petrol in between.
    int tour(int petrol[], int distance[])
    {
	    int deficit=0, balance=0, start=0;
	    for(int i=0;i<petrol.length;i++){
	        balance += petrol[i] - distance[i];
	        if(balance<0){
	            deficit += balance;
	            start = i+1;
	            balance=0;
	        }
	    }
	    
	    if(balance+deficit>=0)
	        return start;
	   return -1;
    }
}