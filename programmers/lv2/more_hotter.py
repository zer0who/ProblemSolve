import heapq

def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)
    less_than_k = []
    
    while True:
        if len(scoville) == 0:
            break
        if scoville[0] >= K and not less_than_k:
            return answer
        
        less_than_k.append(heapq.heappop(scoville))
        if len(less_than_k) == 2:
            answer += 1
            blended = less_than_k[0] + less_than_k[1]*2
            heapq.heappush(scoville, blended)
            less_than_k = []
            
    return -1