T = int(input())
for _ in range(T):
    result = 1
    closet = {}
    N = int(input())
    for _ in range(N):
        name, category = map(str, input().split())
        if category not in closet:
            closet[category] = 1
        else:
            closet[category] += 1
    
    for key in closet:
        result *= (closet[key] + 1)  # 각 옷 종류에 안 고르는 경우 1가지 추가해서 곱해줌

    print(result - 1)