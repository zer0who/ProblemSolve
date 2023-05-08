pib = [0, 1] + [0]*19
for i in range(2, 21):
    pib[i] = pib[i-2] + pib[i-1]
print(pib[int(input())])