package com.fubt.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fubt.bzuApiUtils.BzuApiUtil;
import com.fubt.bzuApiUtils.MapToObject;
import com.fubt.constants.Constant;
import com.fubt.constants.ConstantKey;
import com.fubt.request.*;
import com.fubt.response.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description * @Description  fubt API
 * @auther: wangzh
 * @date: 20190906
 */
public class FubtApi {

    private static Logger logger = LoggerFactory.getLogger(FubtApi.class);

    /**
     * 获取币种信息列表 1
     *
     * @return
     */
    public CoinsResponse getCoins() {
        CoinsResponse coinsResponse = new CoinsResponse();
        String method = "/coin/enabled";
        String param = "accessKey=" + URLEncoder.encode(ConstantKey.ACCESS_KEY);
        String returnJson = BzuApiUtil.sendGet(method, param);
        Map<String, Object> map = JSON.parseObject(returnJson, Map.class);
        List<String> dataList = (List) map.get("data");
        coinsResponse.setData(dataList);
        if (map.size() != Constant.NUM) {
            coinsResponse.setMessage(null);
            coinsResponse.setStatus(map.get("status").toString());
        } else {
            coinsResponse.setMessage(map.get("meta").toString());
        }
        return coinsResponse;
    }

    /**
     * 汇率折算 2
     *
     * @param shortName 币种简写 比如：CNY
     * @return Map  key为币种  value为所查法币对应的值
     */
    public ExchangeResponse queryExchange(String shortName) {
        ExchangeResponse exchangeResponse = new ExchangeResponse();
        String method = "/coin/exchange";
        String param = "shortName=" + shortName + "&accessKey=" + URLEncoder.encode(ConstantKey.ACCESS_KEY);
        String returnJson = BzuApiUtil.sendGet(method, param);
        Map<String, Object> maps = JSON.parseObject(returnJson, Map.class);
        Map<String, Object> dataList = (Map) maps.get("data");
        exchangeResponse.setData(dataList);
        if (maps.size() != Constant.NUM) {
            exchangeResponse.setMessage(null);
            exchangeResponse.setStatus(maps.get("status").toString());
        } else {
            exchangeResponse.setMessage(maps.get("meta").toString());
        }
        return exchangeResponse;
    }

    /**
     * 获得全部交易对计价单位和小数位 3
     *
     * @return
     */
    public TradeInfoResponse queryTradeInfo() {
        TradeInfoResponse tradeInfoResponse = new TradeInfoResponse();
        String method = "/market/tradeInfo";
        String param = "accessKey=" + URLEncoder.encode(ConstantKey.ACCESS_KEY);
        String returnJson = BzuApiUtil.sendGet(method, param);
        Map<String, Object> maps = JSON.parseObject(returnJson, Map.class);
        List<Map<String, Object>> list = (List<Map<String, Object>>) maps.get("data");
        List<TradeInfo> tradeInfoList = new ArrayList<>();
        if (list != null && !list.isEmpty()) {
            for (Map<String, Object> map : list) {
                tradeInfoList.add((TradeInfo) MapToObject.map2Object(map, TradeInfo.class));
            }
        }
        tradeInfoResponse.setData(tradeInfoList);
        if (maps.size() != Constant.NUM) {
            tradeInfoResponse.setStatus(maps.get("status").toString());
            tradeInfoResponse.setMessage(null);
        } else {
            tradeInfoResponse.setMessage(maps.get("meta").toString());
        }
        return tradeInfoResponse;
    }

    /**
     * 获得全部交易对的信息 4
     *
     * @return
     */
    public TickersResponse queryTickers() {
        TickersResponse tickersResponse = new TickersResponse();

        String method = "/market/tickers";
        String param = "accessKey=" + URLEncoder.encode(ConstantKey.ACCESS_KEY);
        String returnJson = BzuApiUtil.sendGet(method, param);
        Map<String, Object> maps = JSON.parseObject(returnJson, Map.class);
        List<Map<String, Object>> listMap = (List<Map<String, Object>>) maps.get("data");
        List<Tickers> list = new ArrayList<>();
        if (listMap != null && !listMap.isEmpty()) {
            for (Map<String, Object> map : listMap) {
                list.add((Tickers) MapToObject.map2Object(map, Tickers.class));
            }
        }
        tickersResponse.setData(list);
        if (maps.size() != Constant.NUM) {
            tickersResponse.setStatus(maps.get("status").toString());
            tickersResponse.setMessage(null);
        } else {
            tickersResponse.setMessage(maps.get("meta").toString());
        }
        return tickersResponse;
    }

