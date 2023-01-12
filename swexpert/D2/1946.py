T = int(input())

for i in range(1, T + 1):
    N = int(input())
    compressed_script_dictionary = {}
    answer_script = []
    for j in range(N):
        compressed_script, count = map(str, input().split())
        count = int(count)
        compressed_script_dictionary[compressed_script] = count
    
    origin_script = ""
    for script in compressed_script_dictionary:
        origin_script += script * compressed_script_dictionary[script]
    
    for j in range(0, len(origin_script), 10):
        try:
            answer_script.append(origin_script[j:j+10])
        except:
            answer_script.append(origin_script[j:])

    print("#{0}".format(i))
    for answer in answer_script:
        print(answer)