//https://school.programmers.co.kr/learn/courses/30/lessons/42746

function solution(numbers) {
    var answer = "";
    numbers.sort(sortFunc); //sortFunction 다루는법 익히기
    answer = numbers.join("");
    if (answer[0] === "0") return "0"; //맨앞자리가 0이면 결과도 0 ([0,0,0] 케이스 다루기 위함)
    return answer;
}

const sortFunc = (a, b) => {
    const compareA = parseInt(a.toString() + b.toString());
    const compareB = parseInt(b.toString() + a.toString());
    return compareB - compareA;
};
