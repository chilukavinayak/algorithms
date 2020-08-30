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

import java.util.*;

public class SubsetKEqualSum {

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

        solution(nums,0,n,k,new int[k],0,subSet);

    }

    private static void solution(int[] arr,int vidx,int n,int k,int[] subsetSum,int nes, List<List<Integer>> ans) {
        if(vidx == arr.length){
            if(nes == k){
               boolean flag = true;
               for(int i=0;i<subsetSum.length-1;i++){
                   if(subsetSum[i] != subsetSum[i+1]){
                       flag = false;
                       break;
                   }
               }
               if(flag){
                   for(List<Integer> partition : ans){
                       System.out.print(partition+" ");
                   }
                   System.out.println();
               }
            }
            return;
        }

        for(int i=0;i<ans.size();i++){
            if(ans.get(i).size() > 0){
                ans.get(i).add(arr[vidx]);
                subsetSum[i] += arr[vidx];
                solution(arr,vidx+1,n,k,subsetSum,nes,ans);
                subsetSum[i] -= arr[vidx];
                ans.get(i).remove(ans.get(i).size()-1);
            }else{
                ans.get(i).add(arr[vidx]);
                subsetSum[i] += arr[vidx];
                solution(arr,vidx+1,n,k,subsetSum,nes+1,ans);
                subsetSum[i] -= arr[vidx];
                ans.get(i).remove(ans.get(i).size()-1);
                break;
            }
        }

    }

}
