def recursion(testcase, l, r, count):
    if l >= r:
        return 1, count
    elif testcase[l] != testcase[r]:
        return 0, count
    else:
        count += 1
        return recursion(testcase, l+1, r-1, count)


def isPalindrome(testcase):
    return recursion(testcase, 0, len(testcase) - 1, 1)


T = int(input())
for i in range(T):
    testcase = input()
    result, count = isPalindrome(testcase)
    print(result, count)