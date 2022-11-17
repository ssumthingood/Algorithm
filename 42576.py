//https://school.programmers.co.kr/learn/courses/30/lessons/42576?language=python3

def solution(participant, completion):
    participant.sort()
    completion.sort()
    for i in range(len(completion)):
        if(participant[i] != completion[i]):
            return participant[i]
    n = len(participant)
    return participant[n-1]