    /**
     * 获取指定交易对的信息 5
     *
     * @param symbol
     * @return
     */
    public DTOResponse queryTicker(String symbol) {
        DTOResponse dtoResponse = new DTOResponse();
        String method = "/market/ticker";
        String param = "symbol=" + symbol + "&accessKey=" + URLEncoder.encode(ConstantKey.ACCESS_KEY);
        String returnJson = BzuApiUtil.sendGet(method, param);
        Map<String, Object> maps = JSON.parseObject(returnJson, Map.class);
        Map map = (Map) maps.get("data");
        Tickers tickers = new Tickers();
        if (map != null) {
            tickers = (Tickers) MapToObject.map2Object(map, Tickers.class);
        }
        dtoResponse.setTickers(tickers);
        if (maps.size() != Constant.NUM) {
            dtoResponse.setMessage(null);
            dtoResponse.setStatus(maps.get("status").toString());
        } else {
            dtoResponse.setMessage(maps.get("meta").toString());
        }
        return dtoResponse;
    }

    /**
     * 指定交易对深度数据 6
     *
     * @param symbol
     * @param step
     * @return
     */
    public DepthResponse queryDepth(String symbol, String step) {
        DepthResponse depthResponse = new DepthResponse();
        String method = "/market/depth";
        String param = "symbol=" + symbol + "&step=" + step + "&accessKey=" + URLEncoder.encode(ConstantKey.ACCESS_KEY);
        String returnJson = BzuApiUtil.sendGet(method, param);
        Map<String, Object> maps = JSON.parseObject(returnJson, Map.class);
        Map<String, Object> depths = (Map<String, Object>) maps.get("data");
        List<Map<String, Object>> buyMap = (List<Map<String, Object>>) depths.get("buy");
        List<Map<String, Object>> sellMap = (List<Map<String, Object>>) depths.get("sell");
        List<DepthPo> buyList = new ArrayList<>();
        List<DepthPo> sellList = new ArrayList<>();
        if (buyMap != null && !buyMap.isEmpty()) {
            for (Map<String, Object> map : buyMap) {
                buyList.add((DepthPo) MapToObject.map2Object(map, DepthPo.class));
            }
        }
        if (sellMap != null && !sellMap.isEmpty()) {
            for (Map<String, Object> map : sellMap) {
                sellList.add((DepthPo) MapToObject.map2Object(map, DepthPo.class));
            }
        }
        depthResponse.setBuy(buyList);
        depthResponse.setSell(sellList);
        if (maps.size() != Constant.NUM) {
            depthResponse.setStatus(maps.get("status").toString());
            depthResponse.setMessage(null);
        } else {
            depthResponse.setMessage(maps.get("meta").toString());
        }
        return depthResponse;
    }

    /**
     * 指定交易对的历史成交数据 7  **********************************************
     *
     * @param symbol
     * @return price成交价格, amount成交数量，direction成交方向(BUY,SELL)，time时间戳
     */
    public TradeResponse queryTradeBySymbol(String symbol) {
        TradeResponse tradeResponse = new TradeResponse();
        String method = "/market/trade";
        String param = "symbol=" + symbol + "&accessKey=" + URLEncoder.encode(ConstantKey.ACCESS_KEY);
        String returnJson = BzuApiUtil.sendGet(method, param);
        Map<String, Object> maps = JSON.parseObject(returnJson, Map.class);
        List<Map<String, Object>> listData = (List<Map<String, Object>>) maps.get("data");
        List<TradePo> list = new ArrayList<>();
        if (listData != null && !listData.isEmpty()) {
            for (Map<String, Object> map : listData) {
                list.add((TradePo) MapToObject.map2Object(map, TradePo.class));
            }
        }
        tradeResponse.setData(list);
        if (maps.size() != Constant.NUM) {
            tradeResponse.setStatus(maps.get("status").toString());
            tradeResponse.setMessage(null);
        } else {
            tradeResponse.setMessage(maps.get("meta").toString());
        }
        return tradeResponse;
    }

