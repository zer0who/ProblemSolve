N = input()
arr = []
for i in range(len(N)):
    arr.append(N[i])
arr.sort(reverse=True)
for i in range(len(arr)):
    print(arr[i], end="")