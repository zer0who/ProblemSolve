dir_vector = {0: (0, 1), 1: (1, 0), 2: (0, -1), 3: (-1, 0)}


def indexController(row, col, direction):
    row -= dir_vector[direction][0]
    col -= dir_vector[direction][1]
    if direction == 3:
        direction = 0
    else:
        direction += 1
    row += dir_vector[direction][0]
    col += dir_vector[direction][1]

    return row, col, direction


T = int(input())
for t in range(1, T+1):
    N = int(input())
    if N == 1:
        print("#{}".format(t))
        print(1)
        continue
    snail = [[0 for col in range(N)] for row in range(N)]
    row_idx = 0
    col_idx = 0
    dir_idx = 0
    number = 1

    while number < N*N + 1:
        snail[row_idx][col_idx] = number
        number += 1
        row_idx = row_idx + dir_vector[dir_idx][0]
        col_idx = col_idx + dir_vector[dir_idx][1]
        if col_idx == N:
            row_idx, col_idx, dir_idx = indexController(row_idx, col_idx, dir_idx)
        elif col_idx == -1:
            row_idx, col_idx, dir_idx = indexController(row_idx, col_idx, dir_idx)
        elif row_idx == N:
            row_idx, col_idx, dir_idx = indexController(row_idx, col_idx, dir_idx)

        if snail[row_idx][col_idx] != 0:
            row_idx, col_idx, dir_idx = indexController(row_idx, col_idx, dir_idx)

    print("#{}".format(t))
    for r in snail:
        for i in range(len(r)):
            print(r[i], end=" ")
        print("")