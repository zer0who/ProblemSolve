word = list(input())
answer = 0
for w in word:
    if 65 <= ord(w) <68:
        answer += 3
    elif 68 <= ord(w) < 71:
        answer += 4
    elif 71 <= ord(w) < 74:
        answer += 5
    elif 74 <= ord(w) < 77:
        answer += 6
    elif 77 <= ord(w) < 80:
        answer += 7
    elif 80 <= ord(w) < 84:
        answer += 8
    elif 84 <= ord(w) < 87:
        answer += 9
    elif 87 <= ord(w):
        answer += 10
print(answer)