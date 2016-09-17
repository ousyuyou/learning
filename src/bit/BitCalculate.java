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
		//������������
		int[] arr = {13,16};
		swap(arr);
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		//���ŷ�ת
		System.out.println(signReverse(-487));
		System.out.println(signReverse(4478));
		//ȡ����ֵ
		System.out.println(abs(-123));
		System.out.println(abs(456));
		//Ѱ��ȱʧ����
		int a[] = {1, 347, 6, 9, 13, 65, 889, 712, 889, 347, 1, 9, 65, 13, 712}; 
		System.out.println(getSingleArray(a));
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
	
	/**
	 * �任���ţ��������ò�����ʽ���棬����λȡ����+1
	 * ȡ����+1
	 * @param t
	 * @return
	 */
	public static int signReverse(int i){
		return ~i + 1;
	}
	
	/**
	 * �����ֵ
	 * @param i
	 * @return
	 */
	public static int abs(int i){
		//ȡ����λ
		int sign = i>>31;
		//����λΪ0��Ϊ����
		return sign == 0? i : (~i+1);
	}
	
	/**
	 * ��������1��int���飬���ҽ���1�����ֳ���1�Σ�����������2�Σ��ҳ�������
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
