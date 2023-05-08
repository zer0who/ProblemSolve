T = int(input())
for t in range(1, T+1):
    count = 1
    input_string = input()
    if input_string[0] != "a":
        print("#{} {}".format(t, 0))
        continue
    for i in range(len(input_string)-1):
        if ord(input_string[i+1]) - ord(input_string[i]) == 1:
            count += 1
        else:
            break

    print("#{} {}".format(t, count))
