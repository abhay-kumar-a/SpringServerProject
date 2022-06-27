package com.axyya.newapplication.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "server")
public class Server {
    @Id
    Long serverId;
    String serverName;
    String serverLanguage;
    String serverFramework;
    @Override
    public String toString() {
        return "Server{" +
                "serverId=" + serverId +
                ", serverName='" + serverName + '\'' +
                ", serverLanguage='" + serverLanguage + '\'' +
                ", serverFramework='" + serverFramework + '\'' +
                '}';
    }

    public Long getServerId() {
        return serverId;
    }

    public void setServerId(Long serverId) {
        this.serverId = serverId;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getServerLanguage() {
        return serverLanguage;
    }

    public void setServerLanguage(String serverLanguage) {
        this.serverLanguage = serverLanguage;
    }

    public String getServerFramework() {
        return serverFramework;
    }

    public void setServerFramework(String serverFramework) {
        this.serverFramework = serverFramework;
    }
}
