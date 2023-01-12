def getGCD(n1, n2):
    gcd = 0
    for i in range(1, min(n1, n2)+1):
        if n1%i == 0 and n2%i == 0:
            gcd = i

    return gcd


N = int(input())
rings = [*map(int, input().split())]
first_ring = rings[0]
for i in range(1, N):
    gcd_ring = getGCD(first_ring, rings[i])
    print(str(first_ring//gcd_ring) + "/" + str(rings[i]//gcd_ring))