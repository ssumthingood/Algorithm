//https://school.programmers.co.kr/learn/courses/30/lessons/42577?language=java

import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        
        for(int i=1;i<phone_book.length;i++){
            int j = i-1;
            String one = phone_book[i];
            String two = phone_book[j];
            
            int oneLen= one.length();
            int twoLen = two.length();
            
            if(oneLen >= twoLen){
                if(two.equals(one.substring(0,twoLen))){
                    answer = false;
                    break;
                }
            }else{
                if(one.equals(two.substring(0,oneLen))){
                    answer = false;
                    break;
                }
            }
        }

        return answer;
    }
}