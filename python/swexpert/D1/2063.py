N = int(input())
scores = [*map(int, input().split())]
scores.sort()
print(scores[N//2])