/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
*/

class Solution {
    public boolean isValid(String s) {
        Stack stack = new Stack();
        for(int i = 0; i<s.length();i++)
            switch(s.charAt(i)){
                    
                //If opening brace, push
                case '(':
                case '[':
                case '{':
                    stack.push(s.charAt(i));
                    break;
                //If closing brace, check if stack empty, pop and check for matching opening brace
                case ')':
                    if (stack.empty())
                        return false;
                    if((char)stack.pop() != '(')
                        return false;
                    break;
                case ']':
                    if (stack.empty())
                        return false;
                    if((char)stack.pop() != '[')
                        return false;
                    break;
                case '}':
                    if (stack.empty())
                        return false;
                    if((char)stack.pop() != '{')
                        return false;
                    break;
                
            }
        return stack.empty();
        
    }
}
