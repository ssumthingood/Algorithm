//https://programmers.co.kr/learn/courses/30/lessons/42586

function solution(progresses, speeds) {
    var answer=[];
    var days = [];
    
    for(i=0;i<progresses.length;i++){
        days.push(Math.ceil((100-progresses[i])/speeds[i]));
    }
    
    for(i=0;i<days.length;i++){
        var progress = 0;
        if( days[i] === 0 ) continue;
        progress++;
        for(j=i+1;j<days.length;j++){
            if(days[i]>=days[j]){
                progress++;
                days[j] = 0;
            }else{
                break;
            }
        }
        days[i] = 0;
        answer.push(progress);
    }
    return answer;
}