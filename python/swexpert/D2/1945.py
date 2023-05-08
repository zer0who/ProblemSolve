T = int(input())
compare = [2, 3, 5, 7, 11]
for i in range(1, T+1):
    N = int(input())
    answer = [0] * 5
    for j in range(0, 5):
        while(True):
            if N % compare[j] == 0:
                answer[j] += 1
                N = N / compare[j]
            else:
                break
    # while(N%2 == 0):
    #     answer[0] += 1
    #     N = N / 2
    # while(N%3 == 0):
    #     answer[1] += 1
    #     N = N / 3
    # while(N%5 == 0):
    #     answer[2] += 1
    #     N = N / 5
    # while(N%7 == 0):
    #     answer[3] += 1
    #     N = N / 7
    # while(N%11 == 0):
    #     answer[4] += 1
    #     N = N / 11
    
    print("#{0} {1} {2} {3} {4} {5}".format(i, answer[0], answer[1], answer[2], answer[3], answer[4]))