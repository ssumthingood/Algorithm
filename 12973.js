//https://school.programmers.co.kr/learn/courses/30/lessons/12973

function solution(s) {
    var answer = 0;
    var stack = [];
    stack.push(s[0]);
    for (i = 1; i < s.length; i++) {
        if (stack[stack.length - 1] === s[i]) {
            stack.pop();
        } else {
            stack.push(s[i]);
        }
    }
    answer = stack.length === 0 ? 1 : 0;
    return answer;
}

//O(n) 으로 끊어야 효율성 통과
