def solution(people, limit):
    if len(people) == 1:
        return 1
    answer = 0
    people.sort()
    left_index = 0
    right_index = len(people)-1
    
    while left_index <= right_index:
        answer += 1
        if people[left_index] + people[right_index] > limit:
            right_index -= 1
        else:
            left_index += 1
            right_index -= 1
        
    return answer