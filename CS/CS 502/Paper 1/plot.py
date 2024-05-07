import matplotlib.pyplot as plt
import pandas as pd
from sklearn.linear_model import LinearRegression

pd.set_option("display.precision", 10)
data = pd.read_csv("timing.csv", sep=";")
print(data)
print()


def plot_with_reg_model(ax, model, X, y, label):
    
    """
    Function to generate a graph with a linear model overlayed on it
    
    :param ax: axis to plot the data points and model
    :param model: model object to plot
    :param X: x coordinate to fit and plot (independent variable)
    :param y: y coordinate to fit and plot (predictor variable)
    :param label: A string to label the plot object (Used for legends when plotting categorical data)
    
    """
    
    # Reshapes the X vector for modeling if its a single list
    if len(X.shape) == 1: 
        X = X.to_frame()

    model.fit(X, y)
    m = model.coef_
    ax.scatter(X, y, label=label)
    ax.plot(X, model.predict(X), label=f"$\sqrt{{T}}$={m[0]:.6f}N")

    print(f"{label} model R^2: {model.score(X,y)}\n")
    

#  Generate the first figure and save (Will illustrate time complexities by implemetntation on separate plots)
fig = plt.figure(figsize=(10, 5))
fig.suptitle("Time Complexity of Gnomesort", fontsize=16, fontweight="bold")
colors = [None, "orange"]
nrow = 2
for i in range(1, nrow + 1):
    ax = fig.add_subplot(nrow, 1, i)
    ax.plot(data[data.columns[0]], data[data.columns[i]], color=colors[i - 1], marker=".")
    ax.set(xlabel="Array Size", ylabel="time (s)")
    ax.set_title(label =f'{data.columns[i].strip(" time")} Implementation', fontsize=14)

fig.tight_layout(h_pad=1.5)
fig.savefig("time vs input size", dpi=300)


#  Generate the second plot and save (Will illustrate time complexities using transformed data and a fitted model)
fig2 = plt.figure(figsize=(10, 5))
fig2.suptitle("Square root Transformed Time Complexity",
              fontsize=16, fontweight="bold")
ax = fig2.add_subplot(111)
lin_reg = LinearRegression(fit_intercept=False) # Fits a linear regression model with no intercept to estimate the slopes of the lines
plot_with_reg_model(ax, lin_reg, data["Size"], data["C time"] ** (1 / 2), "C")
plot_with_reg_model(ax, lin_reg, data["Size"], data["Python time"] ** (1 / 2), "Python")
ax.legend(fontsize=14)
ax.set_xlabel("Array Size", fontsize=14)
ax.set_ylabel(r"$\sqrt{time \; (s)}$", fontsize=14)
fig2.savefig("square root transformed vs input size", dpi=300)

plt.show()
plt.close()
