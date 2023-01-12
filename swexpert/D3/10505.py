T = int(input())
for t in range(1, T+1):
    result = 0
    N = int(input())
    incomes = [*map(int, input().split())]
    average = sum(incomes) / N
    for income in incomes:
        if income <= average:
            result += 1

    print("#{} {}".format(t, result))