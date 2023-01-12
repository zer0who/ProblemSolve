T = int(input())

for t in range(1, T+1):
    result_hour = 0
    result_minute = 0
    hour1, minute1, hour2, minute2 = map(int, input().split())

    if minute1 + minute2 > 60:
        result_hour += 1
        result_minute = minute1 + minute2 - 60
    else:
        result_minute = minute1 + minute2

    if hour1 + hour2 > 12:
        result_hour += hour1 + hour2 - 12
    elif hour1 + hour2 > 24:
        result_hour += hour1 + hour2 - 24
    else:
        result_hour += hour1 + hour2

    print("#{0}".format(t), result_hour, result_minute)