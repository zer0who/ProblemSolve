def solution(n):
    answer = 0
    binary_n = bin(n)[2:]
    binary_n_one = binary_n.count("1")
    while True:
        n += 1
        temp_binary_n = bin(n)[2:]
        if temp_binary_n.count("1") == binary_n_one:
            answer = n
            break
            
    return answer