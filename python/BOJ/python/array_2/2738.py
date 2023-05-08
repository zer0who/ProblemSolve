N, M = map(int, input().split())
A = []
for i in range(2*N):
    A.append([*map(int, input().split())])

for i in range(N):
    for j in range(M):
        print(A[i][j] + A[i+N][j], end = " ")
    print("")