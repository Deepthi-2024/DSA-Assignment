// Question 8: Java Stack

// Skill Mapping: Basic

// Description: Solve the HackerRank Problem given as a link below -

// https://www.hackerrank.com/challenges/java-stack/problem

// Sample Input

// {}()
// ({()})
// {}(
// []
// Sample Output

// true
// true
// false
// true

import java.util.*;
class JavaStack {
	public static boolean stack(String input){
        Stack<Character> s = new Stack<>();
       for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                s.push(ch);
            } else if (!s.isEmpty() && ((ch == ')' && s.peek() == '(') || (ch == ']' && s.peek() == '[') || (ch == '}' && s.peek() == '{'))) {
                s.pop();
            } else {
                return false;
            }
        }

        
        return s.isEmpty();
        
    }
	public static void main(String []argh)
	{
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNext()) {
			String input=sc.next();
            System.out.println(stack(input));
            //Complete the code
            
		}
		
	}
}




