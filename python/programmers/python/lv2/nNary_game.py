def calcNnary(n, num):
    if num == 0:
        return 0
    numNnary = ""
    while num > 0:
        num, mod = divmod(num, n)
        if mod >= 10:
            numNnary += chr(mod + 87).upper()
        else:
            numNnary += str(mod)
    
    return numNnary[::-1]


def solution(n, t, m, p):
    answer = ''
    decimal = 0
    index = 0
    count = 0
    
    while True:
        Nnary = str(calcNnary(n, decimal))
        for i in range(1, len(Nnary)+1):
            index += 1
            if index%m == p%m:
                answer += Nnary[i-1]
                count += 1
                if count == t:
                    break
        if count == t:
            break
        
        decimal += 1
        
    return answer