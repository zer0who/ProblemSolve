T = int(input())

for t in range(1, T+1):
    N = int(input())
    answer = sorted([*map(int, input().split())])
    
    print("#{0}".format(t), end = " ")
    for i in range(N):
        print(answer[i], end = " ")
    print("")