    /**
     * 指定交易对的K线数据 8
     *
     * @param klineRequest
     * @return 最高价, 开盘价, 最低价, 收盘价, 成交量, 时间戳
     */
    public KlineResponse queryKline(KlineRequest klineRequest) {
        KlineResponse klineResponse = new KlineResponse();
        String method = "/market/kline";
        String param = "symbol=" + klineRequest.getSymbol() + "&klineType=" + klineRequest.getKlineType() + "&klineStep=" + klineRequest.getKlineStep()
                + "&accessKey=" + URLEncoder.encode(ConstantKey.ACCESS_KEY);
        String returnJson = BzuApiUtil.sendGet(method, param);
        Map<String, Object> maps = JSON.parseObject(returnJson, Map.class);
        List<List<BigDecimal>> listData = (List<List<BigDecimal>>) maps.get("data");
        klineResponse.setData(listData);
        if (maps.size() != Constant.NUM) {
            klineResponse.setStatus(maps.get("status").toString());
            klineResponse.setMessage(null);
        } else {
            klineResponse.setMessage(maps.get("meta").toString());
        }
        return klineResponse;
    }

    /**
     * 用户资产查询  9
     *
     * @param selectType all：查询用户所有资产 noall：查询用户非0资产
     * @return coinName币种名称    total可用余额   frozen冻结余额   financing理财余额
     */
    public UserFinanceResponse queryUserFinanceList(String selectType) {
        UserFinanceResponse userFinanceResponse = new UserFinanceResponse();
        String method = "/personal/getUserFinanceList";
        String param = "selectType=" + selectType + "&accessKey=" + URLEncoder.encode(ConstantKey.ACCESS_KEY);
        String returnJson = BzuApiUtil.sendGet(method, param);
        Map<String, Object> maps = JSON.parseObject(returnJson, Map.class);
        List<Map<String, Object>> listData = (List<Map<String, Object>>) maps.get("data");
        List<UserFinance> list = new ArrayList<>();
        if (listData != null && !listData.isEmpty()) {
            for (Map<String, Object> map : listData) {
                list.add((UserFinance) MapToObject.map2Object(map, UserFinance.class));
            }
        }
        userFinanceResponse.setData(list);
        if (maps.size() != Constant.NUM) {
            userFinanceResponse.setStatus(
                    maps.get("status").toString());
            userFinanceResponse.setMessage(null);
        } else {
            userFinanceResponse.setMessage(maps.get("meta").toString());
        }
        return userFinanceResponse;
    }

    /**
     * 下单 10
     *
     * @param entrustRequest
     * @return data订单号
     */
    public SaveEntrustResponse saveEntrust(EntrustRequest entrustRequest) {
        SaveEntrustResponse saveEntrustResponse = new SaveEntrustResponse();
        JSONObject jsonObject = new JSONObject();
        String method = "/order/saveEntrust";
        jsonObject.put("count", entrustRequest.getCount());
        jsonObject.put("matchType", entrustRequest.getMatchType());
        jsonObject.put("payPwd", entrustRequest.getPayPwd());
        if (null != entrustRequest.getPrice() && !"".equals(entrustRequest.getPrice())) {
            jsonObject.put("price", entrustRequest.getPrice());
        }
        jsonObject.put("symbol", entrustRequest.getSymbol());
        jsonObject.put("type", entrustRequest.getType());
        jsonObject.put("timestamp", System.currentTimeMillis() + "");
        jsonObject.put("accessKey", ConstantKey.ACCESS_KEY);
        logger.info("原字符串: " + jsonObject.toString());
        String json = BzuApiUtil.getJsonPost(jsonObject, method, ConstantKey.SECRET_KEY);
        if (!"".equals(json) && null != json) {
            Map<String, Object> maps = JSON.parseObject(json, Map.class);
            saveEntrustResponse.setData(maps.get("data"));
            if (maps.size() != Constant.NUM) {
                saveEntrustResponse.setStatus(maps.get("status").toString());
                saveEntrustResponse.setMessage(null);
            } else {
                saveEntrustResponse.setMessage(maps.get("meta").toString());
            }
        }
        return saveEntrustResponse;
    }

