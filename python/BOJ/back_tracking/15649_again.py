def permutation(N, M, arr):
    if len(arr) == M:
        print(" ".join(map(str,arr)))
        return
    for i in range(1, N+1):
        if i not in arr:
            arr.append(i)
            permutation(N, M, arr)
            arr.pop()

def main():
    N, M = map(int, input().split())
    arr = []
    permutation(N, M, arr)


if __name__ == "__main__":
    main()