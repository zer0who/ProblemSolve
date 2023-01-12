def main():
    N = int(input())
    A = list(map(int, input().split()))
    A_reverse = A[::-1]
    ascending = [1 for _ in range(N)]
    descending = [1 for _ in range(N)]
    result = [0 for _ in range(N)]
    for i in range(N):
        for j in range(i):
            if A[j] < A[i]:
                ascending[i] = max(ascending[i], ascending[j] + 1)
            if A_reverse[j] < A_reverse[i]:
                descending[i] = max(descending[i], descending[j] + 1)
    descending = descending[::-1]
    
    for i in range(N):
        result[i] = ascending[i] + descending[i] - 1
    print(max(result))

if __name__ == "__main__":
    main()