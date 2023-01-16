//https://programmers.co.kr/learn/courses/30/lessons/42888

function solution(record) {
    var recorddata = [];
    var users = new Map();
    for (i=0;i<record.length;i++){
        recorddata[i] = record[i].split(' ');
    }
    var message = [];

    for(data of recorddata){
        if(data[0] !=='Leave'){
            users.set(data[1],data[2]);
        }
    }
    
    for(data of recorddata){
        switch(data[0]){
            case 'Enter': 
                message.push(users.get(data[1])+'님이 들어왔습니다.');
                break;
            case 'Leave' :
                message.push(users.get(data[1])+'님이 나갔습니다.');
                break;
            default:
                break;
        }
    }
    
    return message;
}