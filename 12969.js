//https://school.programmers.co.kr/learn/courses/30/lessons/12969?language=javascript

process.stdin.setEncoding("utf8");
process.stdin.on("data", (data) => {
    const n = data.split(" ");
    const a = Number(n[0]),
        b = Number(n[1]);
    for (var i = 0; i < b; i++) {
        var line = "";
        for (var j = 0; j < a; j++) {
            line += "*";
        }
        console.log(line);
    }
});
