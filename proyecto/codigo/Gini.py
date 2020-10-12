
import numpy as np

import pandas as pd def leer(archivo):

    datos = pd.read_csv(archivo, header = 0, sep = ";", encoding = "utf-8")

    return datos   def gini(m, posVariable):

    alumnosExitosos = 0

    alumnosNoExitosos = 0

    for fila in range(0, len(m)):

        if int(m[fila][77]) == 1:

            alumnosExitosos += 1

        elif int(m[fila[77]]) == 0:

            alumnosNoExitosos += 1

    alumnos = alumnosExitosos + alumnosNoExitosos

    pExito = alumnosExitosos/alumnos

    pFracaso = alumnosNoExitosos/alumnos

    impureza = 1 - (pExitos**2 + pFracaso**2)

    return gini def giniPonderado(m1, m2, posVariable):

    gini1 = gini(m1, posVariable)

    gini2 = gini(m2, posVariable)

    tamaño1 = len(m1)

    tamaño2 = len(m2)

    impurezaPonderada = ((tamaño1*gini1)+(tamaño2*gini2))/(tamaño1 + tamaño2)

    return giniPonderado

