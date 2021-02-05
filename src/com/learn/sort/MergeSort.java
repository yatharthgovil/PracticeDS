package com.learn.sort;

public class MergeSort {
	
	public static void mergeSort(int arr[], int l, int u) {
		if(l>=u)
			return;
		int mid = (l+u)/2;
		mergeSort(arr,l,mid);
		mergeSort(arr,mid+1,u);
		merge(arr,l,u);
	}

	public static void merge(int arr[], int l, int u) {
		int mid = (l+u)/2;
	    int lArr[] = new int[mid-l+1];
	    int rArr[] = new int[u-mid];

	    for(int i=0;i<mid-l+1;i++) {
	    	lArr[i] = arr[i+l];
	    }
	    for(int i=0;i<u-mid;i++) {
	    	rArr[i] = arr[i+mid+1];
	    }
	    int i=0,j=0,k=l;
	    while(i<mid-l+1 &&j< u - mid) {
	    	if(lArr[i]<=rArr[j]) {
	    		arr[k] = lArr[i];
	    		i++;
	    	} 
	    	else {
	    		arr[k] = rArr[j];
	    		j++;
	    	}
	    	k++;
	    }
	    while(i<mid-l+1) {
	    	arr[k] = lArr[i];
	    	i++;
	    	k++;
	    }
	    while(j< u - mid) {
	    	arr[k] = rArr[j];
	    	j++;
	    	k++;
	    }
	}
	public static void main(String[] args) {
		
		int arr[] = new int[] {9,11,4,2,12,16,8};
		mergeSort(arr,0,arr.length-1);
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
}

	