/*Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.*/

import java.util.Scanner;

public class Anagram 
{
    
    public boolean isAnagram(String s, String t) 
    {
       char b = (char)-2;
       char[] temp1 = s.toCharArray();
       char[] temp2 = t.toCharArray();
       int i;
       loop: for(i=0;i<temp2.length;i++)
       {
           int j=0;
           for(j=0;j<temp2.length;j++)
             if(temp1[i]==temp2[j])
                {
                    temp2[j]= 49;
                    continue loop;
                }
       }
		for(i=0;i<temp2.length;i++)
            if(temp2[i]!=49)
                return false;    
    
        return true;
    }
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String t = sc.nextLine();
		Anagram ana = new Anagram();
		boolean ans = ana.isAnagram(s,t);
		System.out.println(ans);
	}
}
