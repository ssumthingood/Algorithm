//https://school.programmers.co.kr/learn/courses/30/lessons/43165
function solution(numbers, target) {
    var answer = 0;
    const plusMinus = [1, -1];
    const length = numbers.length;

    var status = 0;
    function DFS(array, start) {
        if (start === length) {
            // console.log("finish status ="+status);
            if (status === target) {
                // console.log("good");
                answer++;
            }
        } else {
            for (var i = 0; i < 2; i++) {
                var lastplus = array[start] * plusMinus[i];
                status += lastplus;
                // console.log(lastplus+"더함");
                DFS(array, start + 1);
                status -= lastplus;
            }
        }
    }

    DFS(numbers, 0);
    return answer;
}
