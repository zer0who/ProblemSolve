def solution(n):
    answer = 1
    for i in range(1, n):
        temp = i
        for j in range(i+1, n):
            temp += j
            if temp == n:
                answer += 1
                break
            elif temp > n:
                break

    return answer