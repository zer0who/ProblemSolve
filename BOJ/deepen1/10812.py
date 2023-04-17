def main():
    N, M = map(int, input().split())
    bascket = [str(i) for i in range(1, N+1)]
    for _ in range(M):
        i, j, k = map(int, input().split())
        i -= 1
        j -= 1
        k -= 1
        temp1 = bascket[i:k]
        temp2 = bascket[k:j+1]
        bascket[i:j+1] = temp2 + temp1
    print(" ".join(bascket))

if __name__ == "__main__":
    main()