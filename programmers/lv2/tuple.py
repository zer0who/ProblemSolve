def solution(s):
    answer = []
    s_list = []
    temp_str = ""
    for i in range(1, len(s)-1):
        if s[i] != "{" and s[i] != "}":
            if s[i] == "," and s[i-1] == "}":
                continue
            temp_str += s[i]
            
        if s[i] == "}":
            s_list.append(temp_str.split(","))
            temp_str = ""
    
    s_list.sort(key=len)
    for i in range(len(s_list)):
        for j in range(len(s_list[i])):
            if int(s_list[i][j]) not in answer:
                answer.append(int(s_list[i][j]))
            
    return answer