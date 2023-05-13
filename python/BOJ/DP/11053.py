def main():
    N = int(input())
    A = list(map(int, input().split()))
    ascending_numbers = [None for _ in range(N)]
    
    for i in range(N):
        ascending_numbers[i] = 1
        for j in range(i):
            if A[j] < A[i]:
                ascending_numbers[i] = max(ascending_numbers[i], ascending_numbers[j]+1)
    
    print(max(ascending_numbers))


if __name__ == "__main__":
    main()