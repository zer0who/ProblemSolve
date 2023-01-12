vowels = ["a", "e", "i", "o", "u"]

T = int(input())
for t in range(1, T+1):
    result = []
    testcase = input()
    for alphabet in testcase:
        if alphabet not in vowels:
            result.append(alphabet)

    print("#{}".format(t), end=" ")
    for r in result:
        print(r, end="")
    print("")