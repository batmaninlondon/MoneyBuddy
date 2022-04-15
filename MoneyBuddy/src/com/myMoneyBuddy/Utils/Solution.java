package com.myMoneyBuddy.Utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
	
	public static void main(String args[])  {
		int[] nums = {-1,0,1,2,-1,-4};
		//int[] nums = {0,1,2,3,4,5};
		List<List<Integer>> abc = twoSum(nums);
		
		for (List<Integer> a:abc) {
			for ( int i : a)  {
				System.out.print(i+" ");
			}
			System.out.println("");
		}
	}
	
    public static List<List<Integer>> twoSum(int[] nums) {
    	
        
    	List<List<Integer>> myList = new ArrayList<>();
    	if (nums.length>2)  {
        /*int i=0,j=0;
        for (int a : Arrays.copyOfRange(nums, 0, nums.length-1))  {
        	 j=i;
        	for (int b : Arrays.copyOfRange(nums, j+1, nums.length-1) )  {
        		for (int c : Arrays.copyOfRange(nums, j+2, nums.length))  {
        			System.out.println(" i : "+a+" j : "+b+" k : "+c);
        			if ( (a + b +c) == 0)  {
        				myList.add(Arrays.asList(a,b,c));
        			}
            	}
        		j++;
        	}
        	i++;
        }*/
    	
    	int l= nums.length;
    	int i=0,j=1,k=l;
    	for ( int a=0;a < ((l-1)*(l-2));a++)  {
    		if (!(k == (j+1)))  {
    			k--;
    			System.out.println(" k : "+k+" (j+1) : "+(j+1));
    		}
    		else {
    			k=l;
    			j++;
    		}
    		if ( (j+k) == (2*(l-1)-1))  {
				i++;
				k=l-i;
				j=i+1;
    		}
    		//System.out.println(" i : "+i+" j : "+j+" k : "+k);
    	}
        
        
        
        
        
        for( List<Integer> list : myList)  {
        	list.sort(Comparator.naturalOrder());
        }
         myList = myList.stream()
        		 .distinct()
        		 .collect(Collectors.toList());
        }
        return myList;
        
    }

}
