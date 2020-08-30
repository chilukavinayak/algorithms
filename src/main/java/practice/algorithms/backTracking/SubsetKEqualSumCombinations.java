/*
1. You are given an array of n distinct integers.
2. You have to divide these n integers into k non-empty subsets such that sum of integers of every
     subset is same.
3. If it is not possible to divide, then print "-1".

Note -> Check out the question video and write the recursive code as it is intended without
               changing signature. The judge can't force you but intends you to teach a concept.
Input Format
A number n
n distinct integers
A number k
Output Format
Check the sample ouput and question video.
Constraints
1 <= n <= 20
1 <= arr[i] <= 100
1 <= k <= n
Sample Input
6
1
2
3
4
5
6
3

 */

package practice.algorithms.backTracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubsetKEqualSumCombinations {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int sum = 0;
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
            sum += nums[i];
        }
        int k = sc.nextInt();
        if(sum%k != 0 || k > n){
            System.out.println(-1);
            return;
        }
        List<List<Integer>> subSet = new ArrayList<>();
        for(int i=0;i<k;i++){
            subSet.add(new ArrayList<>());
        }
        solution(0,0,n,k,nums,subSet);

    }

    private static void solution(int i,int nes, int n, int k, int[] nums, List<List<Integer>> subSet) {
        if(i >= n){
            boolean flag = false;
            if(nes == k){
               for(int j=1;j<subSet.size();j++){
                   if(subSet.get(j).stream().mapToInt(s -> s).sum() != subSet.get(j-1).stream().mapToInt(s -> s).sum()){
                       flag = true;
                   }
               }
               if(!flag){
                   System.out.println(subSet);
               }
            }
            return;
        }

        for(int j=0;j<subSet.size();j++){
            if(subSet.get(j).size() > 0){
                subSet.get(j).add(nums[i]);
                solution(i+1,nes,n,k,nums,subSet);
                subSet.get(j).remove(subSet.get(j).size()-1);
            }else{
                subSet.get(j).add(nums[i]);
                solution(i+1,nes+1,n,k,nums,subSet);
                subSet.get(j).remove(subSet.get(j).size()-1);
            }
        }

    }

}
