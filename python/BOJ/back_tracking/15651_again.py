def permutation(N, M, arr):
    if len(arr) == M:
        print(" ".join(map(str, arr)))
        return
    
    for i in range(1, N+1):
        arr.append(i)
        permutation(N, M, arr)
        arr.pop()

def main():
    N, M = map(int, input().split())
    permutation(N, M, [])

if __name__ == "__main__":
    main()