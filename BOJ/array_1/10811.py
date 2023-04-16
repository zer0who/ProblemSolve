def main():
    N, M = map(int, input().split())
    bascket = [str(i) for i in range(1, N+1)]
    for _ in range(M):
        a, b = map(int, input().split())
        temp = bascket[a-1:b]
        temp.reverse()
        bascket[a-1:b] = temp
    print(" ".join(bascket))

if __name__ == "__main__":
    main()