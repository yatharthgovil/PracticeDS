package com.learn.dp;
import java.util.*;
class Solution {
	
	
	public static void main(String[] args) {
		
		minCost(7, new int[]{1,3,4,5});
	}
    public static int minCost(int n, int[] cuts) {
        
        Map<String,Integer> dp = new HashMap<String,Integer>();
        
       return minCost(0,n,cuts,dp);
        
    }
    
    public static int minCost(int start, int end, int[] cuts, Map<String,Integer> dp) {
        
        String key = ""+start+","+end;
        System.out.println("Inside----"+start+"End-----"+end);
        if(dp.containsKey(key)) {
            return dp.get(key);
        }
        if(end - start==1)
            return 0;
        if(start>=end)
            return 0;
      int min = Integer.MAX_VALUE;

        for(int i=0;i<cuts.length;i++) {
            if(cuts[i]>start&&cuts[i]<end){
            	System.out.println("cutting from "+cuts[i]);

                 min = Math.min(min,end-start + minCost(start,cuts[i],cuts,dp)+ minCost(cuts[i],end,cuts,dp));
            }
           
            
        } 
        if(min == Integer.MAX_VALUE)
        	min = 0 ;
         dp.put(key,min);

            
        return min;
    }
}                                                                                                         