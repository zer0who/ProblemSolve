N = int(input())
length_N = len(str(N))
smallest_creator = 0

for i in range(N):
    sum = i
    for j in range(len(str(i))):
        sum += int(str(i)[j])
    if sum == N:
        smallest_creator = i
        break


print(smallest_creator)