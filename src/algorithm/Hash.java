package algorithm;

public class Hash {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int length = 1 << 5;
		System.out.println(length);
		
		int[] array = SortUtil.createArray(length,100);
		for(int i=0;i<array.length;i++){
			int v = hash(array[i]);
			System.out.println(array[i]+" hash value "+v);
			System.out.println("index "+(v&(length-1)));
		}
	}
	
    static int hash(int h) {
        // This function ensures that hashCodes that differ only by
        // constant multiples at each bit position have a bounded
        // number of collisions (approximately 8 at default load factor).
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }
    
}
