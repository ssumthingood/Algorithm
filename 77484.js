//https://programmers.co.kr/learn/courses/30/lessons/77484

function solution(lottos, win_nums) {
    var a = 6;
    var b = 6;
    
    lottos.sort(function(a, b)  {
  if(a > b) return 1;
  if(a === b) return 0;
  if(a < b) return -1;
});
    win_nums.sort(function(a, b)  {
  if(a > b) return 1;
  if(a === b) return 0;
  if(a < b) return -1;
});
    
    for(i=0;i<lottos.length;i++){
        if(lottos[i]===0){
          a = a-1;   
        }
    }
    
    for(i = 0; i<win_nums.length;i++){
        for(j=0;j<lottos.length;j++){
            if(win_nums[i]===lottos[j]){
                a--;
                b--;
            }
        }
    }
    
    if(a===6){
        a = a-1;
    }
    if(b===6){
        b = b-1;
    }
    
    var answer = [a+1,b+1];
    return answer;
}