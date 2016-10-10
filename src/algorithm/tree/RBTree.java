package algorithm.tree;


public class RBTree<K, V>{
	RBTreeNode<K,V> root = null;
	int size;
	public static final int BLACK = 1;
	public static final int RED = 2;
	
	protected void rotateLeft(RBTreeNode<K,V> x){
		if(x.right == null){
			return;
		}
		RBTreeNode<K,V> y = x.right;
		/**
		 * link y's left node to x's right
		 */
		x.right = y.left;
		if(y.left != null){
			y.left.parent = x;
		}
		/**
		 * set cur's parent to c's parent
		 */
		y.parent = x.parent;
		if(x.parent == null){
			root = y;
		} else if(x.parent.left == x){
			x.parent.left = y;
		} else {
			x.parent.right = y;
		}
		/**
		 * set cur to r's left
		 */
		x.parent = y;
		y.left = x;
	}
	
	protected void rotateRight(RBTreeNode<K,V> y){
		if(y.left == null)
			return;
		
		RBTreeNode<K,V> x = y.left;
		/**
		 * set x's right to y's left
		 */
		y.left = x.right;
		if(x.right != null){
			x.right.parent = y;
		}
		/**
		 * set y's parent to x's parent
		 */
		x.parent = y.parent;
		if(y.parent == null){
			root = x;
		}else if(y.parent.left == y){
			y.parent.left = x;
		} else {
			y.parent.right = x;
		}
		/**
		 * set x to y's parent
		 */
		y.parent = x;
		x.right = y;
	}
	

	/**
	 * equals insert
	 * @param key
	 * @param value
	 */
	public void put(K key,V value){
		RBTreeNode<K,V> t = root;
		
		if(t == null){
			root = new RBTreeNode<K,V>(key,value,null);
			root.color = BLACK;
			size = 1;
			return;
		}
		
		RBTreeNode<K,V> parent = null;
		
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
		
		RBTreeNode<K,V> e = new RBTreeNode<K,V>(key, value, parent);
		if (cmp < 0)
            parent.left = e;
        else
            parent.right = e;
		size++;
		fixColorAfterInsert(e);
	}
	
