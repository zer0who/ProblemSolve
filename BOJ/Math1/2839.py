N = int(input())
c = 0
while True:
    if N%5 == 0:
        print(c + int(N//5))
        break
    c += 1
    N -= 3
    if N == 0:
        print(c)
        break
    elif N < 0:
        print(-1)
        break