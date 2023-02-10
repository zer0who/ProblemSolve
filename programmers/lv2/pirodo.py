def dfs(k, dungeons, count):
    global answer, visited
    
    if count > answer:
        answer = count
    
    for i in range(len(dungeons)):
        if k >= dungeons[i][0] and visited[i] != 1:
            visited[i] = 1
            k -= dungeons[i][1]
            dfs(k, dungeons, count+1)
            visited[i] = 0
            k += dungeons[i][1]
    
    
def solution(k, dungeons):
    global answer, visited
    answer = 0
    visited = [0] * len(dungeons)
    
    dfs(k, dungeons, 0)
    
    return answer