package algorithm;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Definition for singly-linked list.
 * */
 class ListNode {
      int val;
      ListNode next;
      public ListNode(int x) { val = x; }
 }
 
public class Solution {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution s = new Solution();
		/**
		ListNode l1 = new ListNode(1);
		ListNode l11 = new ListNode(4);
		ListNode l12 = new ListNode(9);
		ListNode l13 = new ListNode(6);
		l1.next = l11;
		l11.next = l12;
		l12.next = l13;
		
		ListNode l2 = new ListNode(9);
		ListNode l21 = new ListNode(9);
		ListNode l22 = new ListNode(4);
		l2.next = l21;
		l21.next = l22;
		
		
		ListNode  l =  s.addTwoNumbers(l1,l2);
		
		ListNode  p = l;
		while(p != null){
			System.out.println(p.val);
			p = p.next;
		}
		*/
//		System.out.println(s.lengthOfLongestSubstring(new String("abcabcbb")));
//		System.out.println(s.lengthOfLongestSubstring(new String("dvdf")));
//		System.out.println(s.lengthOfLongestSubstring(new String("aab")));
//		System.out.println(s.lengthOfLongestSubstring(new String("bbbbb")));
//		System.out.println(s.lengthOfLongestSubstring(new String("dvdfva")));
//		System.out.println(s.lengthOfLongestSubstring(new String("pwwkew")));
//		System.out.println(s.lengthOfLongestSubstring(new String("abba")));
	}

	public int[] twoSum(int[] nums, int target) {
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	int[] index = new int[2];
    	
		for(int i = 0 ; i < nums.length ;i++){
			if(map.get(target - nums[i]) != null){
				index[0] = map.get(target - nums[i]);
				index[1] = i;
				break;
			}
			map.put(nums[i], i);
		}
		return index;
    }
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode p1  = l1;
		ListNode p2  = l2;
		
		ListNode next  = null;
		ListNode curr  = head;
		
		while(p1 != null ||  p2 != null){
			int sum = 0;
			if(p1 != null){
				sum += p1.val;
				p1 = p1.next;
			}
			if(p2 != null){
				sum += p2.val;
				p2 = p2.next;
			}
			
			int s = (curr.val+sum)/10;
			int m = (curr.val+sum)%10;
			
			curr.val = m;
			
			if(s > 0 || p1 != null  || p2 != null){
				next = new ListNode(s);
			} else {
				next = null;
			}
			
			curr.next = next;
			curr = next;
		}
		
		return head;
    }
}
