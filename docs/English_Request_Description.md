## Request description
---
- When the request is sent, the **Host** in the request header must be the domain name **xxx**

- The **Content-Type** in the **POST** request header must be **application/json;charset=UTF-8**.

- The **POST** request parameter must be **json**, and other parameter servers will not receive it.

- In all requests, the parameter accessKey is mandatory. If the value is not passed, the service directly returns an error. **If the request method is GET, this value requires the url to encode. POST does not need .**

- All methods that require signature verification need to pass the timestamp parameter for time judgment in milliseconds.The link will be rejected if it exceeds the current time by 5 seconds.

- For all request parameters, follow the api instructions for parameter encapsulation.

- The api request that encapsulates the parameters is submitted to the server by post or get.

- The Fubt website processes the request and returns the corresponding JSON formatted results.

- Please use the https request.

- Limit the frequency (the market interface is 1 second, the trading interface is 30 times 1 second).

