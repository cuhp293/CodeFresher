ang = []
ang.append(int(input()))
ang.append(int(input()))
ang.append(int(input()))
ang.sort()

if ang[0] + ang[1] >= ang[2]:
    if ang[0] == ang[1]:
        if ang[1] == ang[2]:
            print("Equilateral triangle")
        else:
            print("Isosceles triangle")
    else:
        print("Scalene triangle")