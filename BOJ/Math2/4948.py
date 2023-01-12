import math
def isPrime(num):
    prime = [True]*num
    sq_num = int(math.sqrt(num))
    for i in range(2, sq_num+1):
        if prime[i] == True:
            for j in range(i+i, num, i):
                prime[j] = False
        
    return [i for i in range(2, num) if prime[i] == True]

def main():
    while True:
        N = int(input())
        if N == 0:
            break
        p_arr = isPrime(2*N+1)
        bertran = [i for i in p_arr if i>N]
        print(len(bertran))

main()