N, M = map(int, input().split())
cards = [*map(int, input().split())]
max = 0
for i in range(N):
    for j in range(i+1, N):
        for k in range(j+1, N):
            sum = cards[i] + cards[j] + cards[k]
            if sum <= M:
                if sum > max:
                    max = sum

print(max)