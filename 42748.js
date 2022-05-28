//https://programmers.co.kr/learn/courses/30/lessons/42748

function solution(array, commands) {
    var answer = [];
    for(data of commands){
        var sliced = array.slice(data[0]-1,data[1]);
        sliced.sort((a,b)=> a-b);
        answer.push(sliced[data[2]-1])
    }
    
    return answer;
}