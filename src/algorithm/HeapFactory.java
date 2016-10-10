package algorithm;

public class HeapFactory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[]{6,5,7,2,6,3,7,6,8,5,9,10,11,12,13,7,2,6,3,7,6,8,5,9,10,11,12,13};
//		heapSort(array);
//		Sort.printArrayInt(array);
		Heap h = buildMaxHeap(array);
		printHeap(h);
	}

	public static void maxHeapify(Heap h,int i){
		int left = h.leftChild(i);
		int right = h.rightChild(i);
		
		int largest = 0;
		if(left <= h.heapSize-1 && h.array[left] > h.array[i]){
			largest = left;
		} else {
			largest = i;
		}
		
		if(right <= h.heapSize-1 && h.array[right] > h.array[largest]){
			largest = right;
		}
		
		if(largest != i){
			Sort.swap(h.array, largest, i);
			maxHeapify(h,largest);
		}
		
	}
	
	public static Heap buildMaxHeap(int[] array){
		Heap h = new Heap(array);
		for(int i  = h.heapSize/2;i>=0;i--){
			maxHeapify(h,i);
		}
		return h;
	}
	
	public static void heapSort(int[] array){
		Heap h = buildMaxHeap(array);
		
		for(int i = h.array.length-1; i >=1 ; i--){
			Sort.swap(array, 0, i);
			h.heapSize = h.heapSize-1;
			maxHeapify(h,0);
		}
	}
	
	public static void printHeap(Heap h){
		int height = (int)Math.ceil(Math.log(h.heapSize)/Math.log(2));
		
		int halfLength = (int)Math.pow(2, height-1);
		
		for(int i = 0; i <= height-1; i++){
			int startIndex = (int)Math.pow(2, i);
			
			for(int j=halfLength-startIndex;j>0;j--){
				System.out.print(" ");
			}
			for(int index = startIndex-1;
					index<2*startIndex-1&& index < h.heapSize;index++){
				System.out.print(h.array[index] + " ");
			}
			System.out.print("\n");
			for(int j=halfLength-startIndex;j>0;j--){
				System.out.print(" ");
			}
			
			if(i != height -1){
				for(int index = startIndex-1;
						index<2*startIndex-1&&index < h.heapSize;index++){
					System.out.print("/\\" + " ");
				}
				System.out.print("\n");
			}
		}
	}
}
