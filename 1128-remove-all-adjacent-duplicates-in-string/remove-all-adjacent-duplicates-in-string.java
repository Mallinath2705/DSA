class Solution {
    public String removeDuplicates(String s) 
    {
        Stack<Character>Stackk=new Stack<>();
        int lengthString=s.length();
    
        int i=0;

        while(i<lengthString)
        {
            if(Stackk.isEmpty() || s.charAt(i) != Stackk.peek())            {
                Stackk.push(s.charAt(i));
                
            }
            else
            {
                Stackk.pop();
                
            }
            i++;
        }    
        StringBuilder answer=new StringBuilder();
        for (char c : Stackk)
        {
            answer.append(c);
        }
        return answer.toString();
    }
}