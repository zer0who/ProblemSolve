def main():
    N = int(input())
    for i in range(1, N+1):
        print(" " * (N-i), end = "")
        print("*" * ((i*2)-1))

        if i == N:
            for j in range(1, N):
                print(" " * j, end = "")
                print("*" * ((N-j)*2-1))

if __name__ == "__main__":
    main()