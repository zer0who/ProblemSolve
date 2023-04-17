def main():
    s = input()
    if len(s) % 2 != 0:
        mid = len(s) // 2
        before_mid = s[:mid]
        for i in range(1, len(before_mid)+1):
            if before_mid[i*-1] != s[mid+i]:
                print(0)
                return
    else:
        mid = len(s) // 2
        before_mid = s[:mid]
        for i in range(1, len(before_mid)+1):
            if before_mid[i*-1] != s[mid+i-1]:
                print(0)
                return

    print(1)
    return

if __name__ == "__main__":
    main()