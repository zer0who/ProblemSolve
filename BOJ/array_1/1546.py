N = int(input())
n_arr = list(map(int, (input().split())))
M = max(n_arr)
new_arr = []
for n in n_arr:
    new_arr.append(n/M*100)
print(sum(new_arr)/N)