//https://programmers.co.kr/learn/courses/30/lessons/12977

function solution(nums) {
    var answer = 0;
    
    var ans = []; // 조합이 저장될 배열
    for(let i=0; i<nums.length; i++){
        for(let j=0; j<nums.length; j++){
            for(let k=0; k<nums.length; k++) {
            // 중복 배제
            if( i === j || j === k || k === i || i>j || i>k || j>k ) continue;
            const current = [ nums[i], nums[j], nums[k] ];
            ans.push(current);
            }
        }
    }
    
    ans.map((data)=>{
        var sum = 0;
        for(value of data){
            sum +=value;
        }
        if(isPrime(sum)){
            answer++;
        }
    })
    return answer;
}

function isPrime(number){
    if(number === 2) {
        return true;
    }
    for(let i = 2; i <= Math.floor(Math.sqrt(number)); i++){
        if(number % i === 0){
        // 한 번이라도 나누어 졌으니 소수가 아니므로 return false
        return false; 
        }
    }
  // 나눠진 수가 없다면 해당 수는 소수이므로 return true
  return true; 
}