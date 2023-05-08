def solution(citations):
    answer = 0
    citations.sort(reverse = True)
    for i in range(len(citations)):
        if i <= citations[i]:
            if citations[i] == citations[i-1]:
                continue
            if answer >= citations[i]:
                answer = citations[i]
            else:
                answer = i + 1
        
    
    return answer