//https://school.programmers.co.kr/learn/courses/30/lessons/86491

function solution(sizes) {
    var w = 0;
    var h = 0;
    var answer = 0;
    for (item of sizes) {
        item.sort((a, b) => a - b); //js에서의 SORT함수는 다른 언어와 다르다!! - COMPARE 함수 지정이 중요
    }
    for (item of sizes) {
        if (item[0] > w) w = item[0];
        if (item[1] > h) h = item[1];
    }
    return w * h;
}
