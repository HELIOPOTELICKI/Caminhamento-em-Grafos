import math as m
import pandas as pd


def saveCsv(nomearquivo, arquivo):
    save = (f'Q1\{nomearquivo}.csv')
    arquivo.to_csv(save, sep=',', index=True)


df = pd.read_csv('Q1\entry.csv', sep=';')
distances = []
for i in range(0, len(df)):
    x1 = int(df['X1'][i])
    y1 = int(df['Y1'][i])
    x2 = int(df['X2'][i])
    y2 = int(df['Y2'][i])
    res = m.sqrt(((x2 - x1)**2) + ((y2 - y1)**2))
    distances.append(f'{res:.8f}')
df['Distancia'] = distances

saveCsv('exit', df)
print('saved')
