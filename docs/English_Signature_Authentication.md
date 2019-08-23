### Signature authentication
---
# safety certificate

For current apikey applications and modifications, please do so on the "Personal Center - API Application" page.The AccessKey is the API access key, and the SecretKey is the key for the user to sign the request (visible only when applying).



* **Important: These two keys are closely related to account security and should not be disclosed to others at any time.
---
### Legal request structure

For security reasons, api requests other than the market api must be signed.A legitimate request consists of the following parts:



- The method request address is the access server address: https://xxx/v1 followed by the method name, such as https://xxx/v1/market/kline.



- API Access Key (accessKey) The AccessKey in the APIKEY you applied for.



- Required and optional parameters Each method has a set of required and optional parameters that define the api call.You can view these parameters and their meanings in the description of each method.



- When signing a secret, the hash-based protocol is uniformly used, and the **HmacSHA256** algorithm is used for calculation and verification.



- Signature The value calculated by the signature to ensure that the signature is valid and has not been tampered with.



# Signature operation

API requests are most likely to be tampered with while being sent over the Internet.To ensure that the request has not been changed, we will ask the user to include a signature in each request (except for the Quotes API) to verify that the parameter or parameter value has changed during the transfer.



## Signature calculation:

**Note:** When performing signature calculation, HMACSHA256 is used for signature encryption by default. If other encryption algorithms are used, the api cannot interpret the request data.Therefore, before the signature calculation, please standardize the request.



### Example:

/**GET** /v1/market/kline K line query



- **Note: In the https request path, the original request parameter value does not need to be sorted and passed the value. Only the encrypted parameters need to be sorted. Please know.**

1. The path address is https://api.fubt.co/v1/market/kline, the parameters are symbol, klineType, klineStep, accessKey, where accessKey is required, and this parameter must be added to each api interface.Specific request Please read the <a href="https://github.com/bizuyun/API/blob/master/docs/English_Request_Description.md">Request Description</a>. If the parameter does not require verification, the signature parameter may not be passed.

2. If the original path + parameter address is the following example, lift the chestnut: if the k line needs to be checked
```
 https://xxx/v1/market/kline?symbol=btcusdt&klineType=min&klineStep=step5&accessKey=*******************
```
3. **Sort the parameter names in the order of ascii codes.** The original parameter order is:
```
symbol=btcusdt&klineType=min&klineStep=step0&accessKey=*******************
```
4. The order after sorting is:
```
accessKey=*******************&klineStep=step0&klineType=min&symbol=btcusdt
```
5. The sorted parameters are calculated and encrypted, encrypted using secretKey, and the encrypted byte array is encoded into base64 by base64, and the value is added to the parameter, and the signature field is added. Finally, the url address is:
```
 https://xxx/v1/market/kline?symbol=btcusdt&klineType=min&klineStep=step5&accessKey=*******************&signature=加密过后的密文
```
### The parameter must be json when the /**POST** request is made, the other parameter API will not receive, the parameter encryption in json is the same as the GET encryption method. After the encryption is completed, add the signature in json: the encrypted ciphertext parameter can be!
