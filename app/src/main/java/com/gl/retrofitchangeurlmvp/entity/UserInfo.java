package com.gl.retrofitchangeurlmvp.entity;

import androidx.annotation.NonNull;

import java.io.Serializable;

/**
 * @Author: gl
 * @CreateDate: 2019/11/15
 * @Description:
 */
public class UserInfo implements Serializable {
    private String userId;//用户ID
    private int userType;//用户类型：爷爷:0，奶奶:1，叔叔:2，阿姨:3等
    private int userBirthYear;//出生年份: 1999
    private int userGender;//性别 男：0，女：1
    private String userName;//昵称或真实姓名
    private String userStature;//身高: 173cm
    private String userWeight;//体重：50kg
    private String userRebotId;//用户使用的机器人ID号或设备号

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public int getUserBirthYear() {
        return userBirthYear;
    }

    public void setUserBirthYear(int userBirthYear) {
        this.userBirthYear = userBirthYear;
    }

    public int getUserGender() {
        return userGender;
    }

    public void setUserGender(int userGender) {
        this.userGender = userGender;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserStature() {
        return userStature;
    }

    public void setUserStature(String userStature) {
        this.userStature = userStature;
    }

    public String getUserWeight() {
        return userWeight;
    }

    public void setUserWeight(String userWeight) {
        this.userWeight = userWeight;
    }

    public String getUserRebotId() {
        return userRebotId;
    }

    public void setUserRebotId(String userRebotId) {
        this.userRebotId = userRebotId;
    }




    @NonNull
    @Override
    public String toString() {
        return "userType:"+getUserType()+" ,userYear:"+getUserBirthYear();
    }
}
