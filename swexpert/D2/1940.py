T = int(input())
for i in range(1, T+1):
    result = 0
    speed = 0
    N = int(input())    # number of command
    for _ in range(N):
        try:
            command, c_speed = map(int, input().split())
        except Exception as e:
            command = 0
        if command == 1:
            speed += c_speed
        elif command == 2:
            if speed < c_speed :
                speed = 0
            else:
                speed -= c_speed

        result += speed
        
    print("#{0}".format(i), result)