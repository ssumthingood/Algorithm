//https://programmers.co.kr/learn/courses/30/lessons/76501

function solution(absolutes, signs) {
    var answer = 0;
    
    for(i=0;i<absolutes.length;i++){
        if(signs[i]){
            answer+=absolutes[i];
        }else{
            answer+=absolutes[i]*(-1);
        }
    }
    
    return answer;
}