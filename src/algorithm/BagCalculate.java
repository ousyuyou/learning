package algorithm;


public class BagCalculate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 95000;
		int[] a = {9548,35120,6509,10090,32050,25160,45601,16500,9810,10000,55000,5082,2000};
		
//		int m = 89;
//		int[] a = {7,11,13,5,2,10,50};
		
		calcBagOverMim(m,a,10000);
	}	
	
	public static void calcBagOverMim(int v,int[] a,int sumv){
		int m = v + sumv;
		int[][] c = new int[a.length][m+1];
		int[][] d = new int[a.length][m+1];
		
		int j=1;
		for(;j<=m; j++){
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
			if(c[a.length-1][j] >= v){
				break;
			}
		}
		System.out.println(c[a.length-1][j]);
		System.out.println("j= "+j);
		
		int s = c[a.length-1][j];
		StringBuffer strBuf = new StringBuffer();
		
		for(int i = a.length-1;i >= 0;i--){
			strBuf.append(String.valueOf(d[i][s]));
			if(d[i][s] == 1){
				s = s - a[i];
			}
		}
		
		System.out.println(strBuf.reverse().toString());
	}
}
