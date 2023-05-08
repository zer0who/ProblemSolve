from collections import Counter

def solution(str1, str2):
    list1 = []
    list2 = []
    for i in range(len(str1)-1):
        if str1[i].isalpha() and str1[i+1].isalpha():
            list1.append(str1[i:i+2].lower())
    for i in range(len(str2)-1):
        if str2[i].isalpha() and str2[i+1].isalpha():
            list2.append(str2[i:i+2].lower())
    if len(list1) == 0 and len(list2) == 0:
        return 65536
    
    counter1 = Counter(list1)
    counter2 = Counter(list2)
    
    intersection_list = list((counter1 & counter2).elements())
    union_list = list((counter1 | counter2).elements())
    
    answer = int((len(intersection_list) / len(union_list)) * 65536)

    return answer