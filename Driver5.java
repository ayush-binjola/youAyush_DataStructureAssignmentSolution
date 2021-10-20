package com.Driver.pak;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

class get
{
	
	static void getDays(int days[],int sort[])
	{
		Stack<Integer> temp1 = new Stack<>();
		Stack<Integer> st = new Stack<>();
		Stack<Integer> temp2 = new Stack<>();
		LinkedList<Integer> result = new LinkedList<>();	
		for(int x=0;x<sort.length;x++)
		{
			st.push(sort[x]);  //    3 2 1
		}
		int max = st.pop();
		for(int i=0;i<days.length;i++)
		{
			if(max == days[i])
			{
				result.add(days[i]);
				
				max = st.pop();
//				System.out.println(temp1.size());
				int temp1Size = temp1.size();
				for(int j=0;j<temp1Size;j++)
				{
					if(max == temp1.peek())
					{
						result.add(max);
						
						
						if(!st.isEmpty()) {
							max = st.pop();
					
						}
						temp1.pop();
					}else
					{
						temp2.push(temp1.pop());
					}
				}
				int temp2Size = temp2.size();
				for(int y=0;y<temp2Size;y++)
				{
						temp1.push(temp2.pop());
					
				}
				System.out.println("Day"+(i+1)+":"+result);
				result.clear();
			}
			else 
			{
			temp1.push(days[i]);
			System.out.println("Day"+(i+1)+":");
			}
		}
		}
	public static void merge(int days[],int left,int mid,int right)
	{
		int len1 = mid-left+1;
		int len2 = right-mid;
		int leftArr[]= new int[len1];
		int rightArr[] = new int[len2];
		for(int i=0;i<len1;i++)
		{
			leftArr[i]=days[left+i];
		}
		for(int j=0;j<len2;j++)
		{
			rightArr[j] = days[mid+1+j];
		}
		int i,k,j;
		i=0;
		j=0;
		k=left;
		while( i<len1 && j < len2)
		{
			if(leftArr[i] <= rightArr[j])
			{
				days[k] = leftArr[i];
				i++;
			}
			else
			{
				days[k] = rightArr[j];
				j++;
			}
			k++;
		}
		while(i<len1)
		{
		days[k]= leftArr[i];
		i++;
		k++;
		}
		while(j<len2)
		{
		days[k]	= rightArr[j];
		j++;
		k++;
		}
		
	}
	
	public  void mergeSort(int days[],int low,int high)
	{
		int mid = (low + high)/2;
		if(low < high)
		{
			
			mergeSort(days,low,mid);
			mergeSort(days,mid+1,high);
			merge(days,low,mid,high);
		}
	}
	}
public class Driver5 {
public static void main(String args[])
{
	get gt = new get();
	Scanner sc = new Scanner(System.in);
	System.out.println("enter the total no of floors in the building");
	int floors = sc.nextInt();
	int days[] = new int[floors];
	
	int sort[]= new int[floors];
	
	for(int i=0;i<days.length;i++) 
	{ 
		System.out.println("enter the floor size given on day :"+(i+1));
		days[i] = sc.nextInt();
	}
	for(int j=0;j<days.length;j++)
	{
	sort[j]=days[j];	
	}
	gt.mergeSort(sort,0,floors-1);
	gt.getDays(days,sort);
}
}

