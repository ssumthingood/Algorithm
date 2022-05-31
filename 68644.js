//https://programmers.co.kr/learn/courses/30/lessons/68644

function solution(numbers) {
    var answer = [];
    for(i=1;i<numbers.length;i++){
        for(j=0;j<i;j++){
            answer.push(numbers[i]+numbers[j]);
        }
    }
    answer = Array.from(new Set(answer));
    answer.sort((a,b)=>a-b);
    return answer;
}