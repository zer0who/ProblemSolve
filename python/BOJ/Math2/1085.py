x, y, w, h = map(int, input().split())
answer = []
answer.append(x)
answer.append(y)
answer.append(abs(x-w))
answer.append(abs(y-h))
print(min(answer))