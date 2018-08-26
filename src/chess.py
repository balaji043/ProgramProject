import numpy as np

chess = np.chararray((8,8))
i, j = 0, 0
file = " abcedefgh"
fem = input()
bor = input()
#print(chess)
for s in range(len(fem)):
    if fem[s] != "/":
        if fem[s] == '1' or fem[s] == '2' or fem[s] == '3' or fem[s] == '4' or fem[s] == '5' or fem[s] == '6' or fem[s] == '7' or fem[s] == '8':
            for j in range(int(fem[s])):
                chess[0][i] ='a'
                i += 1
            i=0
        else:
            chess[0][i] = fem[s]
            i += 1
print('[')
if bor == "b":
    for rank in range(8, 0, -1):
        for j in range(8):
            if chess[8 - rank][j] == 'p':
                if chess[8 - rank + 1][j] == ' ':
                    print(file[j + 1], rank, file[j + 1], rank - 1)
                if j != 0:
                    if chess[8 - rank + 1][j - 1] == 'R' or chess[8 - rank + 1][j - 1] == 'N' or chess[8 - rank + 1][j - 1] == 'B' or chess[8 - rank + 1][j - 1] == 'Q' or chess[8 - rank + 1][j - 1] == 'K':
                        print(",", file[j + 1], rank, file[j + 2], rank - 1)
                    if (chess[8 - rank + 1][j + 1] == 'R' or chess[8 - rank + 1][j + 1] == 'N' or chess[8 - rank + 1][
                        j + 1] == 'B' or chess[8 - rank + 1][j + 1] == 'Q' or chess[8 - rank + 1][j + 1] == 'K'):
                        print(",", file[j + 1], rank, file[j + 2], rank - 1)
else:
    for rank in range(1, 8):
        if chess[8 - rank][j] == 'P':
            if chess[8 - rank - 1][j] == ' ':
                print(file[j + 1], rank, file[j + 1], rank + 1)
            if j != 0:
                if chess[8 - rank - 1][j - 1] == 'r' or chess[8 - rank - 1][j - 1] == 'n' or chess[8 - rank - 1][j - 1] == 'b' or chess[8 - rank - 1][j - 1] == 'q' or chess[8 - rank - 1][j - 1] == 'k':
                    print(",", file[j + 1], rank, file[j], rank + 1)
                if chess[8 - rank - 1][j + 1] == 'r' or chess[8 - rank - 1][j + 1] == 'n' or chess[8 - rank - 1][j + 1] == 'b' or chess[8 - rank - 1][j + 1] == 'q' or chess[8 - rank - 1][j + 1] == 'k':
                    print(",", file[j + 1], rank, file[j + 2], rank + 1)
print("]")
print(chess)
'8/8/8/1k6/p7/1N6/8/2K5 b'
