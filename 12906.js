//https://school.programmers.co.kr/learn/courses/30/lessons/12906?language=javascript

function solution(arr) {
    var answer = [];
    answer.push(arr[0]);
    for (var i = 1; i < arr.length; i++) {
        if (arr[i - 1] !== arr[i]) answer.push(arr[i]);
    }

    return answer;
}
