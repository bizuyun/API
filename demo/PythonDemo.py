# encoding=utf-8
import hmac
import hashlib
import base64
import json
import time

import requests


class FubtApi:
    def __init__(self, api_config):
        self.api_config = api_config
        self.api_url = 'https://api.fubt.co/v1'
    
    def get_sign(self, params):
        keys = sorted(params.keys())
        s = '&'.join(['%s=%s' % (k, params[k]) for k in keys])
        print(s)
        h = hmac.new(self.api_config['secret'].encode('utf-8'), s.encode('utf-8'), hashlib.sha256)
        return base64.b64encode(h.digest())

    def fetch_tickers(self, symbol):
        endpoint = '/market/tickers'
        params = {
            "symbol": self.clean(symbol),
            "accessKey": self.api_config['apiKey']
        }
        
        rsp = requests.get(self.api_url +  endpoint, params=params)
        if rsp.status_code != 200:
            return None
        data = rsp.json()['data']
        return data

    def fetch_ticker(self, symbol):
        endpoint = '/market/ticker'
        params = {
            "symbol": self.clean(symbol),
            "accessKey": self.api_config['apiKey']
        }

        rsp = requests.get(self.api_url +  endpoint, params=params)
        if rsp.status_code != 200:
            return None
        data = rsp.json()['data']
        return data
    
    def create_order(self, symbol, order_type, side, amount, price):
        endpoint = '/order/saveEntrust'
        params = {
            "count": amount,
            "matchType": "LIMIT",
            "payPwd": self.api_config['payPwd'],
            "price": price,
            "symbol": self.clean(symbol),
            "type": side.upper(),
            "accessKey": self.api_config['apiKey'],
            "timestamp": int(time.time() * 1000)
        }
        params['signature'] = self.get_sign(params).decode('utf-8')
        headers = {
            "content-type": "application/json;charset=UTF-8"
        }
        rsp = requests.post(self.api_url +  endpoint, data=json.dumps(params), headers=headers)
        if rsp.status_code != 200:
            return None
        data = rsp.json()
        if data['status'] != 'success':
            print(data['status'])
            return None
        return data['data']
    
    def fetch_balance(self):
        endpoint = '/personal/getUserFinanceList'
        params = {
            "selectType": "all",
            "accessKey": self.api_config['apiKey']
        }

        rsp = requests.get(self.api_url + endpoint, params=params)
        if rsp.status_code != 200:
            return None
        data = rsp.json()
        coin2balance = {}
        for item in data['data']:
            coin2balance[item['coinName']] = item['total']
        return coin2balance
    
    def clean(self, symbol):
        return symbol.replace('/', '').lower()

    def fetch_open_orders(self, symbol):
        endpoint = '/order/openOrders'
        params = {
            "symbol": self.clean(symbol),
            "accessKey": self.api_config['apiKey']
        }

        rsp = requests.get(self.api_url + endpoint, params=params)
        if rsp.status_code != 200:
            return None
        data = rsp.json()
        return data['data']
    
    def cancel_order(self, order_id):
        endpoint = '/order/cancelEntrust'
        params = {
            "id": order_id,
            "accessKey": self.api_config['apiKey'],
            "timestamp": int(time.time() * 1000)
        }
        params['signature'] = self.get_sign(params).decode('utf-8')
        headers = {
            "content-type": "application/json;charset=UTF-8"
        }
        rsp = requests.post(self.api_url + endpoint, data=json.dumps(params), headers=headers)
        if rsp.status_code != 200:
            return 'fail'
        data = rsp.json()
        if data['status'] != 'success':
            print(data['status'])
            return 'fail'
        return 'ok'
