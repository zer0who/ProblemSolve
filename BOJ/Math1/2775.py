for i in range(int(input())):
    answer = 0
    flr = int(input())
    num = int(input())
    flr_arr = [i for i in range(1, num+1)]
    for i in range(flr):
        for j in range(1, num):
            flr_arr[j] = flr_arr[j] + flr_arr[j-1]
    print(flr_arr[num-1])