    /**
     * 委单id撤销一个订单 11
     *
     * @param id
     * @return status:success or error_code
     */
    public String cancelEntrustById(String id) {
        JSONObject jsonObject = new JSONObject();
        String method = "/order/cancelEntrust";
        jsonObject.put("id", id);
        jsonObject.put("timestamp", System.currentTimeMillis() + "");
        jsonObject.put("accessKey", ConstantKey.ACCESS_KEY.trim());
        String json = BzuApiUtil.getJsonPost(jsonObject, method, ConstantKey.SECRET_KEY);
        return json;
    }

    /**
     * 按委单ID批量撤单 12
     *
     * @param ids 单次不超过50个委单id
     * @return status:success or error_code
     */
    public String batchCancelByIds(List<String> ids) {
        JSONObject jsonObject = new JSONObject();
        String method = "/order/batchCancel";
        jsonObject.put("ids", ids);
        jsonObject.put("timestamp", System.currentTimeMillis() + "");
        jsonObject.put("accessKey", ConstantKey.ACCESS_KEY.trim());
        String json = BzuApiUtil.getJsonPost(jsonObject, method, ConstantKey.SECRET_KEY);
        return json;
    }

    /**
     * 按条件批量撤单  按正序撤销100单  13
     *
     * @param batchCancelRequest
     * @return status:success or error_code
     */
    public String batchCancelOpenOrders(BatchCancelRequest batchCancelRequest) {
        JSONObject jsonObject = new JSONObject();
        String method = "/order/batchCancelOpenOrders";
        if (null != batchCancelRequest.getSymbol() && !"".equals(batchCancelRequest.getSymbol())) {
            jsonObject.put("symbol", batchCancelRequest.getSymbol());
        }
        if (null != batchCancelRequest.getType() && !"".equals(batchCancelRequest.getType())) {
            jsonObject.put("type", batchCancelRequest.getType());
        }
        jsonObject.put("timestamp", System.currentTimeMillis() + "");
        jsonObject.put("accessKey", ConstantKey.ACCESS_KEY.trim());
        String json = BzuApiUtil.getJsonPost(jsonObject, method, ConstantKey.SECRET_KEY);
        return json;
    }

    /**
     * 根据ID查询委单  14
     *
     * @param orderId
     * @return
     */
    public OrderResponse queryOrderById(Number orderId) {
        OrderResponse orderResponse = new OrderResponse();
        String method = "/order/queryOrderById";
        String param = "orderId=" + orderId + "&accessKey=" + URLEncoder.encode(ConstantKey.ACCESS_KEY);
        String returnJson = BzuApiUtil.sendGet(method, param);
        Map<String, Object> maps = JSON.parseObject(returnJson, Map.class);
        Map<String, Object> map = (Map) maps.get("data");
        if (maps.size() != Constant.NUM && map != null && !"".equals(map)) {
            Order obj = (Order) MapToObject.map2Object(map, Order.class);
            orderResponse.setData(obj);
            orderResponse.setStatus(maps.get("status").toString());
            orderResponse.setMessage(null);
        } else {
            orderResponse.setMessage(maps.get("meta").toString());
        }
        return orderResponse;
    }

