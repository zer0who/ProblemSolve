def solution(s):
    answer = ''
    for i in range(len(s)):
        if  i == 0 or s[i-1] == " ":
            answer += s[i].upper()
        else:
            answer += s[i].lower()

    return answer