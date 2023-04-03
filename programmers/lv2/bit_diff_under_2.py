def solution(numbers):
    answer = []
    for n in numbers:
        og_bin_n = list(bin(n)[2:])
        bin_n = og_bin_n.copy()
        for i in reversed(range(len(bin_n))):            
            if bin_n[i] == "0":
                if i == len(bin_n)-1:
                    bin_n[i] = "1"   
                else:
                    bin_n[i] = "1"
                    bin_n[i+1] = "0"
                break
        if bin_n == og_bin_n:
            bin_n.insert(0, "1")
            bin_n[1] = "0"
        answer.append(int("0b" + "".join(bin_n), 2))
            
            
    return answer