def main():
    N, M = map(int, input().split())
    bascket = ['0'] * N
    for _ in range(M):
        i, j, k = input().split()
        for n in range(int(i), int(j)+1):
            bascket[n-1] = k

    print(" ".join(bascket))

if __name__ == "__main__":
    main()