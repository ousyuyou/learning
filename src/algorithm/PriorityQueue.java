package algorithm;

import java.util.Arrays;

/**
 * Heap base priority queue
 * @author wangxy
 *
 */
public class PriorityQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[]{6,5,7,2,6,3,7,6,8,5,9};
		Heap h = HeapFactory.buildMaxHeap(array);
		HeapFactory.printHeap(h);

		maxHeapInsert(h,11);
		System.out.println("heapIncreaseKey");

		HeapFactory.printHeap(h);
		
		System.out.println("stop");
	}

	public static int maximum(Heap h){
		return h.array[0];
	}
	
	public static int heapExtractMax(Heap h){
		if(h.heapSize < 1){
			//throw new IllegalAccessException("size 0");
		}
		
		int max = h.array[0];
		
		h.array[0] = h.array[h.heapSize-1];
		h.heapSize = h.heapSize - 1;
		HeapFactory.maxHeapify(h, 0);
		
		return max;
	}
	
	public static void heapIncreaseKey(Heap h,int i,int key){
		if(key < h.array[i]){
			//throw error
		}
		h.array[i] = key;
		while(i > 0 && h.array[h.parent(i)] < h.array[i] ){
			Sort.swap(h.array, i, h.parent(i));
			i = h.parent(i);
		}
	}
	
	public static void maxHeapInsert(Heap h,int key){
		h.heapSize = h.heapSize+1;
		if(h.array.length < h.heapSize){
			int oldLength = h.array.length;
			h.array = Arrays.copyOf(h.array, oldLength<<1);
		}
		
		h.array[h.heapSize-1] = Integer.MIN_VALUE;
		
		heapIncreaseKey(h,h.heapSize-1,key);
	}
}
