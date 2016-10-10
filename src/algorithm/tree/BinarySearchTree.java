package algorithm.tree;

public class BinarySearchTree<K, V> {
	TreeNode<K,V> root = null;
	int size;


	public TreeNode<K,V> search(K key){
		TreeNode<K,V> t = root;
		if(t == null){
			return null;
		}
		
        Comparable<? super K> k = (Comparable<? super K>) key;
		int cmp = 0;
		do{
			cmp = k.compareTo(t.key);
			if(cmp < 0){
				t = t.left;
			} else if(cmp > 0){
				t = t.right;
			}else{
				return t;
			}
		}while(t!= null);
		
		return null;
	}
	
	/**
	 * equals insert
	 * @param key
	 * @param value
	 */
	public void put(K key,V value){
		TreeNode<K,V> t = root;
		
		if(t == null){
			root = new TreeNode<K,V>(key,value,null);
			size = 1;
			return;
		}
		
		TreeNode<K,V> parent = null;
		
        Comparable<? super K> k = (Comparable<? super K>) key;
		int cmp = 0;
		do{
			parent = t;
			cmp = k.compareTo(t.key);
			if(cmp < 0){
				t = t.left;
			} else if(cmp > 0){
				t = t.right;
			}else{
				t.setValue(value);
				return;
			}
		}while(t!= null);
		
		TreeNode<K,V> e = new TreeNode<K,V>(key, value, parent);
		if (cmp < 0)
            parent.left = e;
        else
            parent.right = e;
		size++;
	}
	
	public void remove(Object key){
		TreeNode<K,V> node = search((K)key);
		if(node == null){
			return;
		}
		
		/**find the node should be deleted;
		 * no child or one child then the node self;
		 * else successor node
		*/
		TreeNode<K,V> d = null;
		if(node.left == null || node.right == null){
			d = node;
		} else {
			d = successor(node);
		}
		/** find the deleted node's child node(not null)
		 */
		TreeNode<K,V> c = null;
		if(node.left != null){
			c = node.left;
		} else {
			c = node.right;
		}
		//set the deleted node's parent to child node's parent
		if(c != null){
			c.parent = d.parent;
		}
		/**
		 * set the child node to parent node's child
		 */
		if(d.parent == null){
			root = c;
		}else if(d.parent.left == d){
			d.parent.left = c;
		} else {
			d.parent.right = c;
		}
		
		/**
		 * two child,set the successor's node key,value to current node
		 */
		if(node != d){
			node.key = d.key;
			node.value = d.value;
		}
		size--;
	}
	
	public int height(){
		return height(root);
	}
	
	private int height(TreeNode<K,V> node){
		if(node == null){
			return 0;
		} else {
			int m = height(node.left);
			int n = height(node.right);
			return (m > n) ? (m+1) : (n+1); 
		}
	}
	
	public TreeNode<K,V> minimum(){
		return minimum(root);
	}
	
	private TreeNode<K,V> minimum(TreeNode<K,V> node){
		while(node.left != null){
			node = node.left;
		}
		return node;
	}
		
	private TreeNode<K,V> successor(TreeNode<K,V> node){
		if(node.right != null){
			return minimum(node.right);
		}
		TreeNode<K,V> parent = node.parent,t = node;
		
		while(parent != null && parent.right == t){
			t = parent;
			parent = t.parent;
		}
		return parent;
		
	}
	
	public TreeNode<K,V> maximum(){
		return maximum(root);
	}
	
	private TreeNode<K,V> maximum(TreeNode<K,V> node){
		while(node.right != null){
			node = node.right;
		}
		return node;
	}
	
	public void loop(){
		loop(root);
	}
	
	private void loop(TreeNode<K,V> node){
		if(node != null){
			loop(node.left);
			System.out.println("key= "+node.key + " value= "+node.value);
			loop(node.right);
		}
	}
}
