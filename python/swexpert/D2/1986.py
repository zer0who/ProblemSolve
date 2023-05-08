T = int(input())
for t in range(1, T+1):
    N = int(input())
    result = 0
    for i in range(N):
        if (i+1) % 2 == 0:
            result -= (i + 1)
        else:
            result += (i + 1)

    print("#{} {}".format(t, result))