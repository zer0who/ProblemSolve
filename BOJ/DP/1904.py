def main():
    N = int(input())
    count = [0] * (N+2)
    count[1] = 1
    count[2] = 2

    for i in range(3, N+1): # bottom-up 방식
        count[i] = (count[i-2] + count[i-1]) % 15746
    print(count[N])


if __name__ == "__main__":
    main()