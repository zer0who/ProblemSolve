T = int(input())
for t in range(1, T+1):
    N, M = map(int, input().split())
    flies = [[*map(int, input().split())] for i in range(N)]

    result = 0
    for i in range(N-M+1):
        for j in range(N-M+1):
            temp_result = 0
            for k in range(M):
                for l in range(M):
                    temp_result += flies[i+k][j+l]
            if temp_result > result:
                result = temp_result

    print("#{} {}".format(t, result))