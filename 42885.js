//https://school.programmers.co.kr/learn/courses/30/lessons/42885

function solution(people, limit) {
    var answer = 0;
    people.sort((a, b) => a - b);
    //일단 무게순으로 정렬
    console.log(people);
    while (people.length > 0) {
        var n = people.length;
        if (people[n - 1] + people[0] > limit) {
            people.pop();
            answer++;
            //가장 큰놈과 작은놈 합친 값이 무게초과면 큰놈만 태워보냄
        } else {
            people.shift();
            people.pop();
            answer++;
            //큰놈과 작은놈 무게 합이 무게기준을 만족하면 두명 태워보냄
        }
    }
    return answer;
}
