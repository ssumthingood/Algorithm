//https://school.programmers.co.kr/learn/courses/30/lessons/42885

function solution(people, limit) {
    var answer = 0;
    people.sort((a, b) => a - b);
    console.log(people);
    while (people.length > 0) {
        var n = people.length;
        if (people[n - 1] + people[0] > limit) {
            people.pop();
            answer++;
        } else {
            people.shift();
            people.pop();
            answer++;
        }
    }
    return answer;
}