    /**
     * 查询用户当前未成交订单 15
     *
     * @param type   BUY:买单 SELL：卖单
     * @param symbol 交易对symbol   规则：基础币种+计价币种。如BTC/USDT，symbol 为 btcusdt
     * @return
     */
    public OpenOrderResponse queryOpenOrders(String symbol, String type) {
        OpenOrderResponse orderResponse = new OpenOrderResponse();
        String method = "/order/openOrders";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("accessKey=" + URLEncoder.encode(ConstantKey.ACCESS_KEY.trim()));
        if (null != symbol && !"".equals(symbol)) {
            stringBuffer.append("&symbol=" + symbol);
        }
        if (null != type && !"".equals(type)) {
            stringBuffer.append("&type=" + type);
        }
        String returnJson = BzuApiUtil.sendGet(method, stringBuffer.toString());
        Map<String, Object> maps = JSON.parseObject(returnJson, Map.class);
        List<Map<String, Object>> mapList = (List<Map<String, Object>>) maps.get("data");
        List<Order> list = new ArrayList<>();
        if (mapList != null && !mapList.isEmpty()) {
            for (Map<String, Object> map : mapList) {
                list.add((Order) MapToObject.map2Object(map, Order.class));
            }
        }
        if (maps.size() != Constant.NUM) {
            orderResponse.setData(list);
            orderResponse.setMessage(null);
            orderResponse.setStatus(maps.get("status").toString());
        } else {
            orderResponse.setMessage(maps.get("meta").toString());
        }
        return orderResponse;
    }

    /**
     * 查询我的委单 16
     *
     * @param myEntrustRequest
     * @return
     */
    public MyEntrustResponse queryMyEntrust(MyEntrustRequest myEntrustRequest) {
        MyEntrustResponse myEntrustResponse = new MyEntrustResponse();
        StringBuffer stringBuffer = new StringBuffer();
        String method = "/order/queryMyEntrust";
        stringBuffer.append("accessKey=" + URLEncoder.encode(ConstantKey.ACCESS_KEY.trim()));
        if (myEntrustRequest.getType() != null && !"".equals(myEntrustRequest.getType())) {
            stringBuffer.append("&type=" + myEntrustRequest.getType());
        }
        if (myEntrustRequest.getSymbol() != null && !"".equals(myEntrustRequest.getSymbol())) {
            stringBuffer.append("&symbol=" + myEntrustRequest.getSymbol());
        }
        if (myEntrustRequest.getMatchType() != null && !"".equals(myEntrustRequest.getMatchType())) {
            stringBuffer.append("&type=" + myEntrustRequest.getType());
        }
        if (myEntrustRequest.getStartTime() != null && !"".equals(myEntrustRequest.getStartTime())) {
            stringBuffer.append("&startTime=" + myEntrustRequest.getStartTime());
        }
        if (myEntrustRequest.getEndTime() != null && !"".equals(myEntrustRequest.getEndTime())) {
            stringBuffer.append("&endTime=" + myEntrustRequest.getEndTime());
        }
        if (myEntrustRequest.getCurrentPage() != null && !"".equals(myEntrustRequest.getCurrentPage())) {
            stringBuffer.append("&currentPage=" + myEntrustRequest.getCurrentPage());
        }
        if (myEntrustRequest.getPageSize() != null && !"".equals(myEntrustRequest.getPageSize())) {
            stringBuffer.append("&pageSize=" + myEntrustRequest.getPageSize());
        }

        String returnJson = BzuApiUtil.sendGet(method, stringBuffer.toString());
        Map<String, Object> maps = JSON.parseObject(returnJson, Map.class);
        Map<String, Object> mapList = (Map<String, Object>) maps.get("data");
        List<Entrust> list = new ArrayList<>();
        if (maps.size() != Constant.NUM) {
            List<Map<String, Object>> dataList = (List<Map<String, Object>>) mapList.get("list");
            if (dataList != null && !dataList.isEmpty()) {
                for (Map<String, Object> map : dataList) {
                    list.add((Entrust) MapToObject.map2Object(map, Entrust.class));
                }
            }
            myEntrustResponse.setData(list);
            myEntrustResponse.setPageNum(Integer.valueOf(mapList.get("pageNum").toString()));
            myEntrustResponse.setPages(Integer.valueOf(mapList.get("pages").toString()));
            myEntrustResponse.setPageSize(Integer.valueOf(mapList.get("pageSize").toString()));
            myEntrustResponse.setTotal(Integer.valueOf(mapList.get("total").toString()));
            myEntrustResponse.setStatus(maps.get("status").toString());
            myEntrustResponse.setMessage(null);
        } else {
            myEntrustResponse.setMessage(maps.get("meta").toString());
        }
        return myEntrustResponse;
    }

