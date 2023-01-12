line_arr = input().split("_")

for i in range(len(line_arr)):
    line_arr[i] = line_arr[i].upper()
    
print("_".join(line_arr))