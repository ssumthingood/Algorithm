//https://programmers.co.kr/learn/courses/30/lessons/64061

function solution(board, moves) {
    var answer = 0;
    var basket = [];
    
    for (j=0;j<moves.length;j++){
        for(i=0;i<board.length;i++){
            if(board[i][moves[j]-1] > 0){
                basket.push(board[i][moves[j]-1]);
                board[i][moves[j]-1]=0;
                break;
            }else{
                continue;
            }
        }
    }
        
    if(basket.length>1){
      for(i=1;i<basket.length;i++){
        if(basket[i] ===basket[i-1]){
            basket.splice(i-1,2);
            answer = answer+2;
            i=0;
            }
        }  
    }
    
    return answer;
}