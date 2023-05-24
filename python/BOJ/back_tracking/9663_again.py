def isValid(queens, col) -> bool:
    for i in range(col):
        if queens[col] == queens[i]:
            return False
        if abs(queens[col] - queens[i]) == col - i:
            return False
    
    return True

def nQueen(queens, col):
    global answer, N
    
    if col == N:
        answer += 1
        return

    for i in range(N):
        queens[col] = i
        if isValid(queens, col):
            nQueen(queens, col+1)

def main():
    global answer, N

    answer = 0
    N = int(input())
    queens = [0] * N

    nQueen(queens, 0)
    print(answer)
    

if __name__ == "__main__":
    main()