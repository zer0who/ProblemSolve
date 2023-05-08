def main():
    a1, a0 = map(int, input().split())
    c = int(input())
    n0 = int(input())
    if a1*n0 + a0 <= c * n0 and c >= a1:    # 기울기 양, 음일 때 따져야함.
        print(1)
    else:
        print(0)


if __name__ == "__main__":
    main()