package dynamicprogramming;

public class LCS {
	private static final int DIRECTION_UP = 1;
	private static final int DIRECTION_LEFT = 2;
	private static final int DIRECTION_LEFTUP = 3;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "ABCBDABEFGH";
		String s2 = "BDCABAEG";
		lcsLength(s1,s2);
	}
	
	public static void lcsLength(String X,String Y){
		int m = X.length();
		int n = Y.length();
		
		int[][] c = new int[m+1][n+1];
		int[][] b = new int[m+1][n+1];
		
		for(int i = 1 ; i <= m; i++){
			for(int j = 1 ;j <= n; j++){
				if(X.charAt(i-1) == Y.charAt(j-1)){
					c[i][j] = c[i-1][j-1] + 1;
					b[i][j] = DIRECTION_LEFTUP;
				} else if(c[i-1][j] >= c[i][j-1]){
					c[i][j] = c[i-1][j];
					b[i][j] = DIRECTION_UP;
				} else {
					c[i][j] = c[i][j-1];
					b[i][j] = DIRECTION_LEFT;
				}
			}
		}
		System.out.println("LCS: "+c[m][n]);
		printLCS(b,X,m,n);
	}
	
	private static void printLCS(int[][] b,String X,int i,int j){
		if(i==0 || j ==0){
			return;
		}
		if(b[i][j] == DIRECTION_LEFTUP){
			printLCS(b,X,i-1,j-1);
			System.out.print(X.charAt(i-1));
		} else if(b[i][j] == DIRECTION_UP){
			printLCS(b,X,i-1,j);
		} else {
			printLCS(b,X,i,j-1);
		}
	}
}
