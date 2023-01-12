def solution(s):
    answer = 0
    if len(s) % 2 != 0:
        return answer
    if len(s) == 2 and s[0] == s[1]:
        answer = 1
        return answer
    
    letter_stack = []
    for i in reversed(range(len(s))):
        if len(letter_stack) > 0 and letter_stack[-1] == s[i]:
            letter_stack.pop()
        else:
            letter_stack.append(s[i])
    
    if len(letter_stack) == 0:
        answer = 1
        
    return answer