T = int(input())
for t in range(1, T+1):
    result = "yes"
    board = []
    rukh_count = 0
    for i in range(8):
        board.append(input())

    for i in range(len(board)):
        row_rukh_count = 0
        col_rukh_count = 0
        for j in range(8):
            if board[i][j] == "O":
                rukh_count += 1
                row_rukh_count += 1
                if row_rukh_count > 1:
                    result = "no"
                    break
            if board[j][i] == "O":
                col_rukh_count += 1
                if col_rukh_count > 1:
                    result = "no"
                    break

        if result == "no":
            break

    if rukh_count != 8:
        result = "no"

    print("#{} {}".format(t, result))
