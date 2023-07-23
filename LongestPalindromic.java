// Question 7: Longest Palindromic Substring

// Skill Mapping: Medium

// Description: Solve the LeetCode Problem given as a link below -

// https://leetcode.com/problems/longest-palindromic-substring/

// Example 1:

// Input: s = "babad"
// Output: "bab"
// Explanation: "aba" is also a valid answer.
// Example 2:

// Input: s = "cbbd"
// Output: "bb"


import java.util.*;
class LongestPalindromic {
    static String longestPalindrome(String s) {
        if(s==null || s.length() < 1) {
            return "";
        }
        int start =0;
        int end =0;
        for(int i=0;i<s.length()-1;i++) {
            int len1 = checkSubString(s,i,i);
            int len2 = checkSubString(s,i,i+1 );
            int len = Math.max(len1,len2);
            if(len > end - start) {
                start = i-(len-1)/2;
                end = i+len/2;
            }
        }
        return s.substring(start,end+1);
    }
    public static int checkSubString(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right-left-1;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(longestPalindrome(input));
    }
}