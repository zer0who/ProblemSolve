def solution(s):
    if len(s)%2 == 1:
        return 0
    
    answer = 0
    s = list(s)
    for i in range(len(s)):
        temp = []
        for j in range(len(s)):
            if not temp:
                temp.append(s[j])
            else:
                if s[j] == ")" and temp[-1] == "(":
                    temp.pop()
                elif s[j] == "}" and temp[-1] == "{":
                    temp.pop()
                elif s[j] == "]" and temp[-1] == "[" :
                    temp.pop()
                else:
                    temp.append(s[j])
        
        if len(temp) == 0:
            answer += 1
        popped = s.pop(0)    # 회전
        s.append(popped)
            
    return answer