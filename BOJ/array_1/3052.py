n_arr = []
for i in range(10):
    n_arr.append(int(input()) % 42)
n_arr = set(n_arr)
n_arr = list(n_arr)
print(len(n_arr))