import math
def isPrime(num):
    p = 1
    if num == 1:
        p = 0
    else:
        for i in range(2, int(math.sqrt(num))+1):
            if num%i == 0:
                p = 0    
                break
    return p

def main():
    M, N = map(int, input().split())
    for i in range(M, N+1):
        if isPrime(i) == 1:
            print(i)

main()