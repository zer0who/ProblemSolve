N = int(input())
square = [[0 for _ in range(101)] for _ in range(101)]
area = 0

for i in range(N):
    x, y = map(int, input().split())
    
    for i in range(x, x + 10):
        for j in range(y, y + 10):
            square[i][j] = 1

for s in square:
    area += sum(s)
    
print(area)