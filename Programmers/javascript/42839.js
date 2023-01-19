//https://school.programmers.co.kr/learn/courses/30/lessons/42839

function solution(numbers) {
    var answer = 0;
    var numarr = numbers.split("");
    var allPermutation = [];

    for (var i = 1; i <= numarr.length; i++) {
        allPermutation = [...allPermutation, ...getPermutations(numarr, i)];
    }

    // console.log(모든 순열);

    const newPer = allPermutation.filter((item) => {
        var flag = false;
        for (var i = 0; i < item.length; i++) {
            if (item.charAt(i) !== "0") {
                flag = true;
            }
        }
        return flag;
    });

    // console.log(0으로만 구성된 요소를 제거한 순열);

    for (var i = 0; i < newPer.length; i++) {
        while (newPer[i].charAt(0) === "0") {
            newPer[i] = newPer[i].substring(1);
        }
    }

    // console.log(0으로 시작하는 요소가 있을 경우 0을 제거);

    const ultimitComb = Array.from(new Set(newPer));
    console.log(ultimitComb);
    for (var i = 0; i < ultimitComb.length; i++) {
        if (isPrime(ultimitComb[i])) answer++;
    }
    return answer;
}

function isPrime(number) {
    if (number <= 1) return false;
    else if (number == 2) return true;
    else {
        for (var i = 2; i <= Math.floor(Math.sqrt(number)); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}

function getPermutations(arr, selectNumber) {
    const results = [];
    if (selectNumber === 1) return arr.map((value) => value); // 1개씩 택할 때, 바로 모든 배열의 원소 return

    arr.forEach((fixed, index, origin) => {
        const rest = [...origin.slice(0, index), ...origin.slice(index + 1)]; // 해당하는 fixed를 제외한 나머지 배열
        const permutations = getPermutations(rest, selectNumber - 1); // 나머지에 대해 순열을 구한다.
        const attached = permutations.map((permutation) => [fixed, ...permutation].join("")); // 돌아온 순열에 대해 떼 놓은(fixed) 값 붙이기
        results.push(...attached); // 배열 spread syntax 로 모두다 push
    });

    return results; // 결과 담긴 results return
}
