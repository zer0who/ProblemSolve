def solution(n, words):
    answer = [0, 0]
    used_words = [words[0]]
    for i in range(1, len(words)):
        if used_words[-1][-1] != words[i][0] or words[i] in used_words:
            answer = [i%n +1, i//n + 1]
            break
        else:
            used_words.append(words[i])
            
    return answer