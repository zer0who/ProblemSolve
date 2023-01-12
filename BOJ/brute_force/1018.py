def board_checker(board):
    num_change1 = 0
    num_change2 = 0
    for i in range(8):
        for j in range(8):
            if (i+j)%2 == 0:
                if board[i][j] != "B":
                    num_change1 += 1
                if board[i][j] != "W":
                    num_change2 += 1
            else:
                if board[i][j] != "W":
                    num_change1 += 1
                if board[i][j] != "B":
                    num_change2 += 1

    return min(num_change1, num_change2)


def main():
    N, M = map(int, input().split())
    origin_board = []
    result = 64
    for _ in range(N):
        origin_board.append(input())

    for i in range(M - 7):
        for j in range(N - 7):
            board = []
            reverse_board = []
            for k in range(j, j+8):
                board.append(origin_board[k][i:i+8])
            num = board_checker(board)
            if num < result:
                result = num
        
    print(result)


if __name__ == "__main__":
    main()