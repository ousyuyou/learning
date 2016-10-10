package algorithm.tree;

import algorithm.SortUtil;

public class TestTree {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		TreeMap<String,String> map = new TreeMap<String,String>();
	
		RBTree<String,String> tree = new RBTree<String,String> ();

		int[] array = SortUtil.createArray(10,100);
		for(int i = 0 ; i < array.length;i++){
			System.out.println("array[i]: "+String.valueOf(array[i]));
		}
		
		for(int i = 0 ; i < array.length;i++){
			tree.put(String.valueOf(array[i]), String.valueOf(array[i]));
		}
		
		System.out.println("root "+tree.root.key);
		tree.loop();
		
		System.out.println("remove "+String.valueOf(array[0]));
		tree.remove(String.valueOf(array[0]));
		System.out.println("root "+tree.root.key);
		tree.loop();
		
		System.out.println("remove "+String.valueOf(array[1]));
		tree.remove(String.valueOf(array[1]));
		System.out.println("root "+tree.root.key);
		tree.loop();
		
		System.out.println("remove "+String.valueOf(array[2]));
		tree.remove(String.valueOf(array[2]));
		System.out.println("root "+tree.root.key);
		tree.loop();
		
		System.out.println("remove "+String.valueOf(array[3]));
		tree.remove(String.valueOf(array[3]));
		System.out.println("root "+tree.root.key);
		tree.loop();
		
		System.out.println("remove "+String.valueOf(array[4]));
		tree.remove(String.valueOf(array[4]));
		System.out.println("root "+tree.root.key);
		tree.loop();
		
		System.out.println("remove "+String.valueOf(array[5]));
		tree.remove(String.valueOf(array[5]));
		System.out.println("root "+tree.root.key);
		tree.loop();
		
		System.out.println("remove "+String.valueOf(array[6]));
		tree.remove(String.valueOf(array[6]));
		System.out.println("root "+tree.root.key);
		tree.loop();
		
		System.out.println("remove "+String.valueOf(array[7]));
		tree.remove(String.valueOf(array[7]));
		System.out.println("root "+tree.root.key);
		tree.loop();
		
		System.out.println("remove "+String.valueOf(array[8]));
		tree.remove(String.valueOf(array[8]));
		System.out.println("root "+tree.root.key);
		tree.loop();
		
		System.out.println("remove "+String.valueOf(array[9]));
		tree.remove(String.valueOf(array[9]));		
		tree.loop();
		
		System.out.println("height: "+tree.height());
	}
	
	
}
