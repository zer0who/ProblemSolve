# def isValid(row: int, col: int, board: list) -> bool:
#     for i in range(len(board)):
#         if board[i][col] == 1:
#             return False
#         for j in range(len(board)):
#             if i + j == row + col:
#                 if board[i][j] == 1:
#                     return False
            
#             elif abs(i-row) == abs(j-col):
#                 if board[i][j] == 1:
#                     return False

#     return True


# def nQueen(n: int, board: list) -> None:
#     global count

#     if sum(sum(b) for b in board) == n:
#         count += 1
#         return

#     else:
#         for i in range(1, n):
#             if sum(board[i]) >= 1:
#                 continue
#             if sum(board[i-1]) == 0:
#                 continue
#             for j in range(n):
#                 if isValid(i, j, board):
#                     board[i][j] = 1
#                     nQueen(n, board)
#                     board[i][j] = 0
def nQueen(queen_index: list) -> None:
    global count, N

    if len(queen_index) == N:
        count += 1
        return
    else:
            for i in range(N):
                row_flag = True
                for q in queen_index:
                    if i < q[0]:
                        row_flag = False
                    if i == q[0]:
                        row_flag = False
                if not row_flag :
                    continue

                for j in range(N):
                    col_flag = True
                    for q in queen_index:
                        if j == q[1]:
                            col_flag = False
                        elif abs(q[0]-i) == abs(q[1]-j):
                            col_flag = False
                        elif i+j == q[0]+q[1]:
                            col_flag = False
                    if col_flag == False:
                        continue

                    queen_index.append([i, j])
                    nQueen(queen_index)
                    queen_index.pop()

def main():
    global count, N
    count = 0
    N = int(input())

    # board = [[0 for row in range(N)] for col in range(N)]
    # for i in range(N):
    #     board[0][i] = 1
    #     nQueen(N, board)
    #     board[0][i] = 0
    queen_index = []
    nQueen(queen_index)

    print(count)


if __name__ == "__main__":
    main()