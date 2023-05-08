import re

def solution(files):
    answer = []
    temp = [re.split(r"([0-9]+)", s) for s in files]
    temp.sort(key=lambda x: (x[0].lower(), int(x[1])))
    for i in range(len(temp)):
        answer.append("".join(temp[i]))
        
    
    return answer