def main():
    T = int(input())
    for _ in range(T):
        N = int(input())
        dp = [0 for _ in range(N+2)]
        dp[1] = 1
        dp[2] = 1
        if N >=3:
            for i in range(3, N+1):
                dp[i] = dp[i-2] + dp[i-3]
        print(dp[N])



if __name__ == "__main__":
    main()