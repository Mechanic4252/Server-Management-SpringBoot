package com.restexample.sample.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ServersCollection")
public class Server {
    private String name;
    @Id
    private String ID;
    private String language;
    private String framework;


    public Server() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFramework() {
        return framework;
    }

    public void setFramework(String framework) {
        this.framework = framework;
    }


    @Override
    public String toString() {
        return "Server{" +
                "name='" + name + '\'' +
                ", ID=" + ID +
                ", language='" + language + '\'' +
                ", framework='" + framework + '\'' +
                '}';
    }
}
