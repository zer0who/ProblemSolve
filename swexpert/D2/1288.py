T = int(input())
for i in range(1, T+1):
    N = int(input())
    zero_to_nine = [0] * 10
    count = 0
    while(True):
        count += 1
        whole_num = N
        while(True):
            last_num = str(whole_num)[-1]
            zero_to_nine[int(last_num)] += 1
            if whole_num < 10:
                break
            whole_num = whole_num // 10
        if 0 not in zero_to_nine:
            print("#{0} {1}".format(i, N))
            break
        N = (N//count) * (count+1)