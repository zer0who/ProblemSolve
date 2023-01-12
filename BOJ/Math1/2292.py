# 6 12 18 24 = n = 6+6n
N = int(input())
goal = N
count = 0
for i in range(N):
    goal -= i*6
    count += 1
    if goal <= 1:
        break
print(count)