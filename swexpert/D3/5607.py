def factorial(n):
    if n == 1:
        return 1
    else:
        return n * factorial(n-1)


T = int(input())
for t in range(1, T+1):
    N, R = map(int, input().split())
    divider = 1234567891


