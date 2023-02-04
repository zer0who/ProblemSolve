def solution(msg):
    answer = []
    dictionary = [chr(i) for i in range(65, 91)]
    index = 0
    temp = msg[0]
    while index != len(msg):
        if temp in dictionary:
            if index != len(msg)-1:
                index += 1
            else:
                answer.append(dictionary.index(temp)+1)
                break
            temp += msg[index]
        else:
            dictionary.append(temp)
            answer.append(dictionary.index(temp[:-1])+1)
            temp = msg[index]
                
            
    
    return answer