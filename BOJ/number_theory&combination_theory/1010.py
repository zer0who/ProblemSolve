T = int(input())
for _ in range(T):
    result = 0
    W, E = map(int, input().split())
    fact_E = 1
    fact_W = 1
    if W == E:
        result = 1
    else:
        for _ in range(W):
            fact_E *= E
            E -= 1
            fact_W *= W
            W -= 1
        result = fact_E // fact_W
    print(result)
