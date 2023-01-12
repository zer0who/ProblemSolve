import math
for i in range(int(input())):
    ans = 0
    x1, y1, r1, x2, y2, r2 = map(int, input().split())
    d = math.sqrt((x2-x1)**2 + (y2-y1)**2)
    if d == 0:
        if r1 == r2:
            ans = -1
        else:
            ans = 0
    elif abs(r1-r2) == d or r1+r2 == d:
        ans = 1
    elif abs(r1-r2) < d < r1+r2:
        ans = 2
    else:
        ans = 0
    print(ans)