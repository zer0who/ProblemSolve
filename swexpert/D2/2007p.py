T = int(input())
for t in range(1, T+1):
    result = 0
    testcase = input()
    first_letter = testcase[0]
    for i in range(1, len(testcase)):
        if testcase[i] == first_letter:
            if testcase[0:i] == testcase[i:i+i]:
                result = i
                break
            else:
                continue

    print("#{} {}".format(t, result))