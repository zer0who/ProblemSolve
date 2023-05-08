def solution(s):
    answer = True
    open_count = 0
    for i in range(len(s)):
        if s[i] == "(":
            open_count += 1
        elif s[i] == ")":
            open_count -= 1
            
        if open_count < 0:
            answer = False
            break
            
    if open_count != 0:
        answer = False
    
    return answer