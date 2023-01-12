S = input()
sep_str = set()
for i in range(len(S)):
    for j in range(len(S)):
        sep_str.add(S[j:j+i])

print(len(sep_str))