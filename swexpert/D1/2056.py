T = int(input())
for t in range(1, T+1):
    date = str(input())
    if 1 <= int(date[4:6]) <= 12:
        if int(date[4:6]) == 2:
            if 1 <= int(date[6:8]) <= 28:
                print("#{0} {1}/{2}/{3}".format(t, date[0:4], date[4:6], date[6:8]))
                continue
        elif int(date[4:6]) in [1, 3, 5, 7, 8, 10, 12]:
            if 1 <= int(date[6:8]) <= 31:
                print("#{0} {1}/{2}/{3}".format(t, date[0:4], date[4:6], date[6:8]))
                continue
        else:
            if 1 <= int(date[6:8]) <= 30:
                print("#{0} {1}/{2}/{3}".format(t, date[0:4], date[4:6], date[6:8]))
                continue
    print("#{0} -1".format(t))