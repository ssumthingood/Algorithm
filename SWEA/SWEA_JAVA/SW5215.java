import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Solution {
    static class Burger{
        int taste;
        int kcal;
        public Burger(int taste, int kcal) {
            this.taste = taste;
            this.kcal = kcal;
        }
    }
    static int answer = 0;
    static void makeCombination(List<Burger> list, int start, int nowkcal, int taste) {
        if( list.size() ==N) {
            return;
        }
         
        for(int i=start;i<b.length;i++) {
            if(nowkcal+b[i].kcal>L) {
                return;
            }else if(nowkcal + b[i].kcal<=L) {
                list.add(b[i]);
                answer = Math.max(answer, taste+b[i].taste);
                makeCombination(list, i+1,nowkcal+b[i].kcal,taste+b[i].taste);
                list.remove(list.size()-1);
            }
        }
         
    }
    static Burger[] b;
    static BufferedReader br;
    static StringTokenizer st;
    static int T;
    static int N;
    static int L;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t = 1;t<=T;t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            b = new Burger[N];
            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());
                b[i]=  new Burger(s,k);
            }
             
            Arrays.sort(b, new Comparator<Burger>() {
                @Override
                public int compare(Burger o1, Burger o2) {
                    if(o1.kcal == o2.kcal) {
                        return -(o1.taste-o2.taste);
                    }
                    else{
                        return o1.kcal - o2.kcal;   
                    }
                }   
            });
             
            makeCombination(new ArrayList<Burger>(), 0, 0 ,0);
             
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ").append(answer);
            System.out.println(sb);
            answer = 0;
        }
    }
}