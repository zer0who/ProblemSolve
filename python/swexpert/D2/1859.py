T = int(input())
for t in range(1, T+1):
    result = 0
    N = int(input())
    price = [*map(int, input().split())]
    highest_price = price[-1]
    index_of_highest_price = N-1
    num_to_sell = -1
    for i in reversed(range(len(price))):
        if price[i] > highest_price:
            total_sell_price = num_to_sell * highest_price
            for j in range(i+1, index_of_highest_price):
                total_sell_price -= price[j]
            result += total_sell_price
            highest_price = price[i]
            index_of_highest_price = i
            num_to_sell = 0
        else:
            num_to_sell += 1

        if i == 0:
            total_sell_price = num_to_sell * highest_price
            for j in range(i, index_of_highest_price):
                total_sell_price -= price[j]
            result += total_sell_price

    print("#{} {}".format(t, result))