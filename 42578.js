//https://school.programmers.co.kr/learn/courses/30/lessons/42578

function solution(clothes) {
    console.log(clothes);
    var answer = 1;
    const spyWear = {};
    for (const clothNPart of clothes) spyWear[clothNPart[1]] = (spyWear[clothNPart[1]] || 0) + 1;
    for (const part in spyWear) answer *= spyWear[part] + 1;
    console.log(spyWear);
    return answer - 1;
}
