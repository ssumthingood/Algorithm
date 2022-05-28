//https://programmers.co.kr/learn/courses/30/lessons/1845

function solution(nums) {
    var answer = 0;
    var num = nums.length/2;
    var numSet = new Set(nums);
    (num>numSet.size) ? (answer = numSet.size):(answer = num);
    return answer;
}