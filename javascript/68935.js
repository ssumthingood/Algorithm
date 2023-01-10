//https://programmers.co.kr/learn/courses/30/lessons/68935

function solution(n) {
    var answer = 0;
    var third = n.toString(3).split('');
    console.log(third)
    for (i=0;i<third.length;i++){
        answer +=parseInt(third[i]) * (3**i);
    }
    
    return answer;
}