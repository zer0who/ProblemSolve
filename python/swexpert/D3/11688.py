T = int(input())
for t in range(1, T+1):
    a = 1
    b = 1
    directions = input()
    for direction in directions:
        if direction == "L":
            b += a
        else:
            a += b

    print("#{} {} {}".format(t, a, b))
