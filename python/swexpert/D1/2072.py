T = int(input())
for t in range(1, T+1):
    numbers = [*map(int, input().split())]
    res = 0
    for number in numbers:
        if number %2 != 0:
            res += number
    print("#{0} {1}".format(t, res))

# res_arr = []
# for i in range(T):
#     res = 0
#     numbers = [*map(int, input().split())]
#     for number in numbers:
#         if number % 2 != 0:
#            res += number
#     res_arr.append(res)

# print("")
# for i in range(1, len(res_arr)+1):
#     print("#" + str(i) + " " + str(res_arr[i-1]))