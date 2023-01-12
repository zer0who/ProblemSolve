prime_arr = []
M = int(input())
N = int(input())
for i in range(M, N+1):
    not_prime = 0
    if i == 1:
        continue
    else:
        for j in range(2, i):
            if i%j == 0:
                not_prime = 1
                break
        if not_prime == 0:
            prime_arr.append(i)
if len(prime_arr) == 0:
    print(-1)
else:
    print(sum(prime_arr))
    print(min(prime_arr))