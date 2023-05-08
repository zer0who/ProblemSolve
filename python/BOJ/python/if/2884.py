H, M = input().split()
H = int(H)
M = int(M)
if M < 45:
    if H == 0:
        H = 24
    print(H-1, 60-(45-M))
else:
    print(H, M-45)