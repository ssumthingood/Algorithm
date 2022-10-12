//https://school.programmers.co.kr/learn/courses/30/lessons/12952?language=javascript

function solution(n) {
    var answer = 0;
    let queen = Array(n).fill(0); //[0,0,0,0]의 배열 생성(퀸이 줄의 몇번째 칸에 위치하는지 나타냄)
    for (let i = 0; i < n; i++) {
        queen[0] = i; //1번째 줄의 i번째 칸에 퀸 위치
        dfs(1); //1번째 줄부터 dfs 시작
    }

    function dfs(row) {
        //row번째 줄부터 조건에 맞는 dfs 시작
        if (n === row) {
            answer++; //row가 n에 도달한다면 dfs탐색이 완료되어 조건에 맞는 경우를 찾은 것이므로 answer++
        }
        for (var col = 0; col < n; col++) {
            queen[row] = col; //row번째 줄에 들어가는 퀸은 col번째 칸에 위치
            var check = true; //조건 만족 체크
            for (var i = 0; i < row; i++) {
                //첫줄부터 row줄까지 돌면서 조건판별
                if (queen[row] === queen[i]) {
                    check = false;
                    break;
                }
                if (Math.abs(queen[row] - queen[i]) === Math.abs(i - row)) {
                    check = false;
                    break;
                }
            }
            if (check) dfs(row + 1);
        }
    }
    return answer;
}
