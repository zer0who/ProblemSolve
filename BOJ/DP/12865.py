def main():
    N, K = map(int, input().split())
    things = [list(map(int, input().split())) for _ in range(N)]
    knapsack = [[0 for _ in range(K+1)] for _ in range(N+1)]

    for i in range(1, N+1):
        for j in range(1, K+1):
            if things[i-1][0] > j:
                knapsack[i][j] = knapsack[i-1][j]
            else:
                knapsack[i][j] = max(knapsack[i-1][j], knapsack[i-1][j-things[i-1][0]]+things[i-1][1])

    print(max(max(knapsack)))

if __name__ == "__main__":
    main()