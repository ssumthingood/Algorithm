//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5QRnJqA5cDFAUq

#import sys
#sys.stdin = open("input.txt", "r")

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    k=0
    num = list(map(int,input().split()))
    for i in num:
               k += i
    print(f"#{test_case} {round(k/10)}")
