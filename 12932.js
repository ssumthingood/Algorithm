//https://school.programmers.co.kr/learn/courses/30/lessons/12932

function solution(n) {
    var arr = n.toString().split("").reverse();
    console.log(arr);
    for (var i = 0; i < arr.length; i++) {
        arr[i] = parseInt(arr[i]);
    }
    var answer = arr;
    return answer;
}
