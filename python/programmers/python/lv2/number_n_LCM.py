def gcd(n1, n2):
    while n2 > 0:
        n1, n2 = n2, n1 % n2
    return n1

def solution(arr):
    answer = 0
    lcm = arr[0]
    
    for i in range(1, len(arr)):
        b = arr[i]
        num_gcd = gcd(lcm, b)
        lcm = (lcm*b) / num_gcd
        
    answer = lcm
    
    return answer