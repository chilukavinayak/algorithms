/*
Question
1. You are given two integers n and k, where n represents number of elements and k represents
     number of subsets.
2. You have to partition n elements in k subsets and print all such configurations.

Note -> Check out the question video and write the recursive code as it is intended without
               changing signature. The judge can't force you but intends you to teach a concept.
Input Format
A number n
A number k
Output Format
Check the sample ouput and question video.
Constraints
1 <= n <= 10
1 <= k <= 10
Sample Input
3
2
Sample Output
1. [1, 2] [3]
2. [1, 3] [2]
3. [1] [2, 3]
 */

package practice.algorithms.backTracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KpartitionNnumber {
    static private int counter=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc. nextInt();
        List<ArrayList<Integer>> resultSet = new ArrayList<>();
        for(int i=0;i<k;i++){
            resultSet.add(new ArrayList<>());
        }
        partition(1,n,k,resultSet,0);
    }

    private static void partition(int i, int n, int k, List<ArrayList<Integer>> resultSet, int fsc) {
        if(i > n){
            if(fsc == k){
                counter++;
                System.out.print(counter+". ");
                for(ArrayList<Integer> set: resultSet){
                    System.out.print(set+" ");
                }
                System.out.println();
            }
            return;
        }
        for(int j=0;j<resultSet.size();j++){
            if(resultSet.get(j).size() > 0){
                resultSet.get(j).add(i);
                partition(i+1,n,k,resultSet,fsc);
                resultSet.get(j).remove(resultSet.get(j).size()-1);
            }else{
                resultSet.get(j).add(i);
                partition(i+1,n,k,resultSet,fsc+1);
                resultSet.get(j).remove(resultSet.get(j).size()-1);
                break;
            }
        }


    }
}
