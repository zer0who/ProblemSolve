def solution(A,B):
    A.sort()
    B.sort()
    answer = 0
    while True:
        if len(A) == 0:
            break
        answer += A.pop(-1) * B.pop(0)

    return answer