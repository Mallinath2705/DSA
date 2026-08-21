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

    private ListNode reverseLogic (ListNode head)
    {
        ListNode prev=null;
        while(head!=null)
        {
            ListNode next=head.next;
            head.next=prev;
            prev=head;
            head=next;

        }
        return prev;
    }
    public void reorderList(ListNode head) {
        
        if(head==null || head.next==null)
        {
            return;
        }
        ListNode slow=head;
        ListNode fast=head;

        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode secondHalfStart=slow.next;  // second half ch first element save krun ghetla 
        slow.next=null;  //Break kel Slow la 
        secondHalfStart=reverseLogic(secondHalfStart);

        ListNode p1=head;
        ListNode p2=secondHalfStart;

        while(p2!=null)
        {
            ListNode firstHalfNext=p1.next;
            ListNode secondHalfNext=p2.next;
            
            p1.next=p2;
            p2.next=firstHalfNext;

            p1=firstHalfNext;
            p2=secondHalfNext;
        }
    }
}