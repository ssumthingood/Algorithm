import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int M = sc.nextInt();
             
            int[] arr = new int[N];
            int[] arr2 = new int[M];
            for(int i = 0;i<arr.length; i++) {arr[i]=sc.nextInt();}
            for(int i = 0;i<arr2.length; i++) {arr2[i]=sc.nextInt();}
            int big = 0;
             
            if(N>M){
                for(int i=0;i<N-M+1;i++){
                    int sum = 0;
                    for(int j=0;j<M;j++){
                        sum += arr[i+j]*arr2[j];
                    }
                    big = Math.max(big, sum);
                }
            }
             
            else if(M>N){
                        for(int i=0;i<M-N+1;i++){
                                int sum = 0;
                                for(int j=0;j<N;j++){
                                    sum += arr[j]*arr2[i+j];
                                }
                                big = Math.max(big, sum);
                            }
            }
             
            else {
            int sum = 0;
                for(int i = 0;i<N;i++){
                sum +=arr[i]*arr2[i];
                }
                big = Math.max(big, sum);
            }
             
            System.out.println("#"+test_case+" "+big);
        }
    }
}