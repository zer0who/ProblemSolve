def power(c, base, numeration):
    if c == numeration-1:
        return base
    else:
        c += 1
        return base * power(c, base, numeration)


for t in range(1, 11):
    testcase_num = int(input())
    N, M = map(int, input().split())
    count = 0
    result = power(count, N, M)

    print("#{} {}".format(testcase_num, result))
