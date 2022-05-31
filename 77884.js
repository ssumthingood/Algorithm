//https://programmers.co.kr/learn/courses/30/lessons/77884

function solution(left, right) {
    var answer = 0;
    for(i=left;i<right+1;i++){
        var count = 0;
        for(j=1;j<i+1;j++){
            if(i%j ===0){
                count++;
            }
        }
        if(count%2 ===0){
            answer +=i;
        }else{
            answer -=i;
        }
    }
    
    return answer;
}

//약수의 개수를 너무 무식하게 구했다. 생각해보니 제곱근이 정수면 무조건 약수가 홀수개다.