//https://school.programmers.co.kr/learn/courses/30/lessons/42584

import java.util.*;

class Solution {
    public int[] solution(int[] prices) {

        Queue<Integer> myQ = new LinkedList<>();
        int start = 0;
        int last = 0;
        while(start<prices.length){
            if(prices[start] > prices[last]){
                myQ.add(last-start);
                start++;
                last = start;
            }else{
                last++;
                if(last == prices.length){
                    425myQ.add(last-start-1);
                    start++;
                    last = start;
                }
            }
        }
        int[] answer = new int[myQ.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = myQ.poll();
        }
        return answer;
    }
}