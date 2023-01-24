package org.opentutorials.javatutorials.eclipse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class java10103 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int chang = 100;
        int sang = 100;
        int N = Integer.parseInt(st.nextToken());
        for(int i=0;i<N;i++) {
        	st = new StringTokenizer(br.readLine());
        	int changS = Integer.parseInt(st.nextToken());;
        	int sangS = Integer.parseInt(st.nextToken());
        	if(changS > sangS) {
        		sang -= changS;
        		if(sang <0) sang =0;
        	}else if(changS < sangS) {
        		chang -= sangS;
        		if(chang <0) chang =0;
        	}else {
        		continue;
        	}
        }
        System.out.println(chang);
        System.out.println(sang);
	}

}
