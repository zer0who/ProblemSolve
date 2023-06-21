def main():
    n = int(input())
    A = {}
    for _ in range(n):
        a, b = map(int, input().split())
        A[a] = b
    lines = sorted(A.items())
    spots = [lines[i][1] for i in range(len(lines))]
    dp = [0 for _ in range(n)]
    for i in range(n):
        dp[i] = 1
        for j in range(i):
            if spots[j] < spots[i]:
                dp[i] = max(dp[i], dp[j]+1)
    print(n - max(dp))


if __name__ == "__main__":
    main()