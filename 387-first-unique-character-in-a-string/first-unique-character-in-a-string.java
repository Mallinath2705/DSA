class Solution {
    public int firstUniqChar(String s) 
    {
        int n=s.length();

         int [] freq=new int[26];  // 26 size ghetl cause 26 ch letters ahet a to z madhe (small Ones onlyy ! )

         for(int i=0;i<n;i++)
         {
            freq[s.charAt(i)-'a']++;
         }   
        for(int i=0;i<n;i++)
        {
            if(freq[s.charAt(i)-'a']==1)
            {
                return i;
            }
        }
            return -1;
    }
}





















// class Solution {
//     public int firstUniqChar(String s) 
//     {
//         int n=s.length();
//         HashMap<Character , Integer > mapp=new HashMap<>();

//         for(int i=0;i<n;i++)
//         {
//             char ch=s.charAt(i);
//             if(mapp.containsKey(ch))
//             {
//                 mapp.put(ch,mapp.get(ch)+1);
//             }
//             else
//             {
//                 mapp.put(ch,1);
//             }
//         }   
//         for(int i=0;i<n;i++)
//         {
//             char ch=s.charAt(i);
//             if(mapp.get(ch)==1)
//             {
//                 return i;
//             }
//         } 
//         return -1;
//     }
// }