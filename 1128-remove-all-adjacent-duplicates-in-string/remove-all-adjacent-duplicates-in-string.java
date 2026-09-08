class Solution {
    public String removeDuplicates(String s) 
    {
        Stack<Character>Stackk=new Stack<>();
        // char lastpicked="";
        int lengthString=s.length();
        String answer="";
        int i=0;

        while(i<lengthString)
        {
                if(Stackk.isEmpty() || s.charAt(i) != Stackk.peek())            {
                Stackk.push(s.charAt(i));
                // lastpicked=s.charAt(i);
                i++;
            }
            else
            {
                Stackk.pop();
                i++;
            }
        }    
        for (char c : Stackk)
        {
            answer+=c;
        }
        return answer;
    }
}