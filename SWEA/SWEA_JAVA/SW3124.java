import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int T;
    static long answer = 0;
     
    static class Edge implements Comparable<Edge>{
        int from, to, weight;
        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
     
    static int V,E;
    static Edge[] edgeList;
    static int[] parents;
     
    static void makeSet() {
        parents = new int[V];
        for(int i=0;i<V;i++) {
            parents[i] = i;
        }
    }
     
    static int findSet(int a) {
        if(a==parents[a]) {
            return a;
        }else {
            return parents[a] = findSet(parents[a]);
        }
    }
     
    static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if(aRoot == bRoot) {
            return false;
        }else {
            parents[bRoot] = aRoot;
            return true;
        }
    }
     
    public static void main(String[] args) throws IOException {
        sb = new StringBuilder();
        br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++) {
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            edgeList = new Edge[E];
            for(int i=0;i<E;i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken())-1;
                int to = Integer.parseInt(st.nextToken())-1;
                int weight = Integer.parseInt(st.nextToken());
                edgeList[i] = new Edge(from,to,weight);
            }
             
            Arrays.sort(edgeList);
             
            makeSet();
            int count =0;
             
            for(Edge edge : edgeList) {
                if(union(edge.from, edge.to)) {
                    answer +=edge.weight;
                    count++;
                    if(count == V-1) break;
                }
            }
            sb.append(answer).append("\n");
            answer =0;
        }
        System.out.print(sb);
    }
 
}