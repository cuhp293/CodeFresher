str = str(input())

def word(str):
    s1 = str.split(" ")
    print(s1)
    ans = []
    for i in s1:
        if len(i) > 3:
            ans.append(i)
    print(ans)

word(str)