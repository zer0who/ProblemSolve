T = int(input())
days = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
for t in range(1, T+1):
    result = 0
    mon1, day1, mon2, day2 = map(int, input().split())
    if mon1 == mon2 :
        result = day2 - day1 + 1
    else:
        result += (days[mon1-1] - day1 + 1)
        for j in range(mon1, mon2-1, 1):
            result += days[j]
        result += day2

    print("#{0}".format(t), result)