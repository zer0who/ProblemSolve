N = int(input())
arr = list(map(int, input().split()))
c = 0
for i in range(N):
    not_prime = 0
    if arr[i] == 1:
        continue
    else:
        for j in range(2, arr[i]):
            if arr[i]%j == 0:
                not_prime = 1
                break
        if not_prime == 0:
            c += 1
        
print(c)