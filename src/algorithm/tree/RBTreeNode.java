package algorithm.tree;

public class RBTreeNode<K,V> {
	int color = 0;

	K key;
	V value;
	RBTreeNode<K,V> left = null;
	RBTreeNode<K,V> right = null;
	RBTreeNode<K,V> parent = null;
	
	RBTreeNode(K key, V value, RBTreeNode<K, V> parent) {
		this.key = key;
		this.value = value;
		this.parent = parent;
	}
	
	RBTreeNode(K key, V value, RBTreeNode<K, V> parent,int color) {
		this(key,value,parent);
		this.color = color;
	}
	
	public void setColor(int color){
		this.color = color;
	}
	
	void setValue(V value){
		this.value = value;
	}
}
