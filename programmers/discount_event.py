def solution(want, number, discount):
    answer = 0
    
    for i in range(len(discount)-9):
        want_dict = {want[i]:number[i] for i in range(len(want))}
        clear_flag = True
        for j in range(i, i+10):
            if discount[j] in want_dict:
                want_dict[discount[j]] -= 1
        for v in want_dict.values():
            if v != 0:
                clear_flag = False
                break
        if clear_flag:
            answer += 1
    
    return answer