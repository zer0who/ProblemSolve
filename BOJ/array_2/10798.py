def main():
    res = []
    for i in range(5):
        res.append(list(input()))
    while True:
        if sum(len(res[i]) for i in range(len(res))) == 0:
            break
        for r in res:
            if len(r) != 0:
                print(r.pop(0), end = "")
        i +=1

if __name__ == "__main__":
    main()