N = int(input())
for i in range(N):
    quiz = input()
    q_arr = list(quiz)
    total = 0
    continuous = 0

    if q_arr[0] == 'O':
        continuous += 1
        total += 1
    for i in range(1, len(q_arr)):
        if q_arr[i] == 'O':
            if q_arr[i-1] == 'O':
                continuous += 1
                total += continuous
            else:
                continuous += 1
                total += continuous
        else:
            continuous = 0
            total += continuous
    print(total)