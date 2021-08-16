import dash
import dash_core_components as dcc
import dash_html_components as html
import pandas_datareader as web
from datetime import datetime
import plotly.graph_objects as go
from dash.dependencies import Output, Input, State
from pandas_datareader._utils import RemoteDataError
from yfinance import Ticker
from dash.exceptions import PreventUpdate

start, end = datetime(2021, 1, 1), datetime.now()
external_stylesheets = ['https://codepen.io/chriddyp/pen/bWLwgP.css']
app = dash.Dash(__name__, external_stylesheets=external_stylesheets)
app.title = 'Stocks App'

app.layout = html.Div([
    html.H1('Stocks App'),
    html.Img(src='/assets/stock-icon.png'),
    html.Div([dcc.Input(id='stock-input', type='text', value='AAPL', placeholder='Enter Ticker'),
              html.Button('Submit', id='submit-button'), html.H2(id='company-name'),
              ], className='stock-form'),
    html.Div(
        [dcc.Checklist(
            id='toggle-range-slider',
            options=[{'label': 'Include Range Slider',
                      'value': 'slider'}],
            value=[]
        ),
            dcc.Graph(id="graph"),
        ])

], className='banner')


@app.callback([Output('graph', 'figure'),
               Output('company-name', 'children')],
              [Input('submit-button', 'n_clicks'), Input("toggle-range-slider", "value"),
               State('stock-input', 'value')])
def update(n_clicks, value, input_stock):
    try:
        if n_clicks is not None:
            ticker = input_stock
        else:
            ticker = 'AAPL'
        df = web.DataReader(ticker, 'yahoo', start, end)
    except RemoteDataError:
        raise PreventUpdate

    fig = go.Figure(go.Candlestick(
        x=df.index,
        open=df['Open'],
        high=df['High'],
        low=df['Low'],
        close=df['Close']
    ))

    fig.update_layout(xaxis_rangeslider_visible='slider' in value)
    return fig, Ticker(ticker).info['shortName']


if __name__ == '__main__':
    app.run_server(debug=True, port=8888)
