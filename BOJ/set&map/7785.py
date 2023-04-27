def main():
    n = int(input())
    log = {}
    for _ in range(n):
        l = input().split()
        if l[1] == "leave":
            del log[l[0]]
            continue
        log[l[0]] = l[1]
    
    res = sorted(log, reverse=True)
    for r in res:
        print(r)


if __name__ == "__main__":
    main()