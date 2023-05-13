def main():
    n = int(input())
    drinks = []
    for _ in range(n):
        drinks.append(int(input()))
    drunk_liter = [None for _ in range(n)]
    if n == 1:
        print(drinks[0])
    elif n == 2:
        print(drinks[0] + drinks[1])
    elif n == 3:
        print(max(drinks[0]+drinks[1], drinks[0]+drinks[2], drinks[1]+drinks[2]))
    else:
        drunk_liter[0] = drinks[0]
        drunk_liter[1] = drinks[0] + drinks[1]
        drunk_liter[2] = max(drinks[0]+drinks[1], drinks[0]+drinks[2], drinks[1]+drinks[2])
        for i in range(3, n):
            drunk_liter[i] = max(drunk_liter[i-1], drunk_liter[i-2] + drinks[i], drunk_liter[i-3] + drinks[i-1] + drinks[i])
        
        print(max(drunk_liter))

if __name__ == "__main__":
    main()