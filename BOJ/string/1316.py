N = int(input())
answer = 0
for i in range(N):
    word = list(input())
    w_list = []
    not_flag = 0
    for w in word:
        if w in w_list:
            if w_list[-1] != w:
                not_flag = 1
                continue
        else:
            w_list.append(w)
    if not_flag == 0:
        answer += 1

print(answer)