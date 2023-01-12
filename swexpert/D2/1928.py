# base_64_upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
# base_64_dict = {i: ord(i)-65 for i in base_64_upper}
# for a in base_64_upper.lower():
#     base_64_dict[a] = ord(a) - 71
# for i in range(0, 10):
#     base_64_dict[str(i)] = ord(str(i)) + 4
# base_64_dict["+"] = ord("+") + 19
# base_64_dict["/"] = ord("/") + 19

# T = int(input())
# for i in range(1, T+1):
#     encoded_string = input()
#     decoded_string = ""
#     for j in range(0, len(encoded_string), 4):
#         base64_decoded_num = ""
#         binary_str = ""
#         base64_str = encoded_string[j:j+4]
        
#         for string in base64_str:
#             if base_64_dict[string] < 10:
#                 base64_decoded_num = base64_decoded_num + "0" + str(base_64_dict[string])
#             else:
#                 base64_decoded_num = base64_decoded_num + str(base_64_dict[string])
        
#         for k in range(0, len(base64_decoded_num), 2):
#             binary_str = binary_str + format(int(base64_decoded_num[k:k+2]), 'b').zfill(6)
#         for l in range(0, len(binary_str), 8):
#             decoded_string = decoded_string + chr(int(binary_str[l:l+8], 2))
        
#     print("#{0} {1}".format(i, decoded_string))

import base64

T = int(input())
for i in range(1, T+1):
    encoded_string = input()
    string = encoded_string.encode("UTF-8")
    decoded_string = base64.b64decode(string)
    print("#{0}".format(i), decoded_string.decode("UTF-8"))