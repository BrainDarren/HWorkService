package com.zdpractice.hworkservice.support.networktool;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by 15813 on 2016/8/15.
 */
public class NetWorkTools {

    private RequestParams requestParams;
    private String strJson;

    /**
     * 登录请求
     * @param method 方法名
     * @param name 用户名
     * @param pwd 密码
     */
    public void requestLog(String method,String name,String pwd) {
        //TODO 登录URL
        requestParams=new RequestParams("url");
        method="app/login/ artistLogin";
        //添加参数
        requestParams.addBodyParameter("loginname",name);
        requestParams.addBodyParameter("password",pwd);
        getJson(requestParams);
    }

    /**
     * 获取竞单列表请求
     * @param method 方法名
     * @param token token
     * @param userid 用户id
     */
    public void requestCompeteOrder(String method,String token,String userid){
        //TODO 获取竞单URL
        requestParams=new RequestParams("url");
        method="order/getFightingOrderList";
        //添加参数
        requestParams.addBodyParameter("token",token);
        requestParams.addBodyParameter("userid",userid);
        getJson(requestParams);
    }

    /**
     * 获取一小时内已抢单请求
     * @param method 方法名
     * @param token token
     * @param userid 用户id
     */
    public void requestWorkingOrder(String method,String token,String userid){
        //TODO 获取已抢单URL
        requestParams=new RequestParams("url");
        method="order/getFoughtOrderList";
        //添加参数
        requestParams.addBodyParameter("token",token);
        requestParams.addBodyParameter("userid",userid);
        getJson(requestParams);
    }

    /**
     * 发送历史订单、竞单中、已完成竞单列表请求
     * @param method 方法名
     * @param token token
     * @param userid 用户id
     * @param pageNo 页数
     * @param pageSize 每页的数量
     * @param servicestate 服务状态(不是必须) 1-竟单中；2-已生效等待服务；3-取消；4-超时；5-阿姨确认等待支付；6-已完成支付
     * @param status 订单状态(不是必须)
     * @param yMonth 月份(不是必须)
     * @param providerJudgeLevel 评价(不是必须)
     */
    public void requestEverOrder(String method,String token,String userid,String pageNo,
                                 String pageSize,String servicestate,
                                 String status,String yMonth,String providerJudgeLevel){
        //TODO 获取历史订单URL
        requestParams=new RequestParams("url");
        method="order/getFoughtOrderList";
        //添加参数
        requestParams.addBodyParameter("token",token);
        requestParams.addBodyParameter("userid",userid);
        requestParams.addBodyParameter("pageNo",pageNo);
        requestParams.addBodyParameter("pageSize",pageSize);
        requestParams.addBodyParameter("servicestate",servicestate);
        requestParams.addBodyParameter("status",status);
        requestParams.addBodyParameter("yMonth",yMonth);
        requestParams.addBodyParameter("providerJudgeLevel",providerJudgeLevel);
        getJson(requestParams);
    }

    /**
     *发送抢单请求
     * @param method
     * @param token
     * @param orderId 订单id
     * @param price 价格
     * @param providerId 服务提供者id
     */
    public void requestConfirmOrder(String method,String token,
                                    String orderId,String price,String providerId){
        //TODO 获取抢单URL
        requestParams=new RequestParams("url");
        method="order/grabOrder";
        //添加参数
        requestParams.addBodyParameter("token",token);
        requestParams.addBodyParameter("orderId",orderId);
        requestParams.addBodyParameter("price",price);
        requestParams.addBodyParameter("providerId",providerId);
        getJson(requestParams);
    }

    protected void getJson(RequestParams requestParams){

        x.http().post(requestParams, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {
                //收到json,并解析
                //TODO 调用解析方法
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }


}
