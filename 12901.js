//https://programmers.co.kr/learn/courses/30/lessons/12901

function solution(a, b) {
    var days = ['FRI','SAT','SUN','MON','TUE','WED','THU'];
    var nums = 0;
    var months = a-1;
    for(i=0;i<months;i++){
        switch(i){
            case 0: nums +=30; break; //1월 끝까지
            case 1: nums +=29; break; //2월 끝까지
            case 2: nums +=31; break; //3월 끝까지
            case 3: nums +=30; break; //4월 끝까지
            case 4: nums +=31; break; //5월 끝까지
            case 5: nums +=30; break; //6월 끝까지
            case 6: nums +=31; break; //7월 끝까지
            case 7: nums +=31; break; //8월 끝까지
            case 8: nums +=30; break; //9월 끝까지
            case 9: nums +=31; break; //10월 끝까지
            case 10: nums +=30; break; //11월 끝까지    
        }
    }
    if(months !==0){
        nums +=b
    }else{
        nums +=(b-1)
    }
    var answer = days[nums%7];
    return answer;
}