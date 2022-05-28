//https://programmers.co.kr/learn/courses/30/lessons/42840

function solution(answers) {
    var score = new Array(3).fill(0);
    var first = [1,2,3,4,5];
    var second = [2,1,2,3,2,4,2,5];
    var third = [3,3,1,1,2,2,4,4,5,5];
    var smart = [];
    for (i=0;i<answers.length;i++){
        if(answers[i] === first[i%first.length]){
            score[0]++;
        }
        if(answers[i] === second[i%second.length]){
            score[1]++;
        }
        if(answers[i] === third[i%third.length]){
            score[2]++;
        }
    }
    var high = Math.max(score[0],score[1],score[2]);
    for(i=0;i<score.length;i++){
        if(high===score[i]){
            smart.push(i+1);
        }
    }
    
    return smart;
}