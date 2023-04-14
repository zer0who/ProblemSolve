def solution(n):
    temp = [1, 2]
    for i in range(2, n):
        temp.append((temp[-1] + temp[-2]) % 1000000007)
        
    return temp[-1]