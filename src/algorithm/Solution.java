package algorithm;

import java.util.Arrays;
import java.util.HashMap;

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
//		System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
//		System.out.println(s.lengthOfLongestSubstring("abba"));
//		System.out.println(s.lengthOfLongestSubstring("bbbbb"));
//		System.out.println(s.lengthOfLongestSubstring("pwwkew"));
//		System.out.println(s.lengthOfLongestSubstring("dvdf"));
//		System.out.println(s.lengthOfLongestSubstring("dvaadf"));
//		System.out.println(s.lengthOfLongestSubstring("dvabadfe"));
		int[] nums1 = new int[]{1,2};
		int[] nums2 = new int[]{1,2};
		
		System.out.println(s.findMedianSortedArrays(nums1, nums2));
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
	
	public int lengthOfLongestSubstring(String s) {
		HashMap<String,Integer> h = new HashMap<String,Integer>();
		int maxLength = 0;
		int curLength = 0;
		int subIndex = 0;
		
		for(int i = 1 ; i <= s.length();i++){
			String c = new String(new char[]{s.charAt(i-1)});
			
			if(h.containsKey(c)){
				int prev = h.get(c);
				if(prev > subIndex){
					subIndex = prev;
				}
			}
			
			curLength = i - subIndex;
			h.put(c, i);
			
			if(curLength > maxLength){
				maxLength = curLength;
			}
			
		}
		return maxLength;
    }
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int k1 = (nums1.length + nums2.length + 1)/2;
		int k2 = (nums1.length + nums2.length +2)/2;
		
		return (findKth(nums1,0,nums2,0,k1) + findKth(nums1,0,nums2,0,k2))/2;
    }
	
	private double findKth(int[] nums1, int istart1, int[] nums2,int istart2, int k) {
		int m = nums1.length - istart1, n = nums2.length - istart2;
		//let m<=n
		if(m > n){
			return findKth(nums2,istart2,nums1,istart1,k);
		}
		if(m == 0){
			return nums2[istart2+k-1];
		}
		if(k == 1){
			return Math.min(nums1[istart1], nums2[istart2]);
		}
		
		int pa = Math.min(k/2, m), pb = Math.min(k/2, n);
		
		if (nums1[istart1+pa-1] > nums2[istart2+pb-1]){
			return findKth(nums1,istart1,nums2,istart2+pb,k-pb);
		} else {
			return findKth(nums1,istart1+pa,nums2,istart2,k-pa);
		}
		
    }
	
}
