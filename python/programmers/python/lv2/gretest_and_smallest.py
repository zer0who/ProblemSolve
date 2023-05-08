def solution(s):
    # max_num = -100000
    # min_num = 100000
    # num = ""
    # for i in range(len(s)):
    #     num += s[i]
    #     if s[i] == " " or i == len(s)-1:
    #         if int(num) < min_num:
    #             min_num = int(num)
    #         if int(num) > max_num:
    #             max_num = int(num)
    #         num = ""

    # answer = str(min_num) + " " + str(max_num)
    numbers = list(map(int, s.split()))
    answer = str(min(numbers)) + " " + str(max(numbers))
    
    return answer