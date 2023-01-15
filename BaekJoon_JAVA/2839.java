package org.opentutorials.javatutorials.eclipse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class java2839 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int answer = -1;
        
        int five = N/5;
        
        while(five>=0) {
        	if((N-five*5)%3 == 0) {
        		answer = five + (N-five*5)/3;
        		break;
        	}else five--;
        }
        
        System.out.println(answer);
	}

}
