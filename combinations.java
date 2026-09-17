/*
Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

You may return the answer in any order.

 

Example 1:

Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
Example 2:

Input: n = 1, k = 1
Output: [[1]]
Explanation: There is 1 choose 1 = 1 total combination.
 

Constraints:

1 <= n <= 20
1 <= k <= n
*/
import java.util.*;
class combinations{
    public static int popcount(int n){
        int count=0;
        while(n!=0){
            n=n&(n-1);
            count++;
        }
        return count;
    }
    public static void main(String[] a){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        ArrayList<int[]> ans=new ArrayList<>();
        for(int ctr=(1<<k)-1;ctr<(1<<n);ctr++){
            int oc=popcount(ctr);
            if(oc==k){
                int idx=0;
                int[] combo=new int[k];
                for(int sh=0;sh<n;sh++){
                    if((ctr&(1<<sh))!=0){
                        combo[idx++]=sh+1;
                    }
                }
                ans.add(combo);
            }
        }
        for(int[] comb:ans)
        System.out.print(Arrays.toString(comb));
    }
}