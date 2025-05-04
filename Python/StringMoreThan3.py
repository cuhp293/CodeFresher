s = str(input())

def format(s):
    if len(s) < 3:
        print(s)
    else:
        s1 = s[-3:]
        if 'ing' in s1:
            print(s + "ly")
        else:
            print(s + "ing")
format(s)