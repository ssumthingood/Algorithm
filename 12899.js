//https://programmers.co.kr/learn/courses/30/lessons/12899

function solution(n) {
    var answer= '';
    var converted = '';

    while(n>0){
        var remain = n%3;
        switch(remain){
            case 0 : converted = converted+'4';
                n = parseInt((n-1)/3);
                break;
             case 1 : converted = converted+'1';
                n = parseInt((n-1)/3);
                break; 
            case 2 : converted = converted+'2';
                n = parseInt((n-1)/3);
                break;
        }
    }
    var answer = converted.split('').reverse().join('');
    return answer;
}