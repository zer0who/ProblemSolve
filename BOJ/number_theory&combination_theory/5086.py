while(True):
    t1, t2 = map(int, input().split())
    if t1 == 0 and t2 == 0:
        break
    if t2 % t1 == 0:
        print("factor")
    elif t1 % t2 == 0:
        print("multiple")
    else:
        print("neither")