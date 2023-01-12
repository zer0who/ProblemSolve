def isPromising(x: int, y: int) -> list:
    promising = [i for i in range(1, 10)]
    for i in range(9):
        if sudoku[x][i] in promising:
            promising.remove(sudoku[x][i])
        if sudoku[i][y] in promising:
            promising.remove(sudoku[i][y])
    
    rect = [sudoku[(x//3)*3][(y//3)*3 : (y//3)*3 + 3], sudoku[(x//3)*3 + 1][(y//3)*3 : (y//3)*3 + 3], sudoku[(x//3)*3 + 2][(y//3)*3 : (y//3)*3 + 3]]
    for i in range(len(rect)):
        for j in range(len(rect[i])):
            if rect[i][j] in promising:
                promising.remove(rect[i][j])
    
    return promising


def runSudoku(index: int):
    global sudoku, zero_index

    if index == len(zero_index):
        for i in range(len(sudoku)):
            for j in range(len(sudoku[i])):
                print(sudoku[i][j], end=" ")
            print("")
        
        exit()

    else:
        x, y = map(int, zero_index[index])
        promising = isPromising(x, y)
        for p in promising:
            sudoku[x][y] = p
            runSudoku(index+1)
            sudoku[x][y] = 0
        


def main():
    global sudoku, zero_index

    sudoku = []
    zero_index = []
    for i in range(9):
        row = list(map(int, input().split()))
        for j in range(len(row)):
            if row[j] == 0:
                zero_index.append([i, j])
        sudoku.append(row)

    runSudoku(0)
    


if __name__ == "__main__":
    main()