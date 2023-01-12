T = int(input())
for t in range(1, T+1):
    testcase = str(input())
    reverse = []
    for i in range(len(testcase)-1, -1, -1):
        reverse.append(testcase[i])
    reversed_testcase = "".join(reverse)
    print("#{}".format(t), end=" ")
    if reversed_testcase == testcase:
        print(1)
    else:
        print(0)