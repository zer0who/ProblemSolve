N = int(input())
res = 0
while(True):
    res += N % 10
    N = N//10
    if N < 10:
        break
print(res+N)