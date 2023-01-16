//https://programmers.co.kr/learn/courses/30/lessons/67256

function solution(numbers, hand) {
    return testfunc(numbers, hand);
}

const testfunc = (a, b) =>{
    var hand = '';
    var keypad = [[1,2,3],[4,5,6],[7,8,9],['*',0,'#']];
    var leftindex = [3,0];
    var rightindex = [3,2];

    a.map(number=>{
        var numindex = [0,0];
        
        switch(number){
            case 1:
                hand = hand.concat('L');
                leftindex = [0,0]; break;
            case 4:
                hand = hand.concat('L');
                leftindex = [1,0]; break;
            case 7:
                hand = hand.concat('L');
                leftindex = [2,0]; break;
            case 3:
                hand = hand.concat('R');
                rightindex = [0,2]; break;
            case 6:
                hand = hand.concat('R');
                rightindex = [1,2]; break;
            case 9:
                hand = hand.concat('R');
                rightindex = [2,2]; break;
            default:
                for (i=0; i<keypad.length; i++){
                for (j=0; j<keypad[i].length; j++){
                if(keypad[i].indexOf(number)!==-1){
                numindex = [i,keypad[i].indexOf(number)];
                    }
                }
            }
            var leftdistance = Math.abs(leftindex[0]-numindex[0])+Math.abs(leftindex[1]-numindex[1]);
            var rightdistance = Math.abs(rightindex[0]-numindex[0])+Math.abs(rightindex[1]-numindex[1]);
            if(leftdistance === rightdistance){
                switch(b){
                    case 'left':
                        hand = hand.concat('L');
                        leftindex = numindex;
                        break;
                    case 'right':
                        hand = hand.concat('R');
                        rightindex = numindex;
                        break;
                }
            }else if(leftdistance < rightdistance){
                hand = hand.concat('L');
                leftindex = numindex;
            }else{
                hand = hand.concat('R');
                rightindex = numindex;
            }; break;
        }   
    });
    return hand;
}