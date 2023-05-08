def factorial(n):
    if n == 1:
        return 1
    else:
        return n * factorial(n-1)

N, K = map(int, input().split())
if K == 0:
    print(1)
elif N == K:
    print(1)
else:
    result = factorial(N) // (factorial(N-K) * factorial(K))
    print(result)