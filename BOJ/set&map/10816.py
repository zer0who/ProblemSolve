N = int(input())
cards = [*map(int, input().split())]
cards.sort()
M = int(input())
numbers = [*map(int, input().split())]
card_dict = {}
for card in cards:
    if card in card_dict:
        card_dict[card] += 1
    else:
        card_dict[card] = 1

for number in numbers:
    try:
        print(card_dict[number], end=" ")
    except Exception:
        print(0, end=" ")