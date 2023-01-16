//https://school.programmers.co.kr/learn/courses/30/lessons/43163
function solution(begin, target, words) {
    var answer = 51;
    var visited = Array(words.length).fill(false);

    function change(mybegin, target, words, process) {
        console.log(process + "번 수행");
        if (mybegin === target) {
            if (answer >= process) {
                answer = process;
            }
            console.log("find");
            return;
        }

        for (var n = 0; n < words.length; n++) {
            var begins = [...mybegin];
            var word = [...words[n]];
            var count = 0;
            for (var i = 0; i < word.length; i++) {
                if (begins[i] === word[i]) count++;
            }
            if (word.length - count === 1) {
                if (!visited[n]) {
                    visited[n] = true;
                    console.log("프로세스 증가");
                    change(words[n], target, words, process + 1);
                    visited[n] = false;
                }
            }
        }
    }

    change(begin, target, words, 0);
    if (answer === 51) {
        answer = 0;
    }
    return answer;
}
