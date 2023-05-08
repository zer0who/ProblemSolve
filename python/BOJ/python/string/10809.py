S = input()
alphabet = 'abcdefghijklmnopqrstuvwxyz'
for al in alphabet:
    print(S.find(al), end = ' ')
    # if al in S:
    #     print(S.find(al), end = ' ')
    # else:
    #     print(-1, end = ' ')