	private void fixColorAfterInsert(RBTreeNode<K,V> x){
		x.color = RED;

        while (x != null && x != root && x.parent.color == RED) {
            if (parentOf(x) == leftOf(parentOf(parentOf(x)))) {
            	RBTreeNode<K,V> y = rightOf(parentOf(parentOf(x)));
                if (colorOf(y) == RED) {
                    setColor(parentOf(x), BLACK);
                    setColor(y, BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    x = parentOf(parentOf(x));
                } else {
                    if (x == rightOf(parentOf(x))) {
                        x = parentOf(x);
                        rotateLeft(x);
                    }
                    setColor(parentOf(x), BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    rotateRight(parentOf(parentOf(x)));
                }
            } else {
            	RBTreeNode<K,V> y = leftOf(parentOf(parentOf(x)));
                if (colorOf(y) == RED) {
                    setColor(parentOf(x), BLACK);
                    setColor(y, BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    x = parentOf(parentOf(x));
                } else {
                    if (x == leftOf(parentOf(x))) {
                        x = parentOf(x);
                        rotateRight(x);
                    }
                    setColor(parentOf(x), BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    rotateLeft(parentOf(parentOf(x)));
                }
            }
        }
        root.color = BLACK;
	}
	
	public void remove(Object key){
		RBTreeNode<K,V> z = search((K)key);
		if(z == null){
			return;
		}
		
		size--;
	
		/**find the node should be deleted;
		 * no child or one child then the node self;
		 * else successor node
		*/
		RBTreeNode<K,V> p = null;
		if(z.left == null || z.right == null){
			p = z;
		} else {
			p = successor(z);
		}
		
		/**
		 * two child,set the successor's node key,value to current node
		 */
		if(z != p){
			z.key = p.key;
			z.value = p.value;
		}
		
		/** find the deleted node's child node(not null)
		 */
		RBTreeNode<K,V> replacement = p.left == null?p.right:p.left;
		
		//set the deleted node's parent to child node's parent
		if(replacement != null){
			replacement.parent = p.parent;
			/**
			 * set the child node to parent node's child
			 */
			if(p.parent == null){
				root = replacement;
			}else if(p.parent.left == p){
				p.parent.left = replacement;
			} else {
				p.parent.right = replacement;
			}
			
			p.parent = p.left = p.right = null;
            // Fix replacement
            if (p.color == BLACK)
            	fixColorAfterDelete(replacement);
		}else if(p.parent == null){
			root = null;
		} else {
			if (p.color == BLACK)
				fixColorAfterDelete(p);
			
			if (p.parent != null) {
                if (p == p.parent.left)
                    p.parent.left = null;
                else if (p == p.parent.right)
                    p.parent.right = null;
                p.parent = null;
            }
		}
		
	}
	
	private void fixColorAfterDelete(RBTreeNode<K,V> x){

		while( x != root && colorOf(x) == BLACK){
			if(leftOf(parentOf(x)) == x){
				RBTreeNode<K,V> w = rightOf(parentOf(x));
				//case 1,w is red
				if(colorOf(w) == RED){
					setColor(w,BLACK);
					setColor(parentOf(x),RED);
					rotateLeft(parentOf(x));
					w = rightOf(parentOf(x));
				} 
				//case 2,w's left child is black,right child is black
				if(colorOf(leftOf(w)) == BLACK && colorOf(rightOf(w))== BLACK){
					setColor(w,RED);
					x = parentOf(x);
				} else{
					if(colorOf(rightOf(w))== BLACK){ //case 3;w's left child is red,right child is black
						setColor(leftOf(w), BLACK);
                        setColor(w, RED);
                        rotateRight(w);
                        w = rightOf(parentOf(x));
					}
					//case 4
					setColor(w, colorOf(parentOf(x)));
                    setColor(parentOf(x), BLACK);
                    setColor(rightOf(w), BLACK);
                    rotateLeft(parentOf(x));
                    x = root;
				}
			}else{
				RBTreeNode<K,V> w = leftOf(parentOf(x));

                if (colorOf(w) == RED) {
                    setColor(w, BLACK);
                    setColor(parentOf(x), RED);
                    rotateRight(parentOf(x));
                    w = leftOf(parentOf(x));
                }

                if (colorOf(rightOf(w)) == BLACK &&
                    colorOf(leftOf(w)) == BLACK) {
                    setColor(w, RED);
                    x = parentOf(x);
                } else {
                    if (colorOf(leftOf(w)) == BLACK) {
                        setColor(rightOf(w), BLACK);
                        setColor(w, RED);
                        rotateLeft(w);
                        w = leftOf(parentOf(x));
                    }
                    setColor(w, colorOf(parentOf(x)));
                    setColor(parentOf(x), BLACK);
                    setColor(leftOf(w), BLACK);
                    rotateRight(parentOf(x));
                    x = root;
                }
			}
			
		}
		
		setColor(x, BLACK);
	}
	
	private RBTreeNode<K,V> successor(RBTreeNode<K,V> node){
		if(node.right != null){
			return minimum(node.right);
		}
		RBTreeNode<K,V> parent = node.parent,t = node;
		
		while(parent != null && parent.right == t){
			t = parent;
			parent = t.parent;
		}
		return parent;
		
	}
	
	public RBTreeNode<K,V> search(K key){
		RBTreeNode<K,V> t = root;
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
	
	public RBTreeNode<K,V> minimum(){
		return minimum(root);
	}
	
	private RBTreeNode<K,V> minimum(RBTreeNode<K,V> node){
		while(node.left != null){
			node = node.left;
		}
		return node;
	}
	
    private static <K,V> RBTreeNode<K,V> parentOf(RBTreeNode<K,V> p) {
        return (p == null ? null: p.parent);
    }
    
    private static <K,V> int colorOf(RBTreeNode<K,V> p) {
        return (p == null ? BLACK : p.color);
    }
    
    private static <K,V> void setColor(RBTreeNode<K,V> p, int c) {
        if (p != null)
	    p.color = c;
    }

    private static <K,V> RBTreeNode<K,V> leftOf(RBTreeNode<K,V> p) {
        return (p == null) ? null: p.left;
    }

    private static <K,V> RBTreeNode<K,V> rightOf(RBTreeNode<K,V> p) {
        return (p == null) ? null: p.right;
    }
    
	public void loop(){
		loop(root);
	}
	
	private void loop(RBTreeNode<K,V> node){
		if(node != null){
			loop(node.left);
			System.out.println("key= "+node.key + " value= "+node.value + " color= "+node.color);
			loop(node.right);
		}
	}
	
	public int height(){
		return height(root);
	}
	
	private int height(RBTreeNode<K,V> node){
		if(node == null){
			return 0;
		} else {
			int m = height(node.left);
			int n = height(node.right);
			return (m > n) ? (m+1) : (n+1); 
		}
	}
}
