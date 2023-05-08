def dfs(comp, word):
    global answer, cnt
    
    if comp == word:
        answer = cnt
        return
    if len(comp) == 5:
        return
    
    alpha = ["A", "E", "I", "O", "U"]
    for a in alpha:
        cnt += 1
        comp = comp + a
        dfs(comp, word)
        comp = comp[:-1]
    return

def solution(word):
    global answer, cnt
    answer = 0
    cnt = 0
    
    dfs("", word)
    return answer