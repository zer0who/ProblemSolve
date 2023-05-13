a, b, c = map(int, input().split())
profit = c-b
count = 0
if b >= c:
    print(-1)
else:
    count = a // profit + 1
    print(count)