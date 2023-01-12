def backTracking(N: int, M: int, permutation: list) -> None:
    if len(permutation) == M:
        print(" ".join(map(str, permutation)))
        return
    else:
        for i in range(1, N+1):
            permutation.append(i)
            backTracking(N, M, permutation)
            permutation.pop()
            

def main():
    N, M = map(int, input().split())
    backTracking(N, M, permutation=[])


if __name__ == "__main__":
    main()