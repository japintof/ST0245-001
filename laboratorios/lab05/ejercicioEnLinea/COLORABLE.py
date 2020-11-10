#Inspirado de https://www.geeksforgeeks.org/bipartite-graph/
#Realizado con ayuda de David Vergara
import numpy as np

informacion = ["3", "3", "01", "12", "20", "3", "2", "01", "21", "9", "8", "01", "02", "03", "04", "05", "06", "07", "08"]
instrucciones = []
n = len(informacion)
lista = []
lista.append(informacion[0])
lista.append(informacion[1])

for i in range(2, n):
    if len(informacion[i]) == 1 and len(informacion[i + 1]) == 1:
        instrucciones.append(lista)
        lista = []
        lista.append(informacion[i])

    else:
        lista.append(informacion[i])
instrucciones.append(lista)

m = len(instrucciones)
for j in range(0, m):
    tamaño = int(instrucciones[j][0])
    uniones = int(instrucciones[j][1])
    mat_uniones = np.zeros([tamaño, tamaño], dtype=int)
    rojo = [-1 for i in range(tamaño)]

    rojo[0] = 1
    posible = True
    for i in range(2, uniones + 2):
        mat_uniones[int(instrucciones[j][i][0])][int(instrucciones[j][i][1])] = 1
        mat_uniones[int(instrucciones[j][i][1])][int(instrucciones[j][i][0])] = 1

    # se recorre
    for n in range(0, tamaño):
        for m in range(0, tamaño):
            if mat_uniones[n][m] == 1 and rojo[m] == -1:
                azul[m] = 1 - rojo[n]
            elif mat_uniones[n][m] == 1 and rojo[m] == rojo[n]:
                possible = False

    if posible == False:
        print("NO BICOLORABLE")
    else:
        print("BICOLORABLE")