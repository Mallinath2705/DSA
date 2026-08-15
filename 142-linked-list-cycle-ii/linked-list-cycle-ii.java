/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {

        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast)
            {
                /*  pahila apan normal check kel tr both point he -4 la same bhetle
                    
                    but apan ata je te slow pointer jith hot tith ch theun ek new ptr firavnar from start mhnje te again check krel

                    and te new pointer fkt ekda ch next vr jail (single step travel krel ) and slow too and then te dogh means new 
                    pointer and slow (adhi chya jagevrun continue kelel) jya point la ektra yetil te asel Ans !! 
                */
                ListNode pointer=head;
                while(pointer!=slow)
                {
                    pointer=pointer.next;
                    slow=slow.next;
                }
                return pointer;
            }

        }
        return null;
    }
}