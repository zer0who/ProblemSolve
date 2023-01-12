import sys
from collections import Counter

N = int(input())
arr = []
for i in range(N):
    arr.append(int(sys.stdin.readline()))
arr.sort()
counter = Counter(arr).most_common()

avg = int(round(sum(arr) / N))
mid = arr[int(len(arr)/2)]
if len(counter) == 1:
    most = counter[0][0]
else:
    most = counter[0][0]
    if counter[1][1] == counter[0][1]:
        most = counter[1][0]
num_range = arr[-1] - arr[0]

print(avg)
print(mid)
print(most)
print(num_range)