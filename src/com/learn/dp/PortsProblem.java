package com.learn.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PortsProblem {
    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        
        int dp[] = new int[boxes.length];
        for(int i=0;i<boxes.length;i++)
            dp[i] = -1;
        
        return minTrips(0,boxes,portsCount,maxBoxes,maxWeight,dp);
        
    }
    
    public int minTrips(int startI, int[][] boxes, int portsCount,int maxBoxes,int maxWeight, int dp[]) {
        if(startI>=boxes.length)
            return 0;
        if(dp[startI]==-1) {
            int weight = 0;
            int noBoxes = 0;
            int i = startI;
            int endI = startI;
            int trips = Integer.MAX_VALUE;
            while(i<boxes.length&&weight + + boxes[i][1]<= maxWeight && ++noBoxes<maxBoxes) {
                
                    endI = i;
                    weight += boxes[i][1]; 
                    trips = Math.min(trips,(getTrips(startI,endI,boxes) + minTrips(endI+1,boxes,portsCount,maxBoxes,maxWeight,dp)));
                
                i++;
                    
            }
            dp[startI] = trips;
            System.out.println("Number of trips--"+startI+"---->"+dp[startI]);
        }
        return dp[startI];
    }
    
    public int getTrips(int startI, int endI, int boxes[][]) {
        int trips = 0;
        int curPort = 0;
        for(int i=startI;i<=endI;i++) {
            if(curPort!=boxes[i][0]) {
                trips++;
                curPort = boxes[i][0];
            }
        }
        return ++trips;
    }
    
    public static void main(String[] args) {
    	PortsProblem pp = new PortsProblem();
    //	int boxes[][] = {{2,4},{2,5},{3,1},{3,2},{3,7},{3,1},{4,4},{1,3},{5,2}};
    	int boxes[][] = {{3,1},{4,4},{1,3},{5,2}};

    	pp.boxDelivering(boxes, 5, 5, 7);
    	String str1 = "123A";
    	String str2 = "123B";
    	List<String> strs = new ArrayList<String>();
    	strs.add(str1);
    	strs.add(str2);
    	Comparator<String> stringComparator = new Comparator<String>(){
    		public int compare(String st1, String st2) {
    			return st1.compareTo(st2);
    		}
    	};
    	Collections.sort(strs,stringComparator);
    	System.out.print(str1.compareTo(str2)+strs.toString());
    }
}