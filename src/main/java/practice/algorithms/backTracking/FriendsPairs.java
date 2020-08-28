package practice.algorithms.backTracking;

import java.util.Scanner;

/*
1. You are given an integer n, which represents n friends numbered from 1 to n.
2. Each one can remain single or can pair up with some other friend.
3. You have to print all the configurations in which friends can remain single or can be paired up.

Note -> Check out the question video and write the recursive code as it is intended without
               changing signature. The judge can't force you but intends you to teach a concept.
Input Format
A number n
Output Format
Check the sample ouput and question video.
Constraints
1 <= n <= 10
Sample Input
3
Sample Output
1.(1) (2) (3)
2.(1) (2,3)
3.(1,2) (3)
4.(1,3) (2)

 */
public class FriendsPairs {
    public static int count = 1;
    public static void findPairOfFriends(int i,int n,boolean[] used,String asf){
        if(i > n){
            System.out.println(count+"."+asf);
            count++;
            return;
        }
        if(used[i]){
            findPairOfFriends(i+1,n,used,asf);
        }
        else {
            used[i] = true;
            findPairOfFriends(i + 1, n, used, asf + "(" + i + ") ");
            for (int j = i + 1; j <= n; j++) {
                if(used[j] == false){
                    used[j] = true;
                    findPairOfFriends(i + 1, n, used, asf + "(" + i + "," + j + ") ");
                    used[j] = false;
                }
            }
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] used = new boolean[n+1];
        findPairOfFriends(1,n,used,"");
    }
}
