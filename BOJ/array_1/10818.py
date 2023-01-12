N = int(input())
n_array = list(map(int, input().split()))
n_array.sort()
print(n_array[0], n_array[N-1])