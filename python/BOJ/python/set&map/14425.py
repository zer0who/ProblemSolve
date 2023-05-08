N, M = map(int, input().split())
S = []
check = []
count = 0
for i in range(N):
    S.append(input())
S = set(S)
for i in range(M):
    check.append(input())

for c in check:
    if c in S:
        count += 1

print(count)