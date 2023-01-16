//https://school.programmers.co.kr/learn/courses/30/lessons/42587

function solution(priorities, location) {
    var answer = 0;
    let documents = priorities.map((priority, documentLocation) => [documentLocation, priority]);
    console.log(documents);
    let locationPrinted = false; //제시된 LOCATION의 문서가 프린트되었는지
    while (!locationPrinted) {
        const shifted = documents.shift(); //맨 앞의 문서 분리
        let printAvailable = true; //프린트 가능한지 확인 플래그
        for (let i = 0; i < documents.length; i++) {
            if (shifted[1] < documents[i][1]) {
                printAvailable = false; //하나라도 우선도 높은 다른 문서가 있으면 프린트X
                break;
            }
        }
        if (printAvailable) {
            answer += 1;
            if (shifted[0] === location) locationPrinted = true; //프린트 가능일 경우 내가 제시받은 location인지 확인
        } else {
            documents.push(shifted); //프린트 불가능할 경우 맨 뒤로
        }
    }
    return answer;
}
