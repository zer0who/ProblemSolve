# def priceCalculator(N: int):
#     global min_price, house_list, min_sum

#     if len(min_price) == N:
#         sum = 0
#         house_number = 0
#         for idx in min_price:
#             sum += house_list[house_number][idx]
#             house_number += 1
#         if sum < min_sum:
#             min_sum = sum

#         return

#     for i in range(3):
#         if len(min_price) == 0:
#             min_price.append(i)
#             priceCalculator(N)
#             min_price.pop()
#             continue

#         if min_price[-1] == i:
#             continue
#         min_price.append(i)
#         priceCalculator(N)
#         min_price.pop()


def main():
    N = int(input())
    house_list = []
    for _ in range(N):
        house_list.append(list(map(int, input().split())))
    price = [[0, 0, 0] for _ in range(N+1)]
    
    for i in range(1, N+1):
        price[i][0] = min(price[i-1][1], price[i-1][2]) + house_list[i-1][0]
        price[i][1] = min(price[i-1][0], price[i-1][2]) + house_list[i-1][1]
        price[i][2] = min(price[i-1][0], price[i-1][1]) + house_list[i-1][2]
    
    print(min(price[-1]))
    


if __name__ == "__main__":
    main()