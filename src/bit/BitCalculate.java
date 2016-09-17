package bit;

/**
 * reference http://blog.csdn.net/morewindows/article/details/7354571
 * @author wangxy
 * 位运算
 * 异或运算的性质:1.自己与自己异或结果为0
 * 异或运算的性质:2.异或满足交换律
 * 对于任何数，与0异或都会保持不变
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
		//交换两个数字
		int[] arr = {13,16};
		swap(arr);
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		//符号反转
		System.out.println(signReverse(-487));
		System.out.println(signReverse(4478));
		//取绝对值
		System.out.println(abs(-123));
		System.out.println(abs(456));
		//寻找缺失数字
		int a[] = {1, 347, 6, 9, 13, 65, 889, 712, 889, 347, 1, 9, 65, 13, 712}; 
		System.out.println(getSingleArray(a));
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
	
	/**
	 * 变换符号；负数采用补码形式保存，即按位取反后+1
	 * 取反后+1
	 * @param t
	 * @return
	 */
	public static int signReverse(int i){
		return ~i + 1;
	}
	
	/**
	 * 求绝对值
	 * @param i
	 * @return
	 */
	public static int abs(int i){
		//取符号位
		int sign = i>>31;
		//符号位为0则为正数
		return sign == 0? i : (~i+1);
	}
	
	/**
	 * 假设输入1组int数组，近且仅有1个数字出现1次，其他均出现2次，找出此数字
	 * @param arr
	 * @return
	 */
	public static int getSingleArray(int[] array){
		int dec = 0;
		for(int i = 0;i<array.length;i++){
			dec ^= array[i];
		}
		return dec;
	}
}
