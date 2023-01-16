//https://school.programmers.co.kr/learn/courses/30/lessons/42883

function solution(number, k) {
    const stack = [];
    let answer = "";

    for (let i = 0; i < number.length; i++) {
        const el = number[i];
        while (k > 0 && stack[stack.length - 1] < el) {
            stack.pop();
            k--;
            //INDEX순서대로 스택에 넣고 다음 수가 스택의 마지막 수보다 크면 pop 후(최대 k번) 다음 수를 스택에 push
        }
        stack.push(el);
    }
    stack.splice(stack.length - k, k);
    //어차피 연산 끝나면 k가 0인데 splice는 왜 하는걸까 - 4321이런식으로 k가 0이 되지 않는 경우도 있기 때문
    answer = stack.join("");
    return answer;
}
