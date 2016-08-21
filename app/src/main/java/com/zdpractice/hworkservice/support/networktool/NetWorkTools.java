package com.zdpractice.hworkservice.support.networktool;

import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.zdpractice.hworkservice.MyApplication;
import com.zdpractice.hworkservice.model.UserParentBean;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by 15813 on 2016/8/15.
 */
public class NetWorkTools {
    private static String url="http://192.168.0.158:8080/exj/removte";
    private RequestParams requestParams;
    private static NetWorkTools netWorkTools;
    public  UserParentBean userParentBean;

    public static NetWorkTools newInstance(){
        if (netWorkTools==null){
            netWorkTools=new NetWorkTools();
        }
        return netWorkTools;
    }


    /**
     * 登录请求
     * @param name 用户名
     * @param pwd 密码
     */
    public UserParentBean requestLog(String name, String pwd) {
        //TODO 登录URL
        userParentBean=new UserParentBean();
        requestParams=new RequestParams(url);
        //添加参数
        requestParams.addBodyParameter("method","app/login/artistLogin");
        requestParams.addBodyParameter("loginname",name);
        requestParams.addBodyParameter("password",pwd);
        getJson(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                //TODO 根据返回实例，封装实体类
                 userParentBean= JSON.parseObject(result,UserParentBean.class);
                MyApplication.userBean=userParentBean.getData();
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
        requestParams=null;
        return userParentBean;
    }

    /**
     * 获取竞单列表请求
     * @param token token
     * @param userid 用户id
     */
    public void requestCompeteOrder(String token,String userid){
        //TODO 获取竞单URL
        requestParams=new RequestParams(url);
        //添加参数
        requestParams.addBodyParameter("method","order/getFightingOrderList");
        requestParams.addBodyParameter("token",token);
        requestParams.addBodyParameter("userid",userid);
        getJson(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                //TODO 根据返回实例，封装实体类
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
        requestParams=null;
    }

    /**
     * 获取一小时内已抢单请求
     * @param token token
     * @param userid 用户id
     */
    public void requestWorkingOrder(String token,String userid){
        //TODO 获取已抢单URL
        requestParams=new RequestParams(url);
        //添加参数
        requestParams.addBodyParameter("method","order/getFoughtOrderList");
        requestParams.addBodyParameter("token",token);
        requestParams.addBodyParameter("userid",userid);
        getJson(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                //TODO 根据返回实例，封装实体类
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
        requestParams=null;
    }

    /**
     * 发送历史订单、竞单中、已完成竞单列表请求
     * @param token token
     * @param userid 用户id
     * @param pageNo 页数
     * @param pageSize 每页的数量
     * @param servicestate 服务状态(不是必须) 1-竟单中；2-已生效等待服务；3-取消；4-超时；5-阿姨确认等待支付；6-已完成支付
     * @param status 订单状态(不是必须)
     * @param yMonth 月份(不是必须)
     * @param providerJudgeLevel 评价(不是必须)
     */
    public void requestEverOrder(String token,String userid,String pageNo,
                                 String pageSize,String servicestate,
                                 String status,String yMonth,String providerJudgeLevel){
        //TODO 获取历史订单URL
        requestParams=new RequestParams(url);
        //添加参数
        requestParams.addBodyParameter("method","order/getMyOrderList");
        requestParams.addBodyParameter("token",token);
        requestParams.addBodyParameter("userid",userid);
        requestParams.addBodyParameter("pageNo",pageNo);
        requestParams.addBodyParameter("pageSize",pageSize);
        requestParams.addBodyParameter("servicestate",servicestate);
        requestParams.addBodyParameter("status",status);
        requestParams.addBodyParameter("yMonth",yMonth);
        requestParams.addBodyParameter("providerJudgeLevel",providerJudgeLevel);
        getJson(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                //TODO 根据返回实例，封装实体类
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
        requestParams=null;
    }

    /**
     *发送抢单请求
     * @param token
     * @param orderId 订单id
     * @param price 价格
     * @param providerId 服务提供者id
     */
    public void requestConfirmOrder(String token,String orderId,String price,
                                    String providerId){
        //TODO 抢单URL
        requestParams=new RequestParams(url);
        requestParams.addBodyParameter("method","order/grabOrder");
        //添加参数
        requestParams.addBodyParameter("token",token);
        requestParams.addBodyParameter("orderId",orderId);
        requestParams.addBodyParameter("price",price);
        requestParams.addBodyParameter("providerId",providerId);
        getJson(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                //TODO 根据返回实例，封装实体类
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
        requestParams=null;
    }

    /**
     * 发送月收入请求
     * @param token token
     * @param orderno 订单号
     * @param yMonth 月份
     * @param userid 用户id
     */
    public void requestMonthIncome(String token,
                                   String orderno,String yMonth,String userid){
        requestParams=new RequestParams(url);

        //添加参数
        requestParams.addBodyParameter("method","provider/getMyIncomeThisMonth");
        requestParams.addBodyParameter("token",token);
        requestParams.addBodyParameter("orderId",orderno);
        requestParams.addBodyParameter("price",yMonth);
        requestParams.addBodyParameter("providerId",userid);
        getJson(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                //TODO 根据返回实例，封装实体类
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
        requestParams=null;
    }

    protected void getJson(RequestParams requestParams,Callback.CommonCallback<String> callback){
        x.http().post(requestParams,callback);
    }


}
