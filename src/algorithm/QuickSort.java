package algorithm;

import java.security.SecureRandom;
import java.util.Arrays;

public class QuickSort {

	private static int count = 0;
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
//		int[] array = new int[30];
//		SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
//		for(int i = 0 ;i <array.length;i++){
//			array[i] = random.nextInt(100);
//		}
//		int[] dest = new int[array.length];
//		System.arraycopy(array, 0, dest, 0, array.length);
//		int[] dest2 = new int[array.length];
//		System.arraycopy(array, 0, dest2, 0, array.length);
//		
//		
		int[] array = new int[]{5,11,9,2,1,5,4,7,5,8,3,6};
		
		three_way_partition(array,5);
		Sort.printArrayInt(array);
		System.out.println("----------------------------------count = "+count);
		
		count = 0;
		quickSortVer3(array);
		Sort.printArrayInt(array);
		System.out.println("----------------------------------count3 = "+count);
	}
	
	public static void quickSortVer(int[] array){
		quickSortVer(array,0,array.length-1);
	}
	
	public static void quickSortVer2(int[] array){
		quickSortVer2(array,0,array.length-1);
	}
	
	public static void quickSortVer3(int[] array){
		quickSortVer3(array,0,array.length-1);
	}
	public static void quickSortVer4(int[] array){
		quickSortVer4(array,0,array.length-1);
	}
	private static void quickSortVer(int[] array,int p,int r){
		int q = 0;
		if(p < r){
			q = partition(array,p,r);
			quickSortVer(array,p,q-1);
			quickSortVer(array,q+1,r);
		}
	}
	
	private static void quickSortVer2(int[] array,int p,int r){
		int q = 0;
		if(p < r){
			q = partition2(array,p,r);
			quickSortVer2(array,p,q-1);
			quickSortVer2(array,q+1,r);
		}
	}
	
	private static void quickSortVer3(int[] array,int p,int r){
		int q = 0;
		if(p < r){
			q = partition3(array,p,r);
			quickSortVer3(array,p,q-1);
			quickSortVer3(array,q+1,r);
		}
	}
	private static void quickSortVer4(int[] array,int p,int r){
		int q = 0;
		if(p < r){
			q = partition4(array,p,r);
			quickSortVer4(array,p,q-1);
			quickSortVer4(array,q+1,r);
		}
	}
	//scan from header and tail,when find then swap;from jdk 1.6,Arrays.sort 
	private static int partition2(int[] array,int low,int high){
		int l =low,h = high,key = array[low];
		while(l < h){
			while(l < h && array[h] >= key)
				h--;
			if(l < h){
				Sort.swap(array, l, h);
				l++;
				count++;
			}
			
			while(l < h && array[l] <= key)
				l++;
			if(l < h){
				Sort.swap(array, l, h);
				h--;
				count++;
			}
		}
		return l;//l=h
	}
	
	//scan from header and tail,two pointers
	private static int partition3(int[] array,int low,int high){
			int l =low,h = high,key = array[low];
			while(l < h){
				while(l < h && array[h] >= key)
					h--;
				while(l < h && array[l] <= key)
					l++;
				if(l<h){
					swap(array,l,h);
					count++;
				}
			}
					
			if(l==low){
				//key is already the minimum value,do nothing
			}else{
				swap(array,low,l);
				count++;
			}
			return l;
	}
	
	//scan from header and tail,two pointers,from http://selfboot.cn/2016/09/01/lost_partition/
	private static int partition4(int[] array,int low,int high){
			int l =low,h = high,key = array[low];
			while(l < h){
				while(l < h && array[h] >= key)
					h--;
				array[l] = array[h];
				while(l < h && array[l] <= key)
					l++;
				array[h] = array[l];
				count++;
			}
			array[l] = key;
			
			return l;//l=h
		}
	
	//the single pointer algorithm
	private static int partition(int[] array,int p,int r){
		//set the first data as base data
		int key = array[r],i = p -1;
		for(int j = p; j <= r-1;j++){
			if(array[j] <= key){
				i++;
				swap(array,i,j);
				count++;
			}
		}
		swap(array,i+1,r);
		return i+1;
	}
	
	//user three pointer,
	//keep four areas;< area;= area;for scan area;> area
	private static void three_way_partition(int[] arr,int target){
		int next_less_pos = 0, next_bigger_pos = arr.length-1;
	    int next_scan_pos = 0;
	    while (next_scan_pos <= next_bigger_pos){
	        if(arr[next_scan_pos] < target){
	            swap(arr,next_scan_pos++, next_less_pos++);
	            count++;
	        }
	        else if(arr[next_scan_pos] > target){
	            swap(arr,next_scan_pos, next_bigger_pos--);
	            count++;
	        }
	        else{
	            next_scan_pos++;
	        }
	    }
	}
	
	private static void swap(int[] array,int p,int q){
		int tmp = array[p];
		array[p] = array[q];
		array[q] = tmp;
	}

}
