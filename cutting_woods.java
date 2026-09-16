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