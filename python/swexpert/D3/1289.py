T = int(input())
for t in range(1, T+1):
    result = 0
    memory = input()
    num_flag = 0
    for i in range(len(memory)):
        if int(memory[i]) != num_flag:
            num_flag = int(memory[i])
            result += 1

    print("#{} {}".format(t, result))