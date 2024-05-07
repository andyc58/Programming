import matplotlib.pyplot as plt
import numpy as np
import pandas as pd
import plotly.graph_objs as go
from plotly import subplots

pd.set_option("display.precision", 10)

datasets = ["gnomesort_timing.csv", "timsort_timing.csv"]
gnomesort_df, timsort_df = [pd.read_csv(dataset, sep=";") for dataset in datasets]
combined = pd.merge(gnomesort_df, timsort_df, how='right', on='Size', suffixes=('_Gnomesort', '_Timsort'))
combined.to_csv('combined.csv', sep = ';', index = False)
both = combined[combined.notna().all(axis=1)]
figures = []

timsort_comparison = go.Figure()
timsort_comparison.update_layout(width = 800, height = 400, title="Timsort in C vs Python", 
                                 xaxis_title="Size", yaxis_title="Time (s)")
timsort_comparison.add_trace(go.Scatter(x=combined["Size"], y=combined["C time_Timsort"], mode='lines+markers', name="C"))
timsort_comparison.add_trace(go.Scatter(x=combined["Size"], y=combined["Python time_Timsort"], mode='lines+markers', name="Python"))
figures.append(timsort_comparison)

labels = ["Gnomesort", "Gnomesort" ,"Timsort", "Timsort"]
fig_titles = ["Runtime Comparison of Gnomesort and Timsort Across Implementations", "Log Log transformed Runtimes"]
axis_titles = [{'x': "Size", 'y': "Time (s)"}, {'x': r"$log_2(Size)$", 'y': r"$log_2(Time (s))$"}]

for i in range(2):
    f = subplots.make_subplots(rows=2, cols=1, vertical_spacing=0.05,
                             x_title=axis_titles[i]["x"], y_title=axis_titles[i]["y"], subplot_titles=("C", "Python"), shared_xaxes=True)
    f.update_layout(width = 800, height = 800, title=fig_titles[i])
    
    
    for x, k in enumerate(both.columns[1:]):
        
        if i < 2:
            f.add_trace(go.Scatter(x=both["Size"], y=both[k], mode='lines+markers', name=labels[x]), col=1, row=x % 2 + 1)
            continue
        f.add_trace(go.Scatter(x=np.log2(both["Size"]), y=np.log2(both[k]), mode='lines+markers', name=labels[x]), col=1, row=x % 2 + 1)
    figures.append(f)   
    

for f in figures:
    f.show()
