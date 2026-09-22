class Solution {

    // Reverse 'times' nodes
    void reverse(ListNode head, int times)
    {
        ListNode curr = head;
        ListNode prev = null;

        while(times > 0)
        {
            ListNode nexxt = curr.next;

            curr.next = prev;

            prev = curr;
            curr = nexxt;

            times--;
        }
    }

    public ListNode swapPairs(ListNode head)
    {
        if(head == null)
        {
            return null;
        }

        ListNode left = head;
        ListNode right;

        ListNode result = null;
        ListNode prevleft = null;

        int size = 2;

        while(true)
        {
            right = left;

            // Find second node of current pair
            for(int i = 0; i < size - 1; i++)
            {
                if(right == null)
                {
                    break;
                }
                else
                {
                    right = right.next;
                }
            }

            if(right != null)
            {
                // Save next pair BEFORE reversing
                ListNode nextleft = right.next;

                // Reverse current pair
                reverse(left, size);

                // CHANGED:
                // Previous pair ला current reversed pair सोबत connect करतो
                if(prevleft != null)
                {
                    prevleft.next = right;
                }

                // CHANGED:
                // First pair नंतरही prevleft update झाला पाहिजे
                prevleft = left;

                // First reversed pair चा head
                if(result == null)
                {
                    result = right;
                }

                // Move to next pair
                left = nextleft;
            }
            else
            {
                // Odd number of nodes असल्यास
                // शेवटचा node जसाच्या तसा ठेवायचा
                if(prevleft != null)
                {
                    prevleft.next = left;
                }

                // जर पहिलाच node असेल
                if(result == null)
                {
                    result = left;
                }

                break;
            }
        }

        return result;
    }
}