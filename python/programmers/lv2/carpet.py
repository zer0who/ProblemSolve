def solution(brown, yellow):
    answer = []
    divisor = [i for i in range(1, yellow+1) if yellow % i == 0]
    if len(divisor) % 2 == 0:   # 약수가 짝수개인 경우
        smaller_divisor = divisor[:len(divisor)//2]
        bigger_divisor = divisor[len(divisor)//2:]
        
        for i in range(len(smaller_divisor)):
            num_tile = 8 + (bigger_divisor[-i-1]-1)*2 + (smaller_divisor[i]-1)*2
            if num_tile == brown:
                answer = [bigger_divisor[-i-1] + 2, smaller_divisor[i] + 2]
    else:   # 약수가 홀수개인 경우
        if len(divisor) == 1:   # 1인 경우
            answer = [3, 3]
        smaller_divisor = divisor[:len(divisor)//2]
        middle_divisor = divisor[len(divisor)//2]
        bigger_divisor = divisor[len(divisor)//2+1:]
        
        if 8 + (middle_divisor-1)*2 + (middle_divisor-1)*2 == brown:
            answer = [middle_divisor + 2, middle_divisor + 2]
            return answer
        
        for i in range(len(smaller_divisor)):
            num_tile = 8 + (bigger_divisor[-i-1]-1)*2 + (smaller_divisor[i]-1)*2
            if num_tile == brown:
                answer = [bigger_divisor[-i-1] + 2, smaller_divisor[i] + 2]
    
    return answer