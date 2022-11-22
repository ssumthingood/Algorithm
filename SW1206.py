//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV134DPqAA8CFAYh

#import sys
#sys.stdin = open("input.txt", "r")

T =10
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for tc in range(T):
  n = int(input())
  data = list(map(int, input().split()))
  result = 0
  for i in range(2, n-2):
      around = max([data[i - 2], data[i - 1], data[i + 1], data[i + 2]])
      if(data[i] > around):
          result += data[i] - around
 
  print(f"#{tc + 1} {result}")
