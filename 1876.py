////https://school.programmers.co.kr/learn/courses/30/lessons/1876?language=python3


def solution(n):
    result = 0
    for i in str(n):
        result += int(i)
    return result