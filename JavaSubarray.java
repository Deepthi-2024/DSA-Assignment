// Question 4: Java Subarray

// Skill Mapping: Basic

// Description: Solve the HackerRank Problem given as a link below -

// https://www.hackerrank.com/challenges/java-negative-subarray/problem
// Input (stdin)
// 5
// 1 -2 4 -5 1
// Your Output (stdout)
// 9
import java.io.*;
import java.util.*;

public class JavaSubarray {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int temp=0,count=0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[100];
        for(int i=0;i<n;i++) {
             arr[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++) {
            if(arr[i]<0) {
                count++;
            }
            temp=arr[i];
            for(int j=i+1;j<n;j++) {
                temp += arr[j];
            if(temp < 0) {
                count++;
            }
         } 
        }
        System.out.println(count);
    }
}
