package com.clerk.clerkb.model.zeleniSertifikat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="", propOrder = {
        "doza"
})
public class TVakcinacija {

    @XmlElement(required = true)
    protected List<TDoza> doza;

    public List<TDoza> getDoza() {
        return doza;
    }

    public void setDoza(List<TDoza> doza) {
        this.doza = doza;
    }
}
