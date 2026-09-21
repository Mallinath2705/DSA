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
    public ListNode reverseBetween(ListNode head, int left, int right) 
    {
            if(head==null)
            {
                return null;
            }
            if(left==right)
            {
                return head;
            }

            ListNode t=head;
            ListNode before=null;

        for(int i=1;i<left;i++)
        {
            before=t;
            t=t.next;

            continue;
        }

        int times=right-left+1;
        
        ListNode curr= t;
        ListNode prev=null;
        while(times>0)
        {
            ListNode nexxt=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nexxt;
            times--;
        }

       t.next=curr;
       if(before !=null)
       {
        before.next=prev;
       }
       else
       {
        head=prev;
       }

        return head;
    }
}