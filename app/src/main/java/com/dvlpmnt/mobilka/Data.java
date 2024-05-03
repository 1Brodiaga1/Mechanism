package com.dvlpmnt.mobilka;

public class Data {

    private int id;
    private String name;
    private String description;
    private String type;
    private String code;
    public Data(){}
    public Data(int id ,String name, String description, String type, String code){
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getCode(){
        return code;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
