def main():
    N = int(input())
    ans = 0

    for i in range(N):
        for j in range(N):
            if i != j:
                ans += 1

    print(ans)


if __name__ == "__main__":
    main()