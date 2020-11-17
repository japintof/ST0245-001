#!/usr/bin/env python
# coding: utf-8

# In[19]:



"""Proyecto_final
Miguel Manzur Gómez
Jorge Araujo
José Anibal Pinto
"""


import pandas as pd
import numpy
from sklearn.metrics import confusion_matrix
from sklearn.metrics import accuracy_score



def count(data: pd.DataFrame):
    
    '''
    Parámetro: data Frame.
    
    '''
    '''
    Diccionario con dos llaves, positivo y negativo de acuerdo al éxito o no éxito del estudiante,
    que permite encontrar el número de "exitosos" y "no exitosos"
    '''
    
    dicc = {}
    dicc["positivo"] = data["exito"].sum()
    dicc["negativo"] = data["exito"].count() - dicc["positivo"]  # 
    
    return dicc

def valores(serie: pd.Series):
    '''
  Parámetro: serie, una columna del data frame
    lista : Lista
        Lista con valores únicos de la columna.
    '''
    lista = []
    for key in serie.value_counts().index: 
        lista.append(key)
    return lista

class pregunta:
    '''
    Representa las preguntas posibles
    Parámetros: columnas y valores.
    '''

    def __init__(self,column,value):
        self.column=column
        self.value=value

    def aparear(self,row):
        '''
        Parámetros: fila, pregunta.
        
    Retorna:
    True ó False : Booleano
        '''
        val=row[self.column]
        if isinstance(val, str):
            return val == self.value
        else:
            return val >= self.value
        
    def __repr__(self):
        '''
         Parámetros:
    Pregunta relacionada con el nodo de interés
        
    Vuelve la pregunta un string
      
        '''
        cond="=="
        if isinstance(self.value,int) or isinstance(self.value,float):
            cond=">="
        return "Es %s %s %s?" % (self.column, cond, str(self.value))
   
    

def part(data, pregunta):
    '''
    
    Parámetros: data frame, pregunta

    '''
    '''
    Se divide el data frame, dado el cumplimiento de la condición
    '''
    if isinstance(pregunta.value, int) or isinstance(pregunta.value, float):
        true_rows = data[data[pregunta.column] >= pregunta.value]
        false_rows = data[data[pregunta.column] < pregunta.value]
    else:
        true_rows = data[data[pregunta.column] == pregunta.value]
        false_rows = data[data[pregunta.column] != pregunta.value]
    return true_rows, false_rows

def gini(data):
    '''
       Parámetros: data frame
       
    Retorna:
       La impureza de Gini de todos los datos recibidos
    '''
  
    N = count(data)
    gin = 1
    for keys in N:
        probi = N[keys] / float(len(data))
        gin -= probi ** 2
    return gin

def gananciaInfo(izq: pd.DataFrame, der: pd.DataFrame, gin):
      
    '''
       Parámetros:
    izq: data frame que no cumple la condición
    der: data frame que cumple la condición
    gini: impureza de Gini
    Retorna:
     la ganancia de información de la condición
    '''
    gInfo = float((len(izq)) / (len(izq) + len(der)))
    return gin - gInfo * gini(izq) - (1 - gInfo) * gini(der)

def mejorOpcion(data: pd.DataFrame):
    '''
    
    Parámetros: data
    
    Retorna:
    maxima : mejor ganancia de información
    mejor : pregunta con la mejor ganancia de información.
    '''
    
    """
    Encuentra la "mejor"
    """
    maxima = 0
    mejor = None
    gin = gini(data)
    for key in data.keys():
        values = valores(data[key])
        if key == "exito":
            continue
        for v in values:
            q = pregunta(key, v)
            true_rows, false_rows = part(data, q)

            if len(true_rows) == 0 or len(false_rows) == 0:
                continue
            ganancia = gananciaInfo(true_rows, false_rows, gin)

            if ganancia >= maxima:
                maxima, mejor = ganancia, q

    return maxima, mejor

class hoja:
   

    def __init__(self, data):

        self.predic =  count(data)["positivo"]/len(data)

