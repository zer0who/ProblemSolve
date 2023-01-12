# T = int(input())

# for t in range(1, T+1):
#     N = int(input())
#     square = []
#     for i in range(N):
#         square.append([*map(int, input().split())])

#     print("#{0}".format(t))
#     for i in range(N):
#         for j in range(N):
#             print(square[N-1-j][i], end = "")
#         print(end = " ")
#         for j in range(N):
#             print(square[N-1-i][N-1-j], end = "")
#         print(end = " ")
#         for j in range(N):
#             print(square[j][N-1-i], end = "")
#         print("")

T = int(input())

for t in range(1, T+1):
    N = int(input())
    square = []
    for i in range(N):
        square.append([*map(str, input().split())])
    square90 = list(zip(*square[::-1]))
    square180 = list(zip(*square90[::-1]))
    square270 = list(zip(*square180[::-1]))

    for i in range(N):
        print("".join(square90[i]), "".join(square180[i]), "".join(square270[i]))