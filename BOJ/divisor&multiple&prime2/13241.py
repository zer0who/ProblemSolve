def main():
    A, B = map(int, input().split())
    d = 2
    ans = 1

    while True:
        if A < d or B < d:
            ans *= A
            ans *= B
            break
        if A % d == 0 and B % d == 0:
            A = A // d
            B = B // d
            ans *= d
            continue
        d += 1
    print(ans)


if __name__ == "__main__":
    main()