    /**
     * 查询我的历史订单 17
     *
     * @param myHisEntrustRequest
     * @return
     */
    public MyEntrustResponse queryMyHisEntrust(MyHisEntrustRequest myHisEntrustRequest) {
        MyEntrustResponse myEntrustResponse = new MyEntrustResponse();
        StringBuffer stringBuffer = new StringBuffer();
        String method = "/order/queryMyHisEntrust";
        stringBuffer.append("accessKey=" + URLEncoder.encode(ConstantKey.ACCESS_KEY.trim()));
        if (myHisEntrustRequest.getType() != null && !"".equals(myHisEntrustRequest.getType())) {
            stringBuffer.append("&type=" + myHisEntrustRequest.getType());
        }
        if (myHisEntrustRequest.getSymbol() != null && !"".equals(myHisEntrustRequest.getSymbol())) {
            stringBuffer.append("&symbol=" + myHisEntrustRequest.getSymbol());
        }
        if (myHisEntrustRequest.getMatchType() != null && !"".equals(myHisEntrustRequest.getMatchType())) {
            stringBuffer.append("&type=" + myHisEntrustRequest.getType());
        }
        if (myHisEntrustRequest.getStartTime() != null && !"".equals(myHisEntrustRequest.getStartTime())) {
            stringBuffer.append("&startTime=" + myHisEntrustRequest.getStartTime());
        }
        if (myHisEntrustRequest.getEndTime() != null && !"".equals(myHisEntrustRequest.getEndTime())) {
            stringBuffer.append("&endTime=" + myHisEntrustRequest.getEndTime());
        }
        if (myHisEntrustRequest.getCurrentPage() != null && !"".equals(myHisEntrustRequest.getCurrentPage())) {
            stringBuffer.append("&currentPage=" + myHisEntrustRequest.getCurrentPage());
        }
        if (myHisEntrustRequest.getPageSize() != null && !"".equals(myHisEntrustRequest.getPageSize())) {
            stringBuffer.append("&pageSize=" + myHisEntrustRequest.getPageSize());
        }
        if (myHisEntrustRequest.getStatus() != null && !"".equals(myHisEntrustRequest.getStatus())) {
            stringBuffer.append("&status=" + myHisEntrustRequest.getStatus());
        }

        String returnJson = BzuApiUtil.sendGet(method, stringBuffer.toString());
        Map<String, Object> maps = JSON.parseObject(returnJson, Map.class);
        Map<String, Object> mapList = (Map<String, Object>) maps.get("data");
        List<Entrust> list = new ArrayList<>();
        if (maps.size() != Constant.NUM) {
            List<Map<String, Object>> dataList = (List<Map<String, Object>>) mapList.get("list");
            if (dataList != null && !dataList.isEmpty()) {
                for (Map<String, Object> map : dataList) {
                    list.add((Entrust) MapToObject.map2Object(map, Entrust.class));
                }
            }
            myEntrustResponse.setData(list);
            myEntrustResponse.setPageNum(Integer.valueOf(mapList.get("pageNum").toString()));
            myEntrustResponse.setPages(Integer.valueOf(mapList.get("pages").toString()));
            myEntrustResponse.setPageSize(Integer.valueOf(mapList.get("pageSize").toString()));
            myEntrustResponse.setTotal(Integer.valueOf(mapList.get("total").toString()));
            myEntrustResponse.setStatus(maps.get("status").toString());
            myEntrustResponse.setMessage(null);
        } else {
            myEntrustResponse.setMessage(maps.get("meta").toString());
        }
        return myEntrustResponse;
    }

