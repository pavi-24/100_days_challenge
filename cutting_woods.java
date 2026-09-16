/*
We have a long piece of timber with a length of 
L meters.
For each 
x=1,2,…,L−1, there is a mark called Mark 
x at 
x meters from the left end of the piece.

You are given 
Q queries, the 
i-th of which is represented as a pair of numbers 
(c 
i
​
 ,x 
i
​
 ).
Process the queries in ascending order of 
i as described below.

If 
c 
i
​
 =1: cut the piece at Mark 
x 
i
​
  into two.
If 
c 
i
​
 =2: choose the piece with Mark 
x 
i
​
  on it and print its length.
Here, for both kinds of queries 
c 
i
​
 =1,2, it is guaranteed that there will have been no cut at Mark 
x 
i
​
  when the query is to be processed.

Constraints
1≤L≤10 
9
 
1≤Q≤2×10 
5
 
c 
i
​
 =1,2 
(1≤i≤Q)
1≤x 
i
​
 ≤L−1 
(1≤i≤Q)
For every 
i 
(1≤i≤Q), the following holds: there is no 
j such that 
1≤j<i and 
(c 
j
​
 ,x 
j
​
 )=(1,x 
i
​
 ).
All values in input are integers.
Input
Input is given from Standard Input in the following format:

L 
Q
c 
1
​
  
x 
1
​
 
c 
2
​
  
x 
2
​
 
⋮
c 
Q
​
  
x 
Q
​
 
Output
Print the number of lines equal to the number of queries 
c 
i
​
 =2. In the 
j-th line, print the response to the 
j-th such query.

Sample Input 1
Copy
5 3
2 2
1 3
2 2
Sample Output 1
Copy
5
3
At the time of the first query, no cut has been made, so the piece with Mark 
2 has a length of 
5 meters. Thus, you should print 
5.
In the second query, the piece is cut into two pieces with lengths of 
3 and 
2 meters.
At the time of the third query, the piece with Mark 
2 has a length of 
3 meters, so you should print 
3.

Sample Input 2
Copy
5 3
1 2
1 4
2 3
Sample Output 2
Copy
2
Sample Input 3
Copy
100 10
1 31
2 41
1 59
2 26
1 53
2 58
1 97
2 93
1 23
2 84
Sample Output 3
Copy
69
31
6
38
38
*/
import java.util.*;
class cutting_woods{
    public static void main(String[] a){
        Scanner sc=new Scanner(System.in);
        int L=sc.nextInt();
        int Q=sc.nextInt();
        TreeSet<Integer> s=new TreeSet<>();
        s.add(0);
        s.add(L);
        while(Q-->0){
            int c=sc.nextInt();
            int x=sc.nextInt();
            if(c==1){
                s.add(x);
            }
            else{
                int right=s.higher(x);
                int left=s.lower(x);
                System.out.println(right-left);
            }
        }
    }
}
