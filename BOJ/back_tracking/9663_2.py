def isPromising(row: int, queen_index: list) -> bool:
    for i in range(row):
        if queen_index[row] == queen_index[i] or abs(queen_index[row] - queen_index[i]) == row - i:
            return False
    return True


def nQueen(row: int, queen_index: list) -> None:
    global count, N

    if row == N:
        count += 1
        return
    else:
        for i in range(N):
            queen_index[row] = i
            if isPromising(row, queen_index):
                nQueen(row+1, queen_index)


def main():
    global count, N
    count = 0
    N = int(input())

    queen_index = [0] * N
    nQueen(0, queen_index)

    print(count)


if __name__ == "__main__":
    main()

#시간 초과 나는지 체크 용 제출
import sys
N = int(sys.stdin.readline())
answer = 0

def dfs(x, trace):  
    global answer
    if len(trace) == N:
        answer += 1
        return

    for y in range(N):
        check = True
        for row, col in trace:
            
            if y == col:
                check = False
                break
            
            if abs(x-row) == abs(y-col):
                check = False
                break

        if check:
            trace.append((x, y))
            dfs(x+1, trace)
            trace.pop()


dfs(0, [])
print(answer)