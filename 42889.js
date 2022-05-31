//https://programmers.co.kr/learn/courses/30/lessons/42889

function solution(N, stages) {
    var failure  = new Array(N).fill(0);
    var reaches  = new Array(N).fill(0);
    var rate  = new Array(N).fill(0);
    var sorted  = new Array(N).fill(0);
    var answer = [];
    for(stage of stages){
        if(stage<N+1){
            for(i=0;i<stage;i++){
                reaches[i]++;
            }
            failure[stage-1]++;
        }else if(stage===N+1){
            for(i=0;i<N;i++){
                reaches[i]++;
            }
        }
    }
    
    for(i=0;i<N;i++){
        if(reaches[i] !==0){
            rate[i] = failure[i]/reaches[i];
            sorted[i] = failure[i]/reaches[i];
        }else{
            rate[i] = 0;
            sorted[i] = 0;
        }
        
    };    
    sorted.sort((a,b)=>b-a);
    
    for(i=0;i<sorted.length;i++){
        for(j=0;j<rate.length;j++){
            if(sorted[i]===rate[j]){
                answer.push(j+1);
                sorted[i] = -1;
                rate[j] = -1
                break;
            }
        }
    }
    
    return answer;
}