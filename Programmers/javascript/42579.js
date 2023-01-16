//https://school.programmers.co.kr/learn/courses/30/lessons/42579

function solution(genres, plays) {
    var answer = [];
    let sum_play = new Map();
    let play_index = new Map();
    for (let i = 0; i < genres.length; i++) {
        sum_play.set(genres[i], (sum_play.get(genres[i]) || 0) + plays[i]);

        play_index.set([plays[i], i], genres[i]);
    }

    const sum_play_sort = new Map([...sum_play.entries()].sort((a, b) => b[1] - a[1]));
    const play_index_sort = new Map([...play_index.entries()].sort((a, b) => b[0][0] - a[0][0]));

    for (let [k, v] of sum_play_sort) {
        let cnt = 0;
        for (let [k2, v2] of play_index_sort) {
            if (v2 === k) {
                answer.push(k2[1]);
                cnt++;
                if (cnt === 2) break;
            }
        }
    }
    return answer;
}
