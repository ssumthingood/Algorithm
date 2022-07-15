//https://school.programmers.co.kr/learn/courses/30/lessons/12912

function solution(a, b) {
    var answer = 0;
    var go = [a, b];
    go.sort((a, b) => a - b);
    for (var i = go[0]; i <= go[1]; i++) {
        answer += i;
    }

    return answer;
}
