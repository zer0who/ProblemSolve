def main():
    number = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    N, B = map(int, input().split())
    answer = ""
    while N > 0:
        N, m = divmod(N, B)
        answer += number[m]
    print(answer[::-1])

if __name__ == "__main__":
    main()