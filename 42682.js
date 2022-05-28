//https://programmers.co.kr/learn/courses/30/lessons/42862

function solution(n, lost, reserve) {
    var clothes = [];
    var able = 0;
    for(i=0;i<n;i++){
        clothes[i] = 1;
    }    
    for (res of reserve){
        clothes[res-1] = clothes[res-1]+1;
    }
    for(los of lost){
        clothes[los-1] = clothes[los-1]-1;
    }
    console.log(clothes);
    
    for(i=0;i<n;i++){
        if(i===0){
            if(clothes[i]>1 && clothes[i+1]<1){
                clothes[i] = clothes[i]-1;
                clothes[i+1] = clothes[i+1]+1;
            }
        }else if(i===clothes.length-1){
            if(clothes[i]>1 && clothes[i-1]<1){
                clothes[i] = clothes[i]-1;
                clothes[i-1] = clothes[i-1]+1;
            }
        }else{
            if(clothes[i]>1 && clothes[i-1]<1){
                clothes[i] = clothes[i]-1;
                clothes[i-1] = clothes[i-1]+1;
            }
            if(clothes[i]>1 && clothes[i+1]<1){
                clothes[i] = clothes[i]-1;
                clothes[i+1] = clothes[i+1]+1;
            }
        }
    }
    console.log(clothes);
    for(cloth of clothes){
        switch(cloth){
            case 0: break;
            default: able++; break;
        }
    }
    var answer = able;
    return answer;
}