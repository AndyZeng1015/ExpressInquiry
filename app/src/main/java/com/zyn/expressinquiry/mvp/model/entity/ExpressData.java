package com.zyn.expressinquiry.mvp.model.entity;

import java.util.List;

/**
 * Desc: 快递信息的实体类
 * CreateDate: 2017/7/3 11:22
 * Author: Created by ZengYinan
 * Email: 498338021@qq.com
 */

public class ExpressData {

    /**
     * mailNo : 443775912155
     * update : 1499052625166
     * updateStr : 2017-07-03 11:30:25
     * ret_code : 0
     * flag : true
     * dataSize : 0
     * status : 4
     * tel : 021-39777777
     * expSpellName : zhongtong
     * data : [{"time":"2017-06-29 13:08:23","context":"[成都中和锦江工业园] [成都市] [成都中和锦江工业园]的派件已签收 感谢使用中通快递,期待再次为您服务!"},{"time":"2017-06-29 08:05:45","context":"[成都中和锦江工业园] [成都市] [成都中和锦江工业园]的蔡杰正在第1次派件 电话:15881048287 请保持电话畅通、耐心等待"},{"time":"2017-06-29 06:56:25","context":"[成都中和锦江工业园] [成都市] 快件到达 [成都中和锦江工业园]"},{"time":"2017-06-29 02:16:59","context":"[成都中转] [成都市] 快件离开 [成都中转]已发往[成都中和锦江工业园]"},{"time":"2017-06-29 01:31:34","context":"[成都中转] [成都市] 快件到达 [成都中转]"},{"time":"2017-06-28 21:09:30","context":"[南充中转站] [南充市] 快件到达 [南充中转站]"},{"time":"2017-06-27 23:49:02","context":"[合肥中转部] [合肥市] 快件离开 [合肥中转部]已发往[成都中转]"},{"time":"2017-06-27 23:25:18","context":"[合肥中转部] [合肥市] 快件到达 [合肥中转部]"},{"time":"2017-06-27 20:27:57","context":"[芜湖中转部] [芜湖市] 快件离开 [芜湖中转部]已发往[合肥中转部]"},{"time":"2017-06-27 20:26:49","context":"[芜湖中转部] [芜湖市] 快件到达 [芜湖中转部]"},{"time":"2017-06-27 18:04:58","context":"[马鞍山] [马鞍山市] 快件离开 [马鞍山]已发往[成都]"},{"time":"2017-06-27 17:45:16","context":"[马鞍山] [马鞍山市] [马鞍山]的马林已收件 电话:13385670622"}]
     * expTextName : 中通快递
     */

    private String mailNo;
    private long update;
    private String updateStr;
    private int ret_code;
    private boolean flag;
    private int dataSize;
    private int status;
    private String tel;
    private String expSpellName;
    private String expTextName;
    private List<DataBean> data;

    public String getMailNo() {
        return mailNo;
    }

    public void setMailNo(String mailNo) {
        this.mailNo = mailNo;
    }

    public long getUpdate() {
        return update;
    }

    public void setUpdate(long update) {
        this.update = update;
    }

    public String getUpdateStr() {
        return updateStr;
    }

    public void setUpdateStr(String updateStr) {
        this.updateStr = updateStr;
    }

    public int getRet_code() {
        return ret_code;
    }

    public void setRet_code(int ret_code) {
        this.ret_code = ret_code;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getDataSize() {
        return dataSize;
    }

    public void setDataSize(int dataSize) {
        this.dataSize = dataSize;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getExpSpellName() {
        return expSpellName;
    }

    public void setExpSpellName(String expSpellName) {
        this.expSpellName = expSpellName;
    }

    public String getExpTextName() {
        return expTextName;
    }

    public void setExpTextName(String expTextName) {
        this.expTextName = expTextName;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * time : 2017-06-29 13:08:23
         * context : [成都中和锦江工业园] [成都市] [成都中和锦江工业园]的派件已签收 感谢使用中通快递,期待再次为您服务!
         */

        private String time;
        private String context;

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getContext() {
            return context;
        }

        public void setContext(String context) {
            this.context = context;
        }
    }
}
