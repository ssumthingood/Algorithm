//https://school.programmers.co.kr/learn/courses/30/lessons/43162
function solution(n, computers) {
    let answer = 0;
    const visited = new Array(n).fill(false);
    //방문 상태를 나타낼 false배열
    const newNetwork = (startComputer) => {
        //새로운 네트워크를 만들 시작 컴퓨터를 파라미터로 받는다.
        const toBeVisited = [startComputer];
        while (toBeVisited.length > 0) {
            //시작 컴퓨터로부터 방문 가능한 컴퓨터를 모두 방문하며 해당 컴퓨터의 visited를 true로 바꾼다
            const currentComputer = toBeVisited.pop();
            //왜 shift랑 pop을 사용할 때가 둘 다 맞을까? - 어차피 다 방문해서 그런가?
            visited[currentComputer] = true;
            for (let nextComputer = 0; nextComputer < n; nextComputer++) {
                if (!visited[nextComputer] && computers[currentComputer][nextComputer]) {
                    toBeVisited.push(nextComputer);
                }
            }
        }
    };

    for (let startComputer = 0; startComputer < n; startComputer++) {
        if (!visited[startComputer]) {
            newNetwork(startComputer);
            //새로운 네트워크를 생성할 때마다 정답을 1 증가시킨다.
            answer++;
        }
    }
    return answer;
}
