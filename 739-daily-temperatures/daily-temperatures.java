//solve again >>>>>>>
class Solution {
    public int[] dailyTemperatures(int[] temperatures) 
    {
        int n=temperatures.length;
       
        int [] res=new int[n];
       
        Stack<Integer>stackk=new Stack<>();    

        // res[n-1]=0;

        stackk.push(n-1);

        for(int i=n-2;i>=0;i--)
        {
            while(!stackk.isEmpty() && temperatures[stackk.peek()]<=temperatures[i])
            {
                stackk.pop();
            }
            if(stackk.isEmpty())
            {
                res[i]=0;
            }
            else
            {
                res[i]=stackk.peek()-i;
            }
            stackk.push(i);
        }
        return res;
    }
}