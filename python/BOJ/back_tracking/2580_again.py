def isValid(n, x, y) -> bool:
    global board

    if n in board[x]:   #가로 체크
        return False
    for i in range(len(board)): #세로 체크
        if board[i][y] == n:
            return False
    square = [board[x//3*3][y//3*3:(y//3+1)*3], board[x//3*3 + 1][y//3*3:(y//3+1)*3], board[x//3*3 + 2][y//3*3:(y//3+1)*3]]
    for i in range(len(square)):
        if n in square[i]:
            return False

    return True

def sdoku(blank_idx: int):
    global board, blank

    if blank_idx == len(blank):
        for i in range(len(board)):
            print(" ".join(map(str, board[i])))
        exit()
    
    x, y = map(int, blank[blank_idx])
    for n in range(1, 10):
        if isValid(n, x, y):
            board[x][y] = n
            sdoku(blank_idx+1)
            board[x][y] = 0

def main():
    global board, blank

    board = []
    blank = []
    for i in range(9):
        row = list(map(int, input().split()))
        for j in range(len(row)):
            if row[j] == 0:
                blank.append([i, j])
        board.append(row)
    sdoku(0)


if __name__ == "__main__":
    main()