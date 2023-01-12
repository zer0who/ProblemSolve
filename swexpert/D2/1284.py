T = int(input())
for i in range(1, T+1):
    P, Q, R, S, W = map(int, input().split())
    less = 0
    price_a = W * P
    price_b = Q
    if W > R:
        price_b += (W-R) * S
    if price_a > price_b:
        less = price_b
    else:
        less = price_a
    print("#{0} {1}".format(i, less))