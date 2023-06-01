def main():
    N = int(input())
    houses = [list(map(int, input().split())) for _ in range(N)]
    price = [[0, 0, 0] for i in range(N+1)]
    for i in range(1, N+1):
        price[i][0] = min(price[i-1][1], price[i-1][2]) + houses[i-1][0]
        price[i][1] = min(price[i-1][0], price[i-1][2]) + houses[i-1][1]
        price[i][2] = min(price[i-1][0], price[i-1][1]) + houses[i-1][2]
    
    print(min(price[-1]))


if __name__ == "__main__":
    main()