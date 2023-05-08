def isPromising(sudoku_line: list) -> bool:
    num_count = [0] * 10
    for i in range(len(sudoku_line)):
        if sudoku_line[i] == 0:
            continue
        num_count[sudoku_line[i]] += 1
        if num_count[sudoku_line[i]] > 1:
            return False

    return True


def makeMini(row: int, col: int) -> list:
    global sudoku

    if row < 3:
        if col < 3:
            mini = [sudoku[0][0:3], sudoku[1][0:3], sudoku[2][0:3]]
        elif 3 <= col < 6:
            mini = [sudoku[0][3:6], sudoku[1][3:6], sudoku[2][3:6]]
        else:
            mini = [sudoku[0][6:9], sudoku[1][6:9], sudoku[2][6:9]]
    elif 3 <= row < 6:
        if col < 3:
            mini = [sudoku[3][0:3], sudoku[4][0:3], sudoku[5][0:3]]
        elif 3 <= col < 6:
            mini = [sudoku[3][3:6], sudoku[4][3:6], sudoku[5][3:6]]
        else:
            mini = [sudoku[3][6:9], sudoku[4][6:9], sudoku[5][6:9]]
    else:
        if col < 3:
            mini = [sudoku[6][0:3], sudoku[7][0:3], sudoku[8][0:3]]
        elif 3 <= col < 6:
            mini = [sudoku[6][3:6], sudoku[7][3:6], sudoku[8][3:6]]
        else:
            mini = [sudoku[6][6:9], sudoku[7][6:9], sudoku[8][6:9]]
    
    return mini

def isMiniPromising(mini_sudoku: list) -> bool:
    num_count = [0] * 10
    for i in range(len(mini_sudoku)):
        for j in range(len(mini_sudoku[i])):
            if mini_sudoku[i][j] == 0:
                continue
            num_count[mini_sudoku[i][j]] += 1
            if num_count[mini_sudoku[i][j]] > 1:
                return False

    return True


def runSudoku() -> None:
    global sudoku
    
    sum_sudoku = 0
    for i in range(9):
        sum_sudoku += sum(sudoku[i])
    if sum_sudoku == 180:
        return


    for i in range(9):
        if sum(sudoku[i]) == 45:    # 행이 모두 채워진 경우
            continue
        else:
            for num in range(1, 10):
                for j in range(len(sudoku[i])):
                    if sudoku[i][j] == 0:
                        sudoku[i][j] = num
                        if isPromising(sudoku[i]):
                            col = list(zip(*sudoku))[j]
                            if isPromising(col):
                                mini_sudoku = makeMini(i, j)
                                if isMiniPromising(mini_sudoku):
                                    runSudoku()
                                    sudoku[i][j] = 0
                                else:
                                    sudoku[i][j] = 0
                                    continue
                            else:
                                sudoku[i][j] = 0
                                continue
                        else:
                            sudoku[i][j] = 0
                            continue

    return


def main():
    global sudoku
    sudoku = []

    for i in range(9):
        sudoku.append(list(map(int, input().split())))
    
    runSudoku()
    print(" --- --- --- ")
    for i in range(len(sudoku)):
        for j in range(len(sudoku[i])):
            print(sudoku[i][j], end=" ")
        print("")

    return



if __name__ == "__main__":
    main()