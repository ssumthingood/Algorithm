//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LrsUaDxcDFAXc

import java.util.Scanner;
 
class Solution {
 
    public static void main(String[] args) {
         
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1;tc<=T;tc++) {
            int n = sc.nextInt();
            int[] data = new int[n];
            long result=0;
            for(int i=0;i<n;i++) {
                data[i]=sc.nextInt();
            }
            int max_val= data[n-1];
            //마지막 값을 최대값으로 설정한 후 0을 향해 역순으로 내려가면서 최대값 update
            //최대값이 아닌경우 최대값과 해당 index값의 차이를 result에 더함
            //해당 index의 값이 최대값과 같거나 클 경우 최대값을 해당 index값으로 update
            for(int i=n-2;i>=0;i--) {
                if(max_val<=data[i]) {
                    max_val=data[i];
                }
                result+=max_val-data[i];
            }
            System.out.println("#"+tc+" "+result);
 
        }
    }
 
}