def dfs(n: int, numbers: list, calculator: list, used_calc: list, num_calculator: list) -> None:
    global greatest
    global smallest
    
    if len(used_calc) == n-1:
        using_calc = used_calc.copy()
        expression = numbers.copy()
        calc_res = numbers[0]
        idx = 1
        while len(using_calc) != 0:
            expression.insert(idx, using_calc[0])
            del using_calc[0]
            idx += 2

        for i in range(1, len(expression)-1):
            if i % 2 != 0:
                if expression[i] == 0:
                    calc_res += expression[i+1]
                elif expression[i] == 1:
                    calc_res -= expression[i+1]
                elif expression[i] == 2:
                    calc_res *= expression[i+1]
                else:
                    if calc_res < 0:
                        calc_res = calc_res * -1
                        calc_res = (calc_res // expression[i+1]) * -1
                    else:
                        calc_res = calc_res // expression[i+1]
        if calc_res > greatest:
            greatest = calc_res
        elif calc_res < smallest:
            smallest = calc_res

        return

    else:
        for i in range(len(calculator)):
            if num_calculator[calculator[i]] != 0:
                used_calc.append(calculator[i])
                num_calculator[calculator[i]] -= 1
                dfs(n, numbers, calculator, used_calc, num_calculator)
                used_calc.pop()
                num_calculator[calculator[i]] += 1


def main():
    global greatest
    global smallest
    greatest = -1*1000000000
    smallest = 1000000000

    N = int(input())
    numbers = [*map(int, input().split())]
    num_calculator = [*map(int, input().split())]
    temp_calculator = num_calculator.copy()
    calculator = []
    for i in range(len(temp_calculator)):
        while temp_calculator[i] != 0:
            calculator.append(i)
            temp_calculator[i] -= 1
    used_calc = []
    dfs(N, numbers, calculator, used_calc, num_calculator)
    print(greatest)
    print(smallest)


if __name__ == "__main__":
    main()