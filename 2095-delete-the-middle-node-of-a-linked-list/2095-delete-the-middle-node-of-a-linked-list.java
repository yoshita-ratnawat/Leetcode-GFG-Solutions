/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null){
          return null;
        }  
        
        ListNode mid = middleNode(head);
        ListNode node = head;
        while(node.next != mid){
            node=node.next;
        }
        
        node.next=mid.next;
        return head;
    }
    
    public ListNode middleNode(ListNode head) {
        ListNode s=head;
        ListNode f=head;
        
        while(f!=null && f.next!=null){
            s=s.next;
            f=f.next.next;
        }
        
        return s;
    }
}