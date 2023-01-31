def solution(numbers, target):
    calculated = [0]
    
    for n in numbers:
        temp = []
        for c in calculated:
            temp.append(c + n)
            temp.append(c - n)
        calculated = temp
    
    answer = calculated.count(target)
    
    return answer