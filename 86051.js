//https://programmers.co.kr/learn/courses/30/lessons/86051

function solution(numbers) {
    var mynum = [];
    
    for(i=0;i<10;i++){
        mynum.push(i);
    }
    var sumnum = mynum.filter(function(data){
        return numbers.indexOf(data)>-1 ? false:true;
    })
    console.log(sumnum);
    var answer = 0;
    
    for (value of sumnum){
        answer +=value;
    }
    return answer;
}