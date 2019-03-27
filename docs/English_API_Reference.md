### API Reference
---

Response parameter description:

| parameter name | Types      | 	Description |
|----------------|------------|-------------------- |
| status         |  string    |	Return status code (success, failure) success is the request success, failure is the request failure  |
| message        |  string    | Return error code |
| data	         |  Object    | Specific interface return data |

 **```Symbol```** Rule: 
Base currency + pricing currency.For example, ```BTC/USDT```, ```symbol``` is **```btcusdt```**; ```ETH/BTC```, ```symbol``` is **```ethbtc```**.Please know!

Interface list
Module	Request address	Http access type	description	Whether it is necessary to check
Market	/market/kline	GET	Get k-line data for the specified transaction pair	N
Market	/market/tickers	GET	Get information on all trading pairs	N
Market	/market/ticker	GET	Get information about the specified deal pair	N
Market	/market/trade	GET	Get historical transaction data for the specified transaction pair	N
Market	/market/depth	GET	Get the specified transaction versus depth data	N
Market	/market/tradeInfo	GET	Get all transactions against pricing units and decimal places	N
Currency transaction	/order/batchCancel	POST	Batch withdrawal by order	Y
Currency transaction	/order/batchCancelOpenOrders	POST	Batch withdrawal by condition	Y
Currency transaction	/order/matchResults	GET	Query the current transaction and historical transaction of the user	N
Currency transaction	/order/openOrders	GET	Query the user's current unfilled order	N
Currency transaction	/order/cancelEntrust	POST	Cancel an order by order-id	Y
Currency transaction	/order/saveEntrust	POST	Order	Y
Currency transaction	/order/queryMyEntrust	GET	Inquire about my order	N
Currency transaction	/order/queryMyHisEntrust	GET	Query my historical order	N
Currency transaction	/order/queryMyEntrustOrder	GET	Order transaction details	N
Currency transaction	/order/ /queryOrderById	GET	Query the order according to the id	N
Punching coins	/dw/addWithdraw	POST	Add new application for currency	Y
Punching coins	/dw/cancelWithdraw	POST	Withdrawal of coins	Y
Punching coins	/dw/queryWithdrawRecording	GET	Query user charge record	N
User assets	/personal/getUserFinanceList	GET	User asset query	N
Currency information	/coin/enabled	GET	Get a list of currency information	N
Market
GET /market/kline Get the K-line data of the specified transaction pair
Request parameters:
parameter name	Is it necessary?	Types of	Defaults	description
symbol	true	string		Transaction pair identification (btcusdt, ethusdt...)
klineType	true	string		Period identification (min, min5, min15, min30, hour1, hour4, day, week)
klineStep	true	string		Length (step0=50, STEP1=100, STEP2=150, STEP3=200, STEP4=250, STEP5=300)
Response parameters:
data: [
    [
      Highest price, opening price, lowest price, closing price, volume, time stamp
    ]
GET /market/tickers get information on all trade pairs
No request parameter
Response parameter
parameter name	Is it necessary?	Types of	description
tradeName	true	string	Transaction pair name
buy	true	number	Buy one price
sell	true	number	Sell ​​one price
high	true	number	Highest price
low	true	number	Lowest price
last	true	number	Latest price
open	true	number	Opening price
chg	true	number	Ups and downs
vol24hour	true	number	24-hour volume
Response json:
data: [
    {
      "tradeName": "transaction pair name",
      "buy": buy a price,
      "sell": Sell a price,
      "high": the highest price,
      "low": the lowest price,
      "last": the latest price,
      "open": opening price,
      "chg": ups and downs,
      "vol24hour": 24-hour volume
    }]
GET /market/ticker Get information about the specified deal pair
Request data:
| Parameter Name | Required | Type | Default | Description | | symbol | true | string | | Deal Pair Name (BTCUSDT, ETHUSDT) |

Response data:
parameter name	Is it necessary?	Types of	description
tradeName	true	string	Transaction pair name
buy	true	number	Buy one price
sell	true	number	Sell ​​one price
high	true	number	Highest price
low	true	number	Lowest price
last	true	number	Latest price
open	true	number	Opening price
chg	true	number	Ups and downs
vol24hour	true	number	24-hour volume
Response json:
data: [
    {
      "tradeName": "transaction pair name",
      "buy": buy a price,
      "sell": Sell a price,
      "high": the highest price,
      "low": the lowest price,
      "last": the latest price,
      "open": opening price,
      "chg": ups and downs,
      "vol24hour": 24-hour volume
    }]
GET /market/trade Get historical transaction data for the specified deal pair
Request parameters:
parameter name	Is it necessary?	Types of	Defaults	description
symbol	true	string		Transaction pair name (btcusdt, ethusdt)
Response parameters:
parameter name	Is it necessary?	Types of	description
price	true	number	deal price
amount	true	number	The number of transactions
direction	true	string	Deal direction (buy, sell)
time	true	number	Timestamp
Response json:
"data": [
    {
      "price": the transaction price,
      "amount": the number of transactions,
      "direction": the direction of the transaction,
      "time": timestamp
    }]
GET /market/depth Get the specified transaction vs. depth data
Request parameters:
parameter name	Is it necessary?	Types of	Defaults	description
symbol	true	string		Transaction pair identification (btcusdt, ethusdt...)
step	true	string		Depth file number (step0=0-99, step1=0-19, step2=20-39, step3=40-59, step4=60-79, step5=80-99)
Response parameters:
parameter name	Is it necessary?	Types of	description
buy	true	array[object]	Buy-depth data collection
price	true	number	price
amount	true	number	Quantity
sell	true	array[object]	Sell ​​depth data collection
price	true	number	price
amount	true	number	Quantity
Response json:
"data": {
    "buy": [
      {
        "price": price,
        "amount": quantity
      }
    ],
    "sell": [
      {
        "price": price,
        "amount": quantity
      }
    ]
GET /market/tradeInfo Get all transactions against pricing units and decimal places
No request parameter
Response parameters:
parameter name	Is it necessary?	Types of	description
symbol	true	string	Transaction pair name
baseCurrency	true	string	Base currency
quoteCurrency	true	string	Pricing currency
pricePrecision	true	number	Price decimal place
countPrescision	true	number	Number of decimal places
Response json:
"data": [
    {
      "symbol": "transaction pair name (btcusdt)",
      "baseCurrency": "base currency (btc)",
      "quoteCurrency": "counting currency (usdt)",
      "pricePrecision": price decimal places,
      "countPrescision": number of decimal places
    }
  ]
Currency transaction
POST /order/batchCancel Batch withdrawal by order ID
Request parameters:
parameter name	Is it necessary?	Types of	Defaults	description
ids	true	array[number]		No more than 50 single ids in a single order
Response parameters: status :success is successful, others are failed
Response json:
status: success
POST /order/batchCancelOpenOrders batch withdrawal by condition
Request parameters:
parameter name	Is it necessary?	Types of	Defaults	description
symbol	false	string	Transaction to symbol	
type	false	string	Buy: buy sell: sell order	
Response parameters: status :success is successful, others are failed
Response json:
status: success
GET /order/matchResults Query the current transaction and historical transaction of the user
Request parameters:
parameter name	Is it necessary?	Types of	Defaults	description
symbol	false	string	Transaction to symbol	
type	false	string	Buy: buy sell: sell order	
startTime	false	string	Query start date, date format yyyy-MM-dd HH:mm:ss	
endTime	false	string	Query end date, date format yyyy-MM-dd HH:mm:ss	
Response data:
parameter name	Is it necessary?	Types of	description
id	true	string	Order id
userId	true	string	User id
tradeId	true	string	Transaction pair id
buyCoinId	true	string	Buyer currency id
sellCoinId	true	string	Seller currency id
status	true	string	Status (no-trade: unsold some-trade: partial deal comple-trade: complete deal withdrawn: revoked)
type	true	string	Order type (buy: buy sell: sell order)
matchType	true	string	Limit: limit order market: market order
price	true	string	Commissioned unit price
count	true	string	Number of orders
amount	true	string	Total amount of entrustment
leftCount	true	string	The remaining amount
completeCount	true	string	Number completed
source	true	string	source
createTime	true	string	Creation time
fees	true	string	Handling fee
version	true	string	Version number (optimistic lock identifier)
symbol	true	string	Transaction to symbol
completePrice	true	string	Average price has been completed
completeAmount	true	string	Total completed
Response json:
"data":  [{
	"id": the order ID,
	"userId": user ID,
	"tradeId": transaction pair ID,
	"buyCoinId": the buyer currency ID,
	"sellCoinId": the seller currency ID,
	"status": status,
	"type": the order type,
	"matchType": the order type,
	"price": the unit price,
	"count": the number of delegates,
	"amount": the total amount of the commission,
	"leftCount": the remaining quantity,
	"completeCount": The quantity has been completed,
	"source": source,
	"createTime": creation time,
        "fees": handling fee,
	"version": version number,
	"symbol": "btcfbt",
	"typeName": "pay the bill",
	"completePrice": The average price has been completed.
	"completeAmount": Total completed
	}]
GET /order/openOrders Query the user's current unfilled order
Request parameters:
parameter name	Is it necessary?	Types of	Defaults	description
symbol	false	string	Transaction to symbol	
type	false	string	Buy: buy sell: sell order	
Response parameters:
parameter name	Is it necessary?	Types of	description
id	true	string	Order id
userId	true	string	User id
tradeId	true	string	Transaction pair id
buyCoinId	true	string	Buyer currency id
sellCoinId	true	string	Seller currency id
status	true	string	Status (no-trade: unsold some-trade: partial deal comple-trade: complete deal withdrawn: revoked)
type	true	string	Order type (buy: buy sell: sell order)
matchType	true	string	Limit: limit order market: market order
price	true	string	Order unit price
count	true	string	Number of orders
amount	true	string	Total price of the order
leftCount	true	string	The remaining amount
completeCount	true	string	Amount completed
completePrice	true	string	Average price
completeAmount	true	string	Total turnover
source	true	string	source
createTime	true	string	Creation time
fees	true	string	Handling fee
version	true	string	version
symbol	true	string	Transaction to symbol
Response json:
data:  [{
	"id": the order ID,
	"userId": user ID,
	"tradeId": transaction pair ID,
	"buyCoinId": the buyer currency ID,
	"sellCoinId": the seller currency ID,
	"status": status,
	"type": the type of transaction,
	"matchType": the order type,
	"price": the unit price of the order,
	"count": the number of orders,
	"amount": the total price of the order,
	"leftCount": the remaining quantity,
	"completeCount": the number of completions,
	"source": source,
	"createTime": creation time,
        "fees": handling fee,
	"version": version,
	"completePrice": the average price of the transaction,
	"completeAmount": total turnover,
        "symbol": transaction to symbol
}]
POST /order/cancelEntrust revoke an order by order-id
Request parameters:
parameter name	Is it necessary?	Types of	Defaults	description
id	true	string		Order id
Response parameters: status :success is successful, others are failed
Response json:
status: success
POST /order/saveEntrust order
Request parameters:
parameter name	Is it necessary?	Types of	Defaults	description
count	true	number		Number of orders
matchType	true	string		Limit: limit order market: market order
payPwd	true	string		transaction password
price	false	number		Entrusted price (market order can be empty)
source	false	string		Source api
symbol	true	string		Transaction to symbol
type	true	string		Buy: buy sell: sell order
Response parameters:
parameter name	Is it necessary?	Types of	description
entrustId	true	number	Order id
Response json:
data:  {
       "entrustId": single ID
}
GET /order/queryMyEntrust Query my order
Request parameters:
parameter name	Is it necessary?	Types of	Defaults	description
symbol	false	string		Transaction to symbol
matchType	false	string		Limit: limit order market: market order
type	false	string		Buy: buy sell: sell order
startTime	false	string		Query start date, date format yyyy-MM-dd HH:mm:ss
endTime	false	string		Query end date, date format yyyy-MM-dd HH:mm:ss
currentPage	false	number	1	current page number
pageSize	false	number	10	How many pieces are displayed per page
Response parameters:
parameter name	Is it necessary?	Types of	description
id	true	string	Order id
userId	true	string	User id
tradeId	true	string	Transaction pair id
buyCoinId	true	string	Buyer currency id
sellCoinId	true	string	Seller currency id
status	true	string	Status (no-trade: unsold some-trade: partial deal comple-trade: complete deal withdrawn: revoked)
type	true	string	Order type (buy: buy sell: sell order)
matchType	true	string	Limit: limit order market: market order
price	true	string	Order unit price
count	true	string	Number of orders
amount	true	string	Total price of the order
leftCount	true	string	The remaining amount
completeCount	true	string	Amount completed
completePrice	true	string	Average price
completeAmount	true	string	Total turnover
source	true	string	source
createTime	true	string	Creation time
fees	true	string	Handling fee
version	true	string	version
symbol	true	string	Transaction to symbol
Response json:
data:  {
       "pageNum": the current page,
	"pageSize": the current number of pages,
	"total": the total number of bars,
	"pages": total number of pages,
        "list":[{
	        "id": the order ID,
	        "userId": user ID,
	       "tradeId": transaction pair ID,
       	       "buyCoinId": the buyer currency ID,
	       "sellCoinId": the seller currency ID,
	       "status": status,
	       "type": the type of transaction,
	       "matchType": the order type,
       	       "price": the unit price of the order,
	       "count": the number of orders,
	       "amount": the total price of the order,
	       "leftCount": the remaining quantity,
	       "completeCount": the number of completions,
	       "source": source,
	       "createTime": creation time,
               "fees": handling fee,
	       "version": version,
	       "completePrice": the average price of the transaction,
	       "completeAmount": total turnover,
               "symbol": transaction to symbol
              }]
}
GET /order/queryMyHisEntrust Query my history order
Request parameters:
parameter name	Is it necessary?	Types of	Defaults	description
symbol	false	string		Transaction to symbol
matchType	false	string		Limit: limit order market: market order
type	false	string		Buy: buy sell: sell order
startTime	false	string		Query start date, date format yyyy-MM-dd HH:mm:ss
endTime	false	string		Query end date, date format yyyy-MM-dd HH:mm:ss
status	false	string		Comple-trade: complete transaction withdrawn: revoked
currentPage	false	number	1	current page number
pageSize	false	number	10	How many pieces are displayed per page
Response parameters:
parameter name	Is it necessary?	Types of	description
id	true	string	Order id
userId	true	string	User id
tradeId	true	string	Transaction pair id
buyCoinId	true	string	Buyer currency id
sellCoinId	true	string	Seller currency id
status	true	string	Status (no-trade: unsold some-trade: partial deal comple-trade: complete deal withdrawn: revoked)
type	true	string	Order type (buy: buy sell: sell order)
matchType	true	string	Limit: limit order market: market order
price	true	string	Order unit price
count	true	string	Number of orders
amount	true	string	Total price of the order
leftCount	true	string	The remaining amount
completeCount	true	string	Amount completed
completePrice	true	string	Average price
completeAmount	true	string	Total turnover
source	true	string	source
createTime	true	string	Creation time
fees	true	string	Handling fee
version	true	string	version
symbol	true	string	Transaction to symbol
Response json:
data:  {
       "pageNum": the current page,
	"pageSize": the current number of pages,
	"total": the total number of bars,
	"pages": total number of pages,
        "list":[{
	        "id": the order ID,
	        "userId": user ID,
	        "tradeId": transaction pair ID,
	        "buyCoinId": the buyer currency ID,
	        "sellCoinId": the seller currency ID,
	        "status": status,
	        "type": the type of transaction,
	        "matchType": the order type,
	        "price": the unit price of the order,
	        "count": the number of orders,
	        "amount": the total price of the order,
	        "leftCount": the remaining quantity,
	        "completeCount": the number of completions,
	        "source": source,
	        "createTime": creation time,
                "fees": handling fee,
	        "version": version,
	        "completePrice": the average price of the transaction,
	        "completeAmount": total turnover,
                "symbol": transaction to symbol
              }]
}
GET /order/queryMyEntrustOrder transaction details
Request parameters:
parameter name	Is it necessary?	Types of	Defaults	description
symbol	false	string		Transaction to symbol
matchType	false	string		Limit: limit order market: market order
type	false	string		Buy: buy sell: sell order
startTime	false	string		Query start date, date format yyyy-MM-dd HH:mm:ss
endTime	false	string		Query end date, date format yyyy-MM-dd HH:mm:ss
currentPage	false	number	1	current page number
pageSize	false	number	10	How many pieces are displayed per page
Response parameters:
parameter name	Is it necessary?	Types of	description
id	true	string	Transaction detail id
entrustId	true	string	Order id
type	true	string	Order type (buy: buy sell: sell order)
tradeId	true	string	Transaction pair id
buyCoinId	true	string	Buyer currency id
sellCoinId	true	string	Seller currency id
symbol	true	string	Transaction to symbol
matchType	true	string	Limit: limit order market: market order
price	true	string	Transaction unit price
count	true	string	The number of transactions
amount	true	string	Total turnover
fees	true	string	Handling fee
createTime	true	string	Transaction time
Response json:
data:  {
       "pageNum": the current page,
	"pageSize": the current number of pages,
	"total": the total number of bars,
	"pages": total number of pages,
        "list":[{
               "entrustId": the single ID,
               "type" : transaction type,
               "tradeId" : transaction pair ID,
               "buyCoinId" : the buyer currency ID,
               "sellCoinId" : the seller currency ID,
               "symbol" : transaction to symbol,
               "matchType" : Order type LIMIT: Limit order MARKET: Market order
               "price" : the unit price of the transaction,
               "count" : the number of transactions,
               "amount" : total turnover,
               "fees" : handling fee
               }]
}
GET /order/queryOrderById Query the order by ID
Request parameters:
parameter name	Is it necessary?	Types of	Defaults	description
orderId	true	number		Order id
Response parameters:
parameter name	Is it necessary?	Types of	description
id	true	string	Order id
userId	true	string	User id
tradeId	true	string	Transaction pair id
buyCoinId	true	string	Buyer currency id
sellCoinId	true	string	Seller currency id
status	true	string	Status (no-trade: unsold some-trade: partial deal comple-trade: complete deal withdrawn: revoked)
type	true	string	Order type (buy: buy sell: sell order)
matchType	true	string	Limit: limit order market: market order
price	true	string	Order price
count	true	string	Number of orders
amount	true	string	Order amount
leftCount	true	string	The remaining amount
completeCount	true	string	The number of transactions
completePrice	true	string	Average transaction price
completeAmount	true	string	Turnover
source	true	string	source
createTime	true	string	Create quantity
fees	true	string	Handling fee
version	true	string	version number
symbol	true	string	Transaction to symbol
POST /dw/addWithdraw
Request parameters:
parameter name	Is it necessary?	Types of	Defaults	description
coinName	true	string		Currency name (btc...)
withdrawAddress	true	string		Coin address
amount	true	string		Number of coins
networkFees	true	string		Handling fee
remark	false	string		Coin label
Response parameters: status :success is successful, others are failed
Response json:
status: success
POST /dw/cancelWithdraw
Request parameters:
parameter name	Is it necessary?	Types of	Defaults	description
id	true	number		User coin id
Response parameters: status :success is successful, others are failed
Response json:
status: success
GET /dw/queryWithdrawRecording Query user charge record
Request parameters:
parameter name	Is it necessary?	Types of	Defaults	description
coinName	false	string		Transaction to symbol
type	false	string		Transaction type recharge: recharge withdraw: withdrawal
startTime	false	string		Query start date, date format yyyy-MM-dd HH:mm:ss
endTime	false	string		Query end date, date format yyyy-MM-dd HH:mm:ss
currentPage	false	number	1	current page number
pageSize	false	number	10	How many pieces are displayed per page
Response parameters:
parameter name	Is it necessary?	Types of	description
id	true	string	Recharge record id
userId	true	string	User id
coinId	true	string	Currency id
type	true	string	Transaction type recharge: recharge withdraw: withdrawal
status	true	string	State wait-withdraw: Waiting for withdrawal lock: Lock withdrawal-success: Cash withdrawal success: Cancel recharging: Confirm recharge-success: Recharge successfully: Audited
amount	true	string	Quantity
networkFees	true	string	Handling fee
withdrawAddress	true	string	Coin address
rechargeAddress	true	string	Recharge address
source	true	string	source
hash	true	string	Transaction hash
successCount	true	string	Successful confirmation number
confirmationCount	true	string	Confirmation number
createTime	true	string	Creation time
updateTime	true	string	Last Modified
coinName	true	string	Currency name
Response json:
data:{
    "id": charge the record ID,
    "userId": user ID,
    "coinId": currency ID,
    "type": transaction type RECHARGE: recharge WITHDRAW: withdrawal,
    "status": state WAIT-WITHDRAW: waiting for cash withdrawal LOCK: lock WITHDRAW-SUCCESS: cash withdrawal successful CANCEL: cancel RECHARGING: confirmation RECHARGE-SUCCESS: recharge successful AUDITED: audited,
    "amount": quantity,
    "networkFees": handling fee,
    "withdrawAddress": the coin address,
    "rechargeAddress": recharge address,
    "source": source,
    "hash": trading hash,
    "successCount": successful confirmation number,
    "confirmationCount": confirmation number,
    "createTime": creation time,
    "updateTime": Last modified time,
    "coinName": the name of the currency,
}
GET /personal/getUserFinanceList user asset query
Request parameters:
parameter name	Is it necessary?	Types of	Defaults	description
selectType	true	string	all	All: Query all the assets of the user noall: query the user non-zero assets
Response parameters:
parameter name	Is it necessary?	Types of	description
coinName	true	string	Currency name
total	true	string	Available Balance
frozen	true	string	Freeze balance
financing	true	string	Financial balance
Response json:
data:{
    "coinName": the name of the currency,
    "total": available balance,
    "frozen": freeze the balance,
    "financing": financial balance

}
GET /coin/enabled Get a list of currency information
No request parameter
Response parameters:
Data:[Capital currency name]

