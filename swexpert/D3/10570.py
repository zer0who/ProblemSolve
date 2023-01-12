def isPalindrome(number):
    for index in range(len(number)):
        if number[index] != number[-index-1]:
            return False

    return True


T = int(input())
for t in range(1, T+1):
    result = 0
    A, B = map(int, input().split())
    for i in range(A, B+1):
        square_root = int(i**(1/2))
        if i**(1/2) == square_root:   # 제곱수이면
            if isPalindrome(str(i)): # 팰린드롬인지 검사
                if isPalindrome(str(square_root)):  # 제곱근도 팰린드롬이면 +1
                    result += 1

    print("#{} {}".format(t, result))