class Nodo:
    '''
    Esta clase hace las preguntas
    '''

    def __init__(self, pregunta, True_row, False_row):
        self.pregunta = pregunta
        self.True_row = True_row
        self.False_row = False_row

def arbol(data: pd.DataFrame, prof):
    '''
    
    Parámetros: data frame, prof
    prof: profundidad deseada
    
    Retorna
   El árbol de decisión binario que realizará las predicciones
    '''
    ganancia, mejorPre = mejorOpcion(data)

    if prof==0 or ganancia==0:
        return hoja(data)
    '''
   Cuando el método llega a la profundidad deseada se detiene
    '''
    
    true_row, false_row = part(data, mejorPre)

    ramaVer = arbol(true_row,prof-1)
    ramaIzq = arbol(false_row,prof-1)
    '''
    Va disminuyendo la profundidad del árbol por 1 hasta que se detiene
    '''

    return Nodo(mejorPre, ramaVer, ramaIzq)

def printT(nodo, espacio=""):
    '''
    
    Parámetros: nodo, espacio
    
    Retorna:
   None.
    '''
    if isinstance(nodo, hoja):
        print(espacio + "predict", nodo.predic)
        return

    print(espacio + str(nodo.pregunta))

    print(espacio + '--> True:')
    printT(nodo.True_row, espacio + "  ")

    print(espacio + '--> False:')
    printT(nodo.False_row, espacio + "  ")

def clasificar(serie: pd.Series, nodo):
    '''
    
    Parámetros: serie, nodo
    
    Retorna:
    Probabilidad del éxito académico del estudiante
    1s ó 0s si el estudiante aprobó o reprobó respectivamente
    '''
    '''
    Decide si un estudiante será exitoso o no
    '''
    if isinstance(nodo, hoja):
        if nodo.predic >= 0.5:
            return nodo.predic, 1
        else:
            return nodo.predic, 0

    if nodo.pregunta.aparear(serie):
        return clasificar(serie, nodo.True_row)
    else:
        return clasificar(serie, nodo.False_row)
  

def orden(data: pd.DataFrame):
    '''
    
    Parámetros: data frame
    
    Retorna:
    Un data frame sin las columnas que no son de interés.
    '''
    data.drop(["periodo","estu_exterior",'estu_cursodocentesies','estu_tipodocumento.1','estu_nacionalidad.1','estu_genero.1','estu_fechanacimiento.1','periodo.1',
               "estu_estudiante.1",'estu_pais_reside.1','estu_inst_cod_departamento','estu_cod_reside_depto.1','estu_mcpio_reside.1','estu_cod_reside_mcpio.1',
               'fami_pisoshogar','fami_tienemicroondas','fami_tienehorno','fami_tieneautomovil.1','fami_tienedvd','fami_tiene_nevera.1','cole_codigo_icfes',
               'cole_cod_dane_establecimiento', 'cole_nombre_establecimiento','cole_genero','cole_naturaleza','cole_calendario','cole_cod_dane_sede','cole_nombre_sede',
               'cole_sede_principal','cole_cod_mcpio_ubicacion','cole_mcpio_ubicacion','cole_cod_depto_ubicacion',"estu_tieneetnia",],axis=1,inplace=True)
    data = data.fillna("")
    return data


if __name__=="__main__":
    data_train=pd.read_csv("2_test_balanced_25000.csv",sep=";", index_col=0)
    data_train=orden(data_train)
    mi_arbol=arbol(data_train, 8)
    data_test=pd.read_csv("2_test_balanced_25000.csv",sep=";", index_col=0)
    data_test=orden(data_test)
    exito=[]
    proba=[]
    print(printT(arbol(data_test, 3)," "))
    for i in range(len(data_test)):
        a,b=clasificar(data_test.iloc[i],mi_arbol)
        exito.append(b)
        proba.append(a)
    print(exito)
    print(proba)
    print(accuracy_score(data_test["exito"],exito))
    print(confusion_matrix(data_test["exito"],exito))
    
    


# In[ ]:





# In[ ]:




