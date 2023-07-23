// Question 2: Find missing numbers in array -

// Skill Mapping: Basic

// Description: Consider an array with N number of consecutive integers, in which few numbers are missing. Find and list down these missing numbers using Java.

// Sample input: arrNum = {1, 2, 4, 5, 6}

// Output: 3

// Sample input: arrNum = {1, 2, 3, 5, 6, 8, 10, 11, 14}

// Output: 4, 7, 9, 12, 13
import java.util.*;
public class MissingLetters {
    public static void main(String[] args) {
        int count =1;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arrNum[] = new int[100];
        for(int i=0;i<n;i++) {
            arrNum[i] = sc.nextInt();
        }
        sc.close();
        for(int i=0;i<n;i++) {
            
            if(arrNum[i] != count) {
                System.out.print("Missing letters " + count+ "  ");
                count++; i--;
            }
            else{
                count++;
            }
        }
    }
}