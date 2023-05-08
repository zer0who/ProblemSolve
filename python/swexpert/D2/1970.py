T = int(input())
for t in range(1, T+1):
    change_dict = {"50000" : 0, "10000" : 0, "5000" : 0, "1000" : 0, "500" : 0, "100" :0, "50" : 0, "10" : 0}
    N = int(input())
    for change in change_dict:
        if N >= int(change):
            change_dict[change] += N // int(change)
            N -= int(change) * change_dict[change]
            
    print("#{0}".format(t))
    for _, num_changes in change_dict.items():
        print(num_changes, end = " ")
    print("")