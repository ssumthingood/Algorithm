//https://programmers.co.kr/learn/courses/30/lessons/62048

function solution(w, h) {
    var big = Math.max(w,h);
    var small = Math.min(w,h);
    var gcd = myGcd(big,small);//최대공약수 구하기
    var total = w*h;
    
    var answer = total-(big+small-gcd);//토탈 -(가로길이 + 세로길이 - 최대공약수)
    
    return answer;
}

let myGcd=(a, b)=>{
    while(b > 0){
        let r = a % b;
        a = b;
        b = r;
    } 
    return a;
}