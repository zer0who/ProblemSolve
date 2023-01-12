T = int(input())
for t in range(1, T+1):
    answer = 1
    puzzle = []
    for i in range(9):
        puzzle.append([*map(int, input().split())])
    puzzle90 = list(zip(*puzzle[::-1]))

    for i in range(9):
        if len(set(puzzle[i])) != 9 or len(set(puzzle90[i])) != 9:
            answer = 0
            break

        if i == 0 or i == 3 or i == 6:
            temp_list = []
            for j in range(3):
                temp_list.append(puzzle[i][i+j])
                temp_list.append(puzzle[i+1][i+j])
                temp_list.append(puzzle[i+2][i+j])
            if len(set(temp_list)) != 9:
                answer = 0
                break

    print("#{} {}".format(t, answer))