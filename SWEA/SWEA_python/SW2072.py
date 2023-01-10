https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5QSEhaA5sDFAUq

#import sys
#sys.stdin = open("input.txt", "r")

T=int(input())
for i in range(T):
	answer=list(map(int,input().split()))
	initialize=0
	for j in answer:
		if j%2==1:
			initialize+=j
	print("#"+str(i+1) + " "+str(initialize))