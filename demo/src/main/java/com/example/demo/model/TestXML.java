package com.example.demo.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "test")
public class TestXML {

    public String a;
    public String b;
    public String getA() {
        return a;
    }
    public void setA(String a) {
        this.a = a;
    }
    public String getB() {
        return b;
    }
    public void setB(String b) {
        this.b = b;
    }
    public TestXML(String a, String b) {
        this.a = a;
        this.b = b;
    }
    public TestXML() {
    }
    
}
