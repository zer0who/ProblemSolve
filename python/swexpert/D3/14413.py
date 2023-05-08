T = int(input())
for t in range(1, T+1):
    result = "possible"
    board = []
    N, M = map(int, input().split())
    for _ in range(N):
        board.append(input())

    for i in range(N):
        for j in range(M-1):
            if board[i][j+1] != "?" and board[i][j] == board[i][j+1]:
                result = "impossible"
                break
            try:
                if board[i+1][j] != "?" and board[i][j] == board[i+1][j]:
                    result = "impossible"
                    break
            except IndexError:
                pass
        if result == "impossible":
            break

    print("#{} {}".format(t, result))

