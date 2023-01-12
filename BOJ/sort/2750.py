N = int(input())
l = []
for _ in range(N):
    l.append(int(input()))

l.sort()
for i in range(len(l)):
    print(l[i])