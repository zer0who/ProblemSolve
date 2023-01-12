def solution(s):
    count = 0
    zero_count = 0
    while True:
        if s == "1":
            break
        temp = ""
        for i in range(len(s)):
            if s[i] == "1":
                temp += s[i]
            elif s[i] == "0":
                zero_count += 1
                
        len_temp = len(temp)
        binary = ""
        while True:
            if len_temp == 1:
                binary = "1" + binary
                break
            binary = str((len_temp % 2)) + binary
            len_temp = len_temp // 2
        count += 1
        s = binary
    
    answer = [count, zero_count]
    return answer