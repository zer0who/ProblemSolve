def solution(n):
    if n == 1:
        return 1 % 1234567
    elif n == 2:
        return 2 % 1234567
    
    a, b = 1, 2
    for i in range(n-2):
        a, b = b, a + b
    answer = b
    
    return answer % 1234567