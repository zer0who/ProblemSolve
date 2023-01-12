T = int(input())
for t in range(1, T+1):
    puzzle = []
    result = 0
    N, K = map(int, input().split())
    for i in range(N):
        puzzle.append([*map(int, input().split())])
    transposed_puzzle = [[0 for row in range(N)] for col in range(N)]
    for i in range(N):
        for j in range(N):
            transposed_puzzle[j][i] = puzzle[i][j]

    for p in puzzle:
        count = 0
        for i in range(N-1):
            if p[i] == 1 and p[i] == p[i+1]:
                count += 1
            else:
                if count == K-1:
                    result += 1
                count = 0

            if i == N-2:
                if count == K-1:
                    result += 1

    for tp in transposed_puzzle:
        count = 0
        for i in range(N-1):
            if tp[i] == 1 and tp[i] == tp[i+1]:
                count += 1
            else:
                if count == K-1:
                    result += 1
                count = 0

            if i == N-2:
                if count == K-1:
                    result += 1

    print("#{0}".format(t), result)
