def permutation(N, M, arr):
    if len(arr) == M:
        print(" ".join(map(str, arr)))
        return
    for i in range(1, N+1):
        if not arr:
            arr.append(i)
            permutation(N, M, arr)
            arr.pop()
            continue
        if arr[-1] <= i:
            arr.append(i)
            permutation(N, M, arr)
            arr.pop()

def main():
    N, M = map(int, input().split())
    permutation(N, M, [])

if __name__ == "__main__":
    main()