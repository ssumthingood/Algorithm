//https://school.programmers.co.kr/learn/courses/30/lessons/42747

function solution(citations) {
    var answer = 0;
    citations.sort((a, b) => b - a);
    console.log(citations);
    for (var i = 0; i < citations.length; i++) {
        console.log("citated : " + citations[i]);
        console.log("이것 이상으로 인용된 논문 수: " + (i + 1));
        if (i + 1 <= citations[i]) {
            answer = i + 1;
        }
    }
    return answer;

    // var answer = 0;
    // citations.sort((a,b)=>b-a)
    // let h = 0
    // while(h+1<=citations[h]) h++
    // answer = h
    // return answer;
}
