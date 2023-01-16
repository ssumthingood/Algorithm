//https://school.programmers.co.kr/learn/courses/30/lessons/49993#fnref1

function solution(skill, skill_trees) {
    var answer = 0;

    //선행 스킬 목록 제시 Map - 선행스킬 없으면 설정 X
    var rank = new Map();
    for (i = 0; i < skill.length; i++) {
        var prior = [];
        for (j = i - 1; j >= 0; j--) {
            prior.push(skill[j]);
        }
        if (prior.length > 0) {
            rank.set(skill[i], prior);
        }
    }

    for (mcase of skill_trees) {
        //각 case를 mcase로 정의
        var did = true;
        var got = new Map(); //mcase내의 char(skill)들이 성공적으로 습득되었는지 확인하는 map

        for (item in mcase) {
            //제시된 스킬트리 내의 모든 스킬 대상으로 검사
            var check = mcase[item]; //익혀졌는지 확인할 스킬
            var flag = mcase.slice(0, item); //이 스킬보다 먼저 배워지려는 스킬들

            if (rank.get(check) !== undefined) {
                var isHave = true;
                var that = rank.get(check); //필수 선행목록
                for (item of that) {
                    if (!flag.includes(item)) {
                        //필수 선행목록 내의 스킬들 중 하나라도 먼저 배우려는 스킬들 목록에 없을 시
                        isHave = false;
                    }
                }
                if (isHave) got.set(check, true); //isHave가 true일 경우 성공적으로 배워짐
            } else got.set(check, true); //선행스킬이 없을시 배워지는것으로 간주
        }

        for (item of mcase) {
            if (got.get(item) === undefined) did = false; //스킬트리 내에서 성공적으로 배워지지 않은 스킬이 하나라도 있을시 false
        }
        if (did) answer++; //모든 스킬이 배워졌을 시 answer++
    }
    return answer;
}
