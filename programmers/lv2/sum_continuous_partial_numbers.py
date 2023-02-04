def solution(elements):
    answer = set(e for e in elements)
    for i in range(2, len(elements)):
        temp = elements.copy()
        for j in range(i-1):
            temp.append(elements[j])
        
        for j in range(len(temp)-i+1):
            temp_adder = temp[j:j+i]
            answer.add(sum(temp_adder))
    answer.add(sum(elements))
        
    return len(list(answer))