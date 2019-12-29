

def spiral(n, matrix):
    sp = []
    m = n
    i = 0
    j = 0
    while i < n and j < m:
        print(matrix[i][j])
        i += 1


if __name__ == '__main__' : 
    n = int(input('Enter n'))
    matrix = []
    for i in range(n) : 
        row = []
        for j in range(n) : 
            row.append(int(input()))
        matrix.append(row)
    spiral(n, matrix)