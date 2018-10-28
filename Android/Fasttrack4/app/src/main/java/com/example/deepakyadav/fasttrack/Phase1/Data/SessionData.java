package com.example.deepakyadav.fasttrack.Phase1.Data;

public class SessionData {
    private static SessionData sessionData;
    String fastrackId;
    String password;
    String accessToken;

    public SessionData(){

    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public static SessionData getSessionData() {
        if (sessionData==null){
            sessionData=new SessionData();
        }
        return sessionData;
    }

    public String getFastrackId() {
        return fastrackId;
    }

    public void setFastrackId(String fastrackId) {
        this.fastrackId = fastrackId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