    /**
     * 成交明细  18
     *
     * @param myEntrustRequest
     * @return
     */
    public MyEntrustOrderResponse queryMyEntrustOrder(MyEntrustRequest myEntrustRequest) {
        MyEntrustOrderResponse myEntrustOrderResponse = new MyEntrustOrderResponse();
        StringBuffer stringBuffer = new StringBuffer();
        String method = "/order/queryMyEntrustOrder";
        stringBuffer.append("accessKey=" + URLEncoder.encode(ConstantKey.ACCESS_KEY.trim()));
        if (myEntrustRequest.getType() != null && !"".equals(myEntrustRequest.getType())) {
            stringBuffer.append("&type=" + myEntrustRequest.getType());
        }
        if (myEntrustRequest.getSymbol() != null && !"".equals(myEntrustRequest.getSymbol())) {
            stringBuffer.append("&symbol=" + myEntrustRequest.getSymbol());
        }
        if (myEntrustRequest.getMatchType() != null && !"".equals(myEntrustRequest.getMatchType())) {
            stringBuffer.append("&type=" + myEntrustRequest.getType());
        }
        if (myEntrustRequest.getStartTime() != null && !"".equals(myEntrustRequest.getStartTime())) {
            stringBuffer.append("&startTime=" + myEntrustRequest.getStartTime());
        }
        if (myEntrustRequest.getEndTime() != null && !"".equals(myEntrustRequest.getEndTime())) {
            stringBuffer.append("&endTime=" + myEntrustRequest.getEndTime());
        }
        if (myEntrustRequest.getCurrentPage() != null && !"".equals(myEntrustRequest.getCurrentPage())) {
            stringBuffer.append("&currentPage=" + myEntrustRequest.getCurrentPage());
        }
        if (myEntrustRequest.getPageSize() != null && !"".equals(myEntrustRequest.getPageSize())) {
            stringBuffer.append("&pageSize=" + myEntrustRequest.getPageSize());
        }

        String returnJson = BzuApiUtil.sendGet(method, stringBuffer.toString());
        Map<String, Object> maps = JSON.parseObject(returnJson, Map.class);
        Map<String, Object> mapList = (Map<String, Object>) maps.get("data");
        List<Map<String, Object>> dataList = (List<Map<String, Object>>) mapList.get("list");
        List<EntrustOrder> list = new ArrayList<>();
        if (maps.size() != Constant.NUM) {
            if (dataList != null && !dataList.isEmpty()) {
                for (Map<String, Object> map : dataList) {
                    list.add((EntrustOrder) MapToObject.map2Object(map, EntrustOrder.class));
                }
            }
            myEntrustOrderResponse.setData(list);
            myEntrustOrderResponse.setPageNum(Integer.valueOf(mapList.get("pageNum").toString()));
            myEntrustOrderResponse.setPages(Integer.valueOf(mapList.get("pages").toString()));
            myEntrustOrderResponse.setPageSize(Integer.valueOf(mapList.get("pageSize").toString()));
            myEntrustOrderResponse.setTotal(Integer.valueOf(mapList.get("total").toString()));
            myEntrustOrderResponse.setStatus(maps.get("status").toString());
            myEntrustOrderResponse.setMessage(null);
        } else {
            myEntrustOrderResponse.setMessage(maps.get("meta").toString());
        }
        return myEntrustOrderResponse;
    }

    /**
     * 新增申请提币 19
     *
     * @param withdrawRequest
     * @return status:success or error_code
     */
    public String addWithdraw(WithdrawRequest withdrawRequest) {
        JSONObject jsonObject = new JSONObject();
        String method = "/dw/addWithdraw";
        jsonObject.put("coinName", withdrawRequest.getCoinName());
        jsonObject.put("withdrawAddress", withdrawRequest.getWithdrawAddress());
        jsonObject.put("amount", withdrawRequest.getAmount());
        jsonObject.put("networkFees", withdrawRequest.getNetworkFees());
        jsonObject.put("remark", withdrawRequest.getRemark());
        jsonObject.put("timestamp", System.currentTimeMillis() + "");
        jsonObject.put("accessKey", ConstantKey.ACCESS_KEY.trim());
        String json = BzuApiUtil.getJsonPost(jsonObject, method, ConstantKey.SECRET_KEY);
        return json;
    }

    /**
     * 撤销提币 20
     *
     * @param id 用户提币ID
     * @return status:success or error_code
     */
    public String cancelWithdraw(Number id) {
        JSONObject jsonObject = new JSONObject();
        String method = "/dw/cancelWithdraw";
        jsonObject.put("id", id);
        jsonObject.put("timestamp", System.currentTimeMillis() + "");
        jsonObject.put("accessKey", ConstantKey.ACCESS_KEY.trim());
        String json = BzuApiUtil.getJsonPost(jsonObject, method, ConstantKey.SECRET_KEY);
        return json;
    }

