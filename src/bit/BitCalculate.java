package bit;

/**
 * reference http://blog.csdn.net/morewindows/article/details/7354571
 * @author wangxy
 * λ����
 * ������������:1.�Լ����Լ������Ϊ0
 * ������������:2.������㽻����
 * �����κ�������0��򶼻ᱣ�ֲ���
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
	 * �ж�ż������1��and����,ż����ĩλΪ0,����Ϊ1
	 * @param i
	 * @return
	 */
	public static boolean isEvenNumber(int i){
		return (i&1)==0;
	}
	
	/**
	 * ������ʵ�����ֽ���
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
