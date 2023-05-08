def noSelfNumber():
    nonSelf = [i for i in range(1, 10001)]
    for i in range(1, 10001):
        if i < 10:
            if i+i in nonSelf:
                nonSelf.remove(i+i)
        if i>=10 and i<100:
            if i+(i//10)+(i%10) in nonSelf:
                nonSelf.remove(i+(i//10)+(i%10))
        if i>=100 and i<1000:
            if i+(i//100)+((i%100)//10)+(i%10) in nonSelf:
                nonSelf.remove(i+(i//100)+((i%100)//10)+(i%10))
        if i>=1000:
            if i+(i//1000)+((i%1000)//100)+((i%100)//10)+(i%10) in nonSelf:
                nonSelf.remove(i+(i//1000)+((i%1000)//100)+((i%100)//10)+(i%10))
    for num in nonSelf:
        print(num)
noSelfNumber()