def hanSu():
    N = int(input())
    count = 0
    for i in range(1, N+1):
        if i<100:
            count += 1
        else:
            if i == 1000:
                break
            if (i//100)-((i%100)//10) == ((i%100)//10)-i%10:
                count += 1
    print(count)
    
hanSu()