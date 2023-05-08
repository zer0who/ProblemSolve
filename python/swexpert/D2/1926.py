N = int(input())
for i in range(1, N+1):
    if "3" in str(i) or "6" in str(i) or "9" in str(i):
        num_for_dash = str(i)
        for j in range(len(num_for_dash)):
            if num_for_dash[j] == "3" or num_for_dash[j] == "6" or num_for_dash[j] == "9":
                print("-", end="")
        print("", end=" ")
    else:
        print(i, end=" ")