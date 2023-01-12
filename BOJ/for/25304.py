X = int(input())
N = int(input())
t = 0
for i in range(N):
    a, b = map(int, input().split())
    t += int(a) * int(b)

if t == X:
    print("Yes")
else :
    print("No")