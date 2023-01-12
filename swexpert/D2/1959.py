T = int(input())

for t in range(1, T+1):
    N, M = map(int, input().split())
    A = [*map(int, input().split())]
    B = [*map(int, input().split())]

    max = 0
    if M > N:
        for i in range(M-N+1):
            temp_max = 0
            for j in range(N):
                temp_max += A[j] * B[i + j]
            if max < temp_max:
                max = temp_max
    else:
        for i in range(N-M+1):
            temp_max = 0
            for j in range(M):
                temp_max += B[j] * A[i + j]
            if max < temp_max:
                max = temp_max

    print("#{0}".format(t), max)