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
    public ListNode rotateRight(ListNode head, int k) 
    {
        if(head==null || head.next==null ||k==0)
        {
            return head;
        }
        
        ListNode temp=head;
        int n=1;

        while(temp.next!=null)
        {
            n++;
            temp=temp.next;
        }

        k=k%n;

        for(int i=0;i<k;i++)
        {
            ListNode  prev=head;
            ListNode curr=prev.next;
            ListNode firstnode=head;
          
          while(curr.next!=null)
          {  
                prev=curr;
                curr=curr.next;
          }
          curr.next=firstnode;
          prev.next=null;
            head=curr;
        }    
        return head;
    }
}