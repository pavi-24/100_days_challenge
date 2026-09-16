/*
B. Evanescent
time limit per test2 seconds
memory limit per test256 megabytes
Let f(s)
 be the compressed version of a string s
, formed by replacing every maximal contiguous block of identical characters with a single copy of that character. For example, f(
"aabbcc") = 
"abc".

Let |s|
 denote the length of a string s
. Following this, |f(s)|
 denotes the length of the compressed string. For example:

|f(
"aabbcc")|=
 |
"abc"|
 =3
If the string is empty, its length is 0
.
Yousef has given you a string s
 consisting of n
 lowercase Latin letters. You must delete exactly one character si
 (2≤i≤n−1
) to form a new string s′
, and then find the minimum possible value of |f(s′)|
.

Note that you cannot delete s1
 or sn
.

Input
The first line contains an integer t
 (1≤t≤104
) — the number of test cases.

The first line of each test case contains an integer n
 (3≤n≤2⋅105
) — the length of the string.

The second line of each test case contains a string s
 (|s|=n
), consisting of lowercase Latin letters.

It is guaranteed that the sum of n
 over all test cases does not exceed 2⋅105
.

Output
For each test case, output a single integer — the minimum possible length of the resulting compressed string after deleting one character.

Example
InputCopy
9
3
abb
3
aab
3
abc
4
abaa
4
abba
5
eeeee
6
yyssee
7
abacaba
18
goodluckandhavefun
OutputCopy
2
2
2
1
3
1
3
5
16
Note
In the first test case, we can only delete the character s2=
 'b', producing a string s′=
 "ab", with |f(s′)|=2
. Therefore, 2
 is the minimum length achievable.

In the fourth test case, we can delete the character s2=
 'b'. The resulting string is s′=
 "aaa" with f(s′)=
 "a", so |f(s′)|=1
.

In the sixth test case, deleting any valid character results in f(s′)=
 "e" and |f(s′)|=1
.

In the eighth test case, we can delete the character s4=
 'c'. The resulting string is s′=
 "abaaba" with f(s′)=
 "ababa" and |f(s′)|=5
*/


import java.util.*;
class pair{
    char first;
    int second;

    pair(char first,int second){
        this.first=first;
        this.second=second;
    }
}
class evanescent{
    public static void main(String[] a){
        Scanner sc=new Scanner(System.in);
        int tc=sc.nextInt();
        while(tc-- > 0){
            int n=sc.nextInt();
            String s=sc.next();
            ArrayList<pair> v=new ArrayList<>();
            v.add(new pair(s.charAt(0),1));
            for(int i=1;i<n;i++){
                if(s.charAt(i)==v.get(v.size()-1).first){
                    v.get(v.size()-1).second++;
                }else{
                    v.add(new pair(s.charAt(i),1));
                }
            }
            boolean candel=false,merge=false;
            int t=v.size();
            for(int ctr=1;ctr<t-1;ctr++){
                if(v.get(ctr).second==1){
                    candel=true;
                    if(v.get(ctr-1).first==v.get(ctr+1).first){
                        merge=true;
                        break;
                    }
                }
            }
            int reduce=0;
            if(merge) reduce=2;
            else if(candel) reduce=1;
            System.out.println(t-reduce);
        }
    }
}