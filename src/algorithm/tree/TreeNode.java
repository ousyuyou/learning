package algorithm.tree;

public class TreeNode<K,V> {
	K key;
	V value;
	TreeNode<K,V> left = null;
	TreeNode<K,V> right = null;
	TreeNode<K,V> parent = null;
	
	TreeNode(K key,V value,TreeNode<K,V> parent){
		this.key = key;
		this.value = value;
		this.parent = parent;
	}
	
	void setValue(V value){
		this.value = value;
	}
}
