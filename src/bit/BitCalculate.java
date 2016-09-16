package bit;

/**
 * reference http://blog.csdn.net/morewindows/article/details/7354571
 * @author wangxy
 *
 */
public class BitCalculate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int a=15,b=-15;
//		System.out.println(a<<2);
//		System.out.println(b<<2);
//		System.out.println(a>>2);
//		System.out.println(b>>2);
		
		System.out.println(isEvenNumber(105));
		System.out.println(isEvenNumber(888));
		
		int[] arr = {13,16};
		swap(arr);
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}
	
	/**
	 * 判断偶数，与1做and操作,偶数的末位为0,奇数为1
	 * @param i
	 * @return
	 */
	public static boolean isEvenNumber(int i){
		return (i&1)==0;
	}
	
	/**
	 * 异或操作实现数字交换
	 * @param array
	 */
	public static void swap(int[] array){
		if(array[0] != array[1]){
			array[0] ^= array[1];
			array[1] ^= array[0];
			array[0] ^= array[1];
		}
	}
}
