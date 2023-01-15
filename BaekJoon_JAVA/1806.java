package org.opentutorials.javatutorials.eclipse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class java1806 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int answer = N+1;
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
//		for(int i=0;i<N;i++) {
//			int sum = arr[i];
//			int count = 1;
//			if(sum >=S) {
//			answer = count;
//			break;	
//			}
//			
//			if(i<N-1) {
//				for(int j = i+1;j<N;j++) {
//				sum +=arr[j];
//				count++;
//				if(sum >=S) {
//					answer = Math.min(answer, count);
//					break;
//					}
//				}
//			}
//			
//		} 시간 초과 - O(N^2)
		
		int sum = 0;
		int last = 0;
		int count = 0;
		for(int i=0;i<N;i++) {
			while(sum <S && last<N) {
				count++;
				sum +=arr[last];
				last++;
			}
			if(sum >=S) {
				answer = Math.min(answer, count);	
			}
			sum -=arr[i];
			count--;
		}// two pointer 알고리즘 - O(N)
		
		if(answer == N+1) answer = 0;
		System.out.println(answer);
	}
}