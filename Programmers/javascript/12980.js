//https://school.programmers.co.kr/learn/courses/30/lessons/12980

function solution(n) {
    var ans = 0;
    while (n > 0) {
        if (n % 2 === 0) {
            n = n / 2;
        } else {
            n--;
            ans++;
        }
    }
    return ans;
}
