def show(s):
    count_upper = 0
    count_lower = 0
    for i in s:
        if i.isupper():
            count_upper += 1
        if i.islower():
            count_lower += 1
    print("Given string: " + s)
    print("Number of uppercase letters:", count_upper)
    print("Number of lowercase letters:", count_lower)


s = str(input())
show(s)