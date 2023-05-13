import sys
N = int(input())
for i in range(N):
    num, S = input().split()
    num = int(num)
    for str in S:
        for i in range(num):
            print(str, end = '')
    print('')