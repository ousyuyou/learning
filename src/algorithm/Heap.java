package algorithm;

public class Heap {
	public int heapSize;
	public int[] array;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public Heap(int[] array){
		this(array,array.length);
	}
	
	public Heap(int[] array,int heapSize){
		this.heapSize = heapSize;
		this.array = array;
	}
	
	public int parent(int i){
		return i/2;
	}
	
	public int leftChild(int i){
		return 2*i+1;
	}
	
	public int rightChild(int i){
		return 2*i+2;
	}

//	public int getHeapSize() {
//		return heapSize;
//	}
//
//	public void setHeapSize(int heapSize) {
//		this.heapSize = heapSize;
//	}
//
//	public int getLength() {
//		return length;
//	}
//
//	public void setLength(int length) {
//		this.length = length;
//	}
//
//	public int[] getArray() {
//		return array;
//	}
//
//	public void setArray(int[] array) {
//		this.array = array;
//	}
	
	
}
