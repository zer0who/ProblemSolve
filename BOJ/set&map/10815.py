N = int(input())
cards = set([*map(int, input().split())])
M = int(input())
numbers = [*map(int, input().split())]
result = [0] * M

for i in range(M):
    if numbers[i] in cards:
        result[i] = 1

for r in result:
    print(r, end=" ")