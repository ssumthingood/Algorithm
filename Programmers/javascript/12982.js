//https://programmers.co.kr/learn/courses/30/lessons/12982

function solution(d, budget) {
    var answer = 0;
    d.sort((a,b) => a-b);
    
    while(d[0] <= budget){
        budget = budget-d[0];
        d.shift();
        answer++;
    }
    return answer;
}