N = int(input())
a, b = 0, 0
count = 0
is_even = 1
for i in range(1, 100000000):
    is_even *= -1
    count += i
    if is_even == -1:
        if N <= count:
            a = count%N + 1
            b = i-(count-N)
            break
        else:
            continue
    else:
        if N <= count:
            a = i-(count-N)
            b = count%N + 1
            break
        else:
            continue

print('%d/%d' %(a, b))