package algorithm;

import java.util.HashMap;

public class BagCalculate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int m = 95000;
//		int[] a = {9548,35120,6509,10090,32050,25160,45601,16500,9810,10000,55000};
//		
//		int m = 89;
//		int[] a = {7,11,13,5,2,10,50};
//		
//		calcBagEqual(m,a);
		
		int m = -8;
		int[] a = {-4,-3,-1,-5};
		BagCalculate b = new BagCalculate();
		int[] aa = b.twoSum(a,m);
		
		for(int i = 0 ; i < aa.length ; i++){
			System.out.println(aa[i]);
		}
	}
	
	/**
	 * 
	 * @param sum
	 * @param array
	 */
	public static void calcBag(int m,int[] a){
		int[][] c = new int[a.length][m+1];
		
		for(int j=1; j<=m; j++){
			for(int i = 0; i < a.length;i++){
				
				if(j < a[i]){
					continue;
				}
				
				int x = i ==0 ? a[0] : c[i-1][j-a[i]] + a[i];
				int y = i ==0 ? 0 : c[i-1][j];
				
				if(x>=j && y>=j){
					System.out.println("x>=m && y>=m");
					c[i][j] = Math.min(x, y);
				} else if(x>=j && y<j){
					c[i][j] = x;
				} else if(x< j && y>=m){
					c[i][j] = y;
				}else if(x< j && y<j){
					System.out.println("x<j && y<j");
					c[i][j] = Math.max(x, y);
				}

			}
		}
		
		System.out.println(c[a.length-1][m]);
	}
	
	
	public static void calcBagEqual(int m,int[] a){
		int[][] c = new int[a.length][m+1];
		int[][] d = new int[a.length][m+1];
		
		for(int j=1; j<=m; j++){
			for(int i = 0; i < a.length;i++){
				int y = i ==0 ? 0 : c[i-1][j];
				
				if(j < a[i]){
					c[i][j] = y;
				} else {
					int x = i ==0 ? a[0] : c[i-1][j-a[i]] + a[i];
					
					if(x > y){//select a[i]
						c[i][j] = x;
						d[i][j] = 1;
					} else {//don't select a[i]
						c[i][j] = y;
						d[i][j] = 0;
					}
				}
			}
		}
		
		int s = m, count = 0;
		StringBuffer strBuf = new StringBuffer();
		
		for(int i = a.length-1;i >= 0;i--){
			strBuf.append(String.valueOf(d[i][s]));
			if(d[i][s] == 1){
				count++;
				s = s - a[i];
			}
		}
		
		System.out.println(c[a.length-1][m]);
		System.out.println(strBuf.reverse().toString());
	}
	
    public int[] twoSum(int[] nums, int target) {
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	int[] index = new int[2];
    	
		for(int i = 0 ; i < nums.length ;i++){
			if(map.get(target - nums[i]) != null){
				index[0] = map.get(target - nums[i]);
				index[1] = i;
				break;
			}
			map.put(nums[i], i);
		}
		return index;
    }
}