    /**
     * 用户充提记录 21
     *
     * @param request
     * @return
     */
    public WithdrawRecordingResponse queryWithdrawRecording(WithdrawRecordingRequest request) {
        WithdrawRecordingResponse response = new WithdrawRecordingResponse();
        StringBuffer stringBuffer = new StringBuffer();
        String method = "/dw/queryWithdrawRecording";
        stringBuffer.append("accessKey=" + URLEncoder.encode(ConstantKey.ACCESS_KEY.trim()));
        if (request.getType() != null && !"".equals(request.getType())) {
            stringBuffer.append("&type=" + request.getType());
        }
        if (request.getCoinName() != null && !"".equals(request.getCoinName())) {
            stringBuffer.append("&coinName=" + request.getCoinName());
        }
        if (request.getStartTime() != null && !"".equals(request.getStartTime())) {
            stringBuffer.append("&startTime=" + request.getStartTime());
        }
        if (request.getEndTime() != null && !"".equals(request.getEndTime())) {
            stringBuffer.append("&endTime=" + request.getEndTime());
        }
        if (request.getCurrentPage() != null && !"".equals(request.getCurrentPage())) {
            stringBuffer.append("&currentPage=" + request.getCurrentPage());
        }
        if (request.getPageSize() != null && !"".equals(request.getPageSize())) {
            stringBuffer.append("&pageSize=" + request.getPageSize());
        }
        String returnJson = BzuApiUtil.sendGet(method, stringBuffer.toString());
        Map<String, Object> maps = JSON.parseObject(returnJson, Map.class);
        Map<String, Object> mapList = (Map<String, Object>) maps.get("data");

        List<WithdrawRecording> list = new ArrayList<>();
        if (maps.size() != Constant.NUM) {
            List<Map<String, Object>> dataList = (List<Map<String, Object>>) mapList.get("list");
            if (dataList != null && !dataList.isEmpty()) {
                for (Map<String, Object> map : dataList) {
                    list.add((WithdrawRecording) MapToObject.map2Object(map, WithdrawRecording.class));
                }
            }
            response.setData(list);
            response.setPageNum(Integer.valueOf(mapList.get("pageNum").toString()));
            response.setPages(Integer.valueOf(mapList.get("pages").toString()));
            response.setPageSize(Integer.valueOf(mapList.get("pageSize").toString()));
            response.setTotal(Integer.valueOf(mapList.get("total").toString()));
            response.setStatus(maps.get("status").toString());
            response.setMessage(null);
        } else {
            response.setMessage(maps.get("meta").toString());
        }
        return response;
    }

    /**
     * 公告列表 22
     * @param request
     * @return
     */
    public BulletinResponse queryBulletin(BulletinRequest request) {
        BulletinResponse response = new BulletinResponse();
        String method = "/cms/bulletin";
        String param = "accessKey=" + URLEncoder.encode(ConstantKey.ACCESS_KEY) + "&language=" + request.getLanguage() +
                "&pageNum=" + request.getPageNum() + "&pageSize=" + request.getPageSize();
        String returnJson = BzuApiUtil.sendGet(method, param);
        Map<String, Object> maps = JSON.parseObject(returnJson, Map.class);
        Map<String, Object> mapList = (Map<String, Object>) maps.get("data");
        Map<String, Object> meta = (Map) maps.get("meta");
        response.setMessage(meta.toString());
        response.setPageNum((Integer) mapList.get("pageNum"));
        response.setPageSize((Integer) mapList.get("pageSize"));
        response.setPages((Integer) mapList.get("pages"));
        response.setTotal((Integer) mapList.get("total"));
        List<Map<String, Object>> listData = (List) mapList.get("list");
        List<BulletinPo> bulletinPoData = new ArrayList<>();
        if (listData != null && listData.size() > 0) {
            for (Map<String, Object> map : listData) {
                bulletinPoData.add((BulletinPo) MapToObject.map2Object(map, BulletinPo.class));
            }
        }
        response.setData(bulletinPoData);
        return response;
    }

}

