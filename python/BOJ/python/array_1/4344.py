import sys
C = int(input())
for i in range(C):
    score = list(map(int, input().split()))
    N = score.pop(0)
    avg = sum(score)/N
    count = 0
    answer = 0
    for s in score:
        if s > avg:
            count += 1
    answer = count/N
    print(format(answer, ".3%"))