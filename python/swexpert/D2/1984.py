T = int(input())
for t in range(1, T+1):
    test_case = [*map(int, input().split())]
    test_case.sort()
    total = 0
    for i in range(1, 9):
        total += test_case[i]
    average = round(total / 8)

    print("#{} {}".format(t, average))