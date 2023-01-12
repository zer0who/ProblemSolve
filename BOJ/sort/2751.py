import sys

N = int(input())
l = []
for _ in range(N):
    l.append(int(sys.stdin.readline()))

l.sort()

for i in l:
    print(i)