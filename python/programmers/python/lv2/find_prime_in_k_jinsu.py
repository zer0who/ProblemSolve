def isPrime(num):
    if num == 1:
        return False
    for i in range(2, int(num**0.5)+1): #소수 판별은 제곱근까지 해주자.
        if num % i == 0:
            return False
    return True


def solution(n, k):
    answer = 0
    k_jinsu = ""
    while n >= 1:   # k진수로 가공
        mod = n % k
        k_jinsu += str(mod)
        n = n // k
    k_jinsu = k_jinsu[::-1]
    
    temp = ""
    for i in range(len(k_jinsu)):
        if int(k_jinsu[i]) != 0:
            temp += k_jinsu[i]
        else:
            if len(temp) != 0:
                if isPrime(int(temp)):
                    answer += 1
            temp = ""
            
    if len(temp) != 0:
        if isPrime(int(temp)):
            answer += 1
    
    return answer