/*
1. The gray code is a binary numeral system where two successive numbers differ in only one bit.
 2. Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

 Example 1:
 Input: 2
 Output: [0,1,3,2]
 Explanation:
 00 - 0
 01 - 1
 11 - 3
 10 - 2
 [0,2,3,1] is also a valid gray code sequence.
 00 - 0
 10 - 2
 11 - 3
 01 - 1
Input Format
First line contains n(number of digits).
Output Format
Return the list of numbers in any valid order.
Constraints
0<=n<=20
Sample Input
2
Sample Output
[0, 1, 2, 3]

 */

package practice.algorithms.bitmanupulation;

import java.util.*;

public class GrayCode {

    public static List<String> grayCode(int n) {
        if(n == 0){
            ArrayList<String> basecase = new ArrayList<>();
            basecase.add("0");
            return basecase;
        }

        if(n == 1){
            ArrayList<String> basecase = new ArrayList<>();
            basecase.add("0");
            basecase.add("1");
            return basecase;
        }
        List<String> result = grayCode(n-1);
        ArrayList<String> myresult = new ArrayList<>();
        for(String s: result){
            myresult.add("0"+s);
        }
        for(int i=result.size()-1;i>=0;i--){
            myresult.add("1"+result.get(i));
        }
        return myresult;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        List<String> result=grayCode(scn.nextInt());
        List<Integer> ans =new  ArrayList<>();
        for(String s: result){
            ans.add(Integer.parseInt(s,2));
        }

        Collections.sort(ans);
        System.out.println(ans);
    }
}