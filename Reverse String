/*Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".*/

import java.util.Scanner;

public class Solution 
{
    public static String reverseString(String s) 
    {
        char[] reverse = s.toCharArray();
        int i = reverse.length;
        i--;
        int j = 0;
        char temp;
        while(j<=i)
        {
            temp = reverse[i];
            reverse[i--] = reverse[j];
            reverse[j++] = temp;
        }
        String reserveans = new String(reverse);
        return reserveans;
    }

    public static void main(String[] args)
    {
        String s;
        Scanner sc = new Scanner(System.in);
        s=sc.nextLine();
        String output = reverseString(s);
    }
}
