def isPalindrome(word):
    for i in range(len(word)):
        if word[i] != word[-i-1]:
            return False

    return True


for t in range(1, 11):
    result = 0
    N = int(input())
    board = [[input()] for i in range(8)]
    for i in range(8):
        col_string = ""
        for j in range(8):
            if j <= 8-N:
                if isPalindrome(board[i][0][j:j+N]):
                    result += 1
            col_string += board[j][0][i]

        for j in range(8-N+1):
            if isPalindrome(col_string[j:j+N]):
                result += 1

    print("#{} {}".format(t, result))
