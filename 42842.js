//https://school.programmers.co.kr/learn/courses/30/lessons/42842
function solution(brown, yellow) {
    var answer = [];
    var garo;
    var sero;
    for (var n = 1; n <= yellow; n++) {
        if (yellow % n === 0) {
            if ((n + 2) * (yellow / n + 2) === brown + yellow) {
                sero = n + 2;
                garo = yellow / n + 2;
                break;
            }
        }
    }

    answer.push(garo);
    answer.push(sero);
    return answer;
}
