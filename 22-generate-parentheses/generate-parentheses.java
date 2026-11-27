class Solution 
{

    void funn (int open ,  int close , int n , StringBuilder temp , List<String>res)
    {

        if(open==n && close==n)
        {
            res.add(temp.toString()); // list madhe stringbuilder ch object direct add kru shakt nahi mhhnun toString() ne string madhe convert kel tya object la 
            return;
        }

        if(open < n)
        {
            temp.append('(');

            funn(open+1 , close , n , temp , res);

            temp.deleteCharAt(temp.length()-1);
        }

        if(close<open)
        {
            temp.append(')');

            funn(open , close+1 , n , temp , res);

            temp.deleteCharAt(temp.length()-1);
        }
        
    }
    public List<String> generateParenthesis(int n) 
    {
        //Final Result Store krayala he list banavla 
        List<String> res=new ArrayList<>();

        // transver  or reccurssion or backtrack hot astana elements ch hishob thevayla he stringbuilder banavla 
        StringBuilder temp= new  StringBuilder();  

        funn(0 , 0 , n , temp , res);

    return res;

    }
}