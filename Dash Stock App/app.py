import dash
from dash import dcc
from dash import html
from datetime import datetime,date
import plotly.graph_objects as go
from plotly.subplots import make_subplots
from dash.dependencies import Output, Input, State
from yfinance import Ticker
from dash.exceptions import PreventUpdate
import re

year_now = datetime.now().year
start, end = datetime(year_now, 1, 1), datetime.now()
external_stylesheets = ['https://codepen.io/chriddyp/pen/bWLwgP.css']
app = dash.Dash(__name__, external_stylesheets=external_stylesheets)
app.title = 'Stocks App'
range_select_params = dict(
    buttons=list([
        dict(count=1,
             label="1m",
             step="month",
             stepmode="backward"),
        dict(count=6,
             label="6m",
             step="month",
             stepmode="backward"),
        dict(count=1,
             label="YTD",
             step="year",
             stepmode="todate"),
        dict(count=1,
             label="1y",
             step="year",
             stepmode="backward"),
        dict(count=2,
             label="2y",
             step="year",
             stepmode="backward"),
        dict(step="all")
    ])
)




def make_graph(df,company_name):





    candlestick_chart = go.Candlestick(
        x=df.index,
        open=df['Open'],
        high=df['High'],
        low=df['Low'],
        close=df['Close'])

    vol_chart = go.Scatter(x=df.index, y=df.Volume, line={'color': 'blue'})

    fig = make_subplots(2, 1, shared_xaxes=True, vertical_spacing=0.15,
                        subplot_titles=[f'{company_name} Historical Prices', f'{company_name} Sales Volume'])
    fig.add_trace(candlestick_chart, row=1, col=1)
    fig.add_trace(vol_chart, row=2, col=1)
    fig['layout'].update(height=800,
                         xaxis=dict(rangeselector=range_select_params, rangeslider=dict(visible=False), type='date'),
                         xaxis2=dict(rangeselector=range_select_params, rangeslider=dict(visible=False), type='date'

                                     ))
   
    return fig


app.layout = html.Div([
    html.H1('Stocks App'),
    html.Img(src='/assets/stock-icon.png'),
    html.Div([
        dcc.Input(id='stock-input-box', type='text', value='AAPL', placeholder='Enter Ticker'),
        html.Button('Submit', id='submit-button')
    ], className='stock-form'),
    html.Div([

        dcc.Graph(id="graph")
    ])
], className='banner')


@app.callback(
    [Output('graph', 'figure')],
    [Input('submit-button', 'n_clicks'), State('stock-input-box', 'value'),
     ],[Input('graph', 'relayoutData')]
)
def update(clicks, input_stock,relayout_data):
    
    try:
        ticker = Ticker(input_stock)

    except Exception:
        raise PreventUpdate


    df = ticker.history(period='5y')
    company_name = ticker.info['shortName']
 
    
    if relayout_data is not None and all(re.match(r'\d{4}-\d{2}-\d{2}', 
                        str(i)) for i in relayout_data.values()):
            start,end = relayout_data.values()
            
            filtered_df = df.loc[start:end]
            fig = make_graph(filtered_df,company_name)
    else:
         fig = make_graph(df,company_name)


    return fig,


if __name__ == '__main__':
    
    app.run(debug=True, port=8888)

