package algorithm;

public class YoungMatrix {
	private int[][] array;
	private int rows;
	private int cols;
	
	private final static int RIGHT = 1;
	private final static int DOWN = 2;
	
	private final static int LEFT = 3;
	private final static int UP = 4;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] array = {
				{2,5,6,7},
				{3,9,12,14},
				{5,10,13,15},
				{16,17,Integer.MAX_VALUE,Integer.MAX_VALUE}
		};
		printArray2D(array);
		YoungMatrix matrix = new YoungMatrix(array);
		System.out.println("--------------------");
//
//		matrix.insertKey(1);
//		printArray2D(array);
//		System.out.println("--------------------");
//
//		matrix.insertKey(8);
//		printArray2D(array);

		
		for(int i = 0 ; i< 16;i++){
			matrix.extractMin();
			printArray2D(matrix.getArray());
			System.out.println("--------------------");
		}
	}
	
	public YoungMatrix(int[][] array){
		this.array = array;
		this.rows = array.length;
		this.cols = array[0].length;
	}

	public static void printArray2D(int[][] array){
		for(int i = 0 ; i  < array.length;i++){
			for(int j = 0 ; j < array[i].length;j++){
				if(array[i][j] == Integer.MAX_VALUE){
					System.out.print("max"+" ");
				}else{
					System.out.print(array[i][j]+" ");
				}
			}
//			System.out.print(System.lineSeparator());
		}
	}
	
	public int extractMin(){
		int key = array[0][0];
//		array[0][0] = Integer.MAX_VALUE;
		array[0][0] = array[rows-1][cols-1];
		matrixKeep(0,0);
		return key;
	}
	
	public void insertKey(int key){
		array[rows-1][cols-1] = key;
		matrixMove(rows-1,cols-1);
	}
	
	private void matrixMove(int i,int j){
		int key = array[i][j];
		int direction = 0;
		int largest = key;
		
		if(i==0 && j==0){
			return;
		}
		
		if(i==0){
			direction = LEFT;
		}else if(j==0){
			direction = UP;
		} else{
			if(array[i][j-1] > key){
				largest = array[i][j-1];
				direction = LEFT;
			}
			if(array[i-1][j] > largest){
				largest = array[i-1][j];
				direction = UP;
			}
		}
		
		switch(direction){
		case LEFT:
			Sort.swap2D(array, i, j,i,j-1);
			matrixMove(i,j-1);
			break;
		case UP:
			Sort.swap2D(array, i, j,i-1,j);
			matrixMove(i-1,j);
			break;
		default:
			break;
		}
	}
	
	private void matrixKeep(int i,int j){
		int key = array[i][j];
		int direction = 0;
		int smallest = key;
		
		if(i+1 >= rows && j+1 >= cols){
			return;
		}
		
		if(i+1 >= rows){
			direction = RIGHT;
		}else if(j+1 >= cols){
			direction = DOWN;
		}else{
			if(array[i][j+1] < key){
				smallest = array[i][j+1];
				direction = RIGHT;
			}
			if(array[i+1][j] < smallest){
				smallest = array[i+1][j];
				direction = DOWN;
			}
		}
		
		switch(direction){
		case RIGHT:
			Sort.swap2D(array, i, j,i,j+1);
			matrixKeep(i,j+1);
			break;
		case DOWN:
			Sort.swap2D(array, i, j,i+1,j);
			matrixKeep(i+1,j);
			break;
		default:
			break;
		}
	}

	public int[][] getArray() {
		return array;
	}
	
	

	public void setArray(int[][] array) {
		this.array = array;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getCols() {
		return cols;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}
	
}
