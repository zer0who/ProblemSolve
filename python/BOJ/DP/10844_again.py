def main():
    N = int(input())
    count_arr = [[0 for _ in range(10)] for _ in range(N+1)]
    count_arr[1] = [0, 1, 1, 1, 1, 1, 1, 1, 1, 1]
    
    for i in range(2, N+1):
        for j in range(10):
            if j == 0:
                count_arr[i][j] = count_arr[i-1][j+1]
            elif j == 9:
                count_arr[i][j] = count_arr[i-1][j-1]
            else:
                count_arr[i][j] = count_arr[i-1][j-1] + count_arr[i-1][j+1]

    print(count_arr[:N+1])
    
    print(sum(count_arr[N])%1000000000)
    

if __name__ == "__main__":
    main()