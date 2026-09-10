class Solution {
    public boolean isValid(String s) 
    {
        Stack<Character>stackk=new Stack<>();
        int i=0;


        while(i<s.length())
        {
            if(stackk.isEmpty() || s.charAt(i)=='(' ||s.charAt(i)=='['||s.charAt(i)=='{')
            {
                stackk.push(s.charAt(i));
            }
            else
            {
                if(s.charAt(i)==')' && stackk.peek()=='('  || 
                    s.charAt(i)==']' && stackk.peek()=='[' ||
                    s.charAt(i)=='}' && stackk.peek()=='{')
                {
                    stackk.pop();
                }
                else
                {
                    return false;
                }
            }
            i++;
        } 
        if(stackk.isEmpty())
        {
            return true;
        }   
        
        return false;
    }
}