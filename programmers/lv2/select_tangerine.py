def solution(k, tangerine):
    answer = 0
    tangerine_dict = {}
    for i in range(len(tangerine)):
        if tangerine[i] not in tangerine_dict:
            tangerine_dict[tangerine[i]] = 1
        else:
            tangerine_dict[tangerine[i]] += 1
    
    tangerine_dict = sorted(tangerine_dict.items(), key = lambda item: item[1], reverse = True)
    
    count = 0
    for i in range(len(tangerine_dict)):
        count += tangerine_dict[i][1]
        
        if count >= k:
            answer = i+1
            break
    
    return answer