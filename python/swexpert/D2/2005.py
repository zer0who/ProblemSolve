def factorial(num):
    if num > 1:
        return num * factorial(num - 1)
    else:
        return 1


T = int(input())
for t in range(1, T+1):
    N = int(input())
    triangle = []
    for i in range(N):
        temp = []
        if i == 0:
            temp.append(1)
        else:
            for j in range(i+1):
                temp.append(factorial(i) // (factorial(j)*factorial(i-j)))
        triangle.append(temp)

    print("#{}".format(t))
    for row in triangle:
        for i in range(len(row)):
            print(row[i], end=" ")
        print("")