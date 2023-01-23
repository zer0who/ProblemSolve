def solution(clothes):
    answer = 1
    clothes_dict = {}
    for i in range(len(clothes)):
        if clothes[i][1] not in clothes_dict:
            clothes_dict[clothes[i][1]] = 1
        else:
            clothes_dict[clothes[i][1]] += 1
    
    for key in clothes_dict:
        answer *= (clothes_dict[key]+1)
            
    return answer - 1