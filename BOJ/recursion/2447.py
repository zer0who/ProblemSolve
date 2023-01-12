# def drawStar(array):
#     array2 = []
#     for a in array:
#         a = a*3
#         array2.append(a)
#     for a in array:
#         a = a + " "*len(array) + a
#         array2.append(a)
#     for a in array:
#         a = a*3
#         array2.append(a)
    
#     return array2


# def main():
#     N = int(input())
#     star = ["***", "* *", "***"]
#     count = 0
#     while N > 3:
#         N = N // 3
#         count += 1
#     for _ in range(count):
#         star = drawStar(star)
    
#     for s in star:
#         print(s)


# if __name__ == "__main__":
#     main()


def drawStar(N):
    result = []
    if N == 1:
        return ["*"]
    
    star = drawStar(N//3)
    for s in star:
        result.append(s*3)
    for s in star:
        result.append(s + " " * (N//3) + s)
    for s in star:
        result.append(s*3)

    return result


def main():
    N = int(input())
    star = drawStar(N)
    for s in star:
        print(s)


if __name__ == "__main__":
    main()