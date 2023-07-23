// Question 9: Java Dequeue

// Skill Mapping: Basic

// Description: Solve the HackerRank Problem given as a link below -

// https://www.hackerrank.com/challenges/java-dequeue/problem
// Sample Input

// 6 3
// 5 3 5 2 3 2
// Sample Output

// 3

    import java.util.*;
    public class JavaDequeue {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            Deque deque = new ArrayDeque<>();
            int n = in.nextInt();
            int m = in.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int max = 0;
        for (int i = 0; i < n - m + 1; i++) {
            Set<Integer> set = new HashSet<>();
            int count = 0;

            for (int j = i; j < i + m; j++) {
                if (set.add(arr[j])) {
                    count++;
                }
            }
            max = Math.max(max, count);
        }
        System.out.println(max);
    }   
}



