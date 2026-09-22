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
    void reverse(ListNode head , int size)
    {
        ListNode curr=head;
        ListNode prev=null;

        while(size>0)
        {
            ListNode nexxt=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nexxt;
            size--;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) 
    {
        if(head==null)
        {
            return null;
        }


            ListNode left=head;
            ListNode right;
            ListNode prevleft=null;
            ListNode result=null;


            int size =k;


            while (true)
            {
                right=left;

                for(int  i=0;i<size-1;i++) //right set krun ghetla harr tine sathi 
                {
                    if(right==null)
                    {
                        break;
                    }
                    else
                    {
                        right=right.next;
                    }
                }

                if(right!=null)
                {
                    ListNode nextleft=right.next;  //pudhch left store krun ghetl 

                    reverse(left , size);  // tevdh specific bhag reverse kela 
                


                    if(prevleft!=null) // reverse zalya vr urlele arrow ( tutlel LL la jodayla )
                    {
                        prevleft.next=right; // prevleft null nahi tr mg right la assign 
                    }
                    prevleft=left; //otherwise left la ch asing karan right ch val tya point la null astay 

                    if(result==null)
                    {
                        result=right;
                    }

                    left=nextleft;

               
                }
                  else // jr right null ahe 
                   {
                    if(prevleft!=null)
                    {
                        prevleft.next=left;
                    }
                    if(result==null)
                    {
                        result=left;
                    }
                    break;
                    }

            }
            return result;
    }
}