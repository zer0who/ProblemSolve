A = int(input())
B = int(input())
C = int(input())
D = str(A*B*C)
num_array = []
for i in range(len(D)):
    num_array.append(int(D[i]))
for i in range(10):
    count = 0
    for num in num_array:
        if num == i:
            count += 1
    print(count)