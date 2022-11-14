//https://school.programmers.co.kr/learn/courses/30/lessons/12909?language=javascript

function solution(s) {
    let cnt = 0;

    for (let i = 0; i < s.length; i++) {
        if (s[i] === "(") cnt++;
        else cnt--;
        if (cnt < 0) {
            return false;
        }
    }
    if (cnt !== 0) return false;
    else return true;
}
// function solution(s){
//     var answer = true;
//     var array = s.split('');
//     var stack = [];
//     if(array[0] === ')')return false;
//     while(array.length>0){
//         stack.push(array.shift());
//         var n = stack.length;
//         if(n>1){
//             if(stack[n-1] === ')' && stack[n-2] === '('){
//                 stack.splice(n-2,2);
//             }
//         }
//     }

//     return stack.length === 0;
// } --- 효율성 탈락 코드
//(stack으로 설정한게 문제인듯? 해결 위해 스택 말고 '('와')' 의 개수만 숫자 변수 count로 설정)
