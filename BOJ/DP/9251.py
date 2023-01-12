def main():
    string_a = input()
    string_b = input()
    common_sequence = [0 for _ in range(len(string_b))]

    for i in range(len(string_a)):
        temp = 0
        for j in range(len(string_b)):
            if temp < common_sequence[j]:
                temp = common_sequence[j]
            elif string_a[i] == string_b[j]:
                common_sequence[j] = temp + 1
    
    print(max(common_sequence))

if __name__ == "__main__":
    main()