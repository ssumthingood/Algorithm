//https://programmers.co.kr/learn/courses/30/lessons/70128

function solution(a, b) {
    var zuck = [];
    var sum=0;
    for(i=0;i<a.length;i++){
        zuck.push(parseInt(a[i]*b[i]));
    }
    console.log(zuck);
    for(nae of zuck){
        sum=nae+sum;
    }
    return sum;
}