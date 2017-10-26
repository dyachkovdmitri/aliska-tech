package com.neiron.neiron.entities;

import javax.persistence.*;

@Entity
public class Item {
    @Id
    @GeneratedValue
    public Long id;

    @Column(name = "unparsedLine")
    String unparsedLine;

    @Column(name = "type1")
    Integer type1;

    @Column(name = "type2")
    Integer type2;

    @Column(name = "type3")
    Integer type3;

    @Column(name = "type4")
    Integer type4;

    @Column(name = "type5")
    Integer type5;

    @Column(name = "wattage")
    Integer wattage;

    @Column(name = "voltage")
    Integer voltage;

    @Column(name = "brand")
    Integer brand;

    @Column(name = "companyId")
    Long companyId;

    @Column(name = "seller")
    Integer seller;

    @Column(name = "connectorType")
    Integer connectorType;

    @Column(name = "bulbColor")
    Integer bulbColor;

    @Column(name = "bulbType")
    Integer bulbType;

    @Transient
    String[] words;

    public String[] getWords() {
        return words;
    }

    public void setWords(String[] words) {
        this.words = words;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUnparsedLine() {
        return unparsedLine;
    }

    public void setUnparsedLine(String unparsedLine) {
        this.unparsedLine = unparsedLine;
    }

    public Integer getType1() {
        return type1;
    }

    public void setType1(Integer type1) {
        this.type1 = type1;
    }

    public Integer getType2() {
        return type2;
    }


    public void setType2(Integer type2) {
        this.type2 = type2;
    }

    public Integer getType3() {
        return type3;
    }

    public void setType3(Integer type3) {
        this.type3 = type3;
    }

    public Integer getType4() {
        return type4;
    }

    public void setType4(Integer type4) {
        this.type4 = type4;
    }

    public Integer getType5() {
        return type5;
    }

    public void setType5(Integer type5) {
        this.type5 = type5;
    }

    public Integer getWattage() {
        return wattage;
    }

    public void setWattage(Integer wattage) {
        this.wattage = wattage;
    }

    public Integer getVoltage() {
        return voltage;
    }

    public void setVoltage(Integer voltage) {
        this.voltage = voltage;
    }

    public Integer getBrand() {
        return brand;
    }

    public void setBrand(Integer brand) {
        this.brand = brand;
    }

    public Integer getSeller() {
        return seller;
    }

    public void setSeller(Integer seller) {
        this.seller = seller;
    }

    public Integer getConnectorType() {
        return connectorType;
    }

    public void setConnectorType(Integer connectorType) {
        this.connectorType = connectorType;
    }

    public Integer getBulbColor() {
        return bulbColor;
    }

    public void setBulbColor(Integer bulbColor) {
        this.bulbColor = bulbColor;
    }

    public Integer getBulbType() {
        return bulbType;
    }

    public void setBulbType(Integer bulbType) {
        this.bulbType = bulbType;
    }

    @Override
    public String toString() {
        String result = "{";
        if (unparsedLine != null) {
            result += "'unparsedLine':" + "'" + unparsedLine + "',";
        }
        if (type1 != null) {
            result += "'type1':" + "'" + type1 + "',";
        }
        if (type2 != null) {
            result += "'type2':" + "'" + type2 + "',";
        }
        if (type3 != null) {
            result += "'type3':" + "'" + type3 + "',";
        }
        if (type4 != null) {
            result += "'type4':" + "'" + type4 + "',";
        }
        if (type5 != null) {
            result += "'type5':" + "'" + type5 + "',";
        }
        if (wattage != null) {
            result += "'wattage':" + "'" + wattage + "',";
        }
        if (voltage != null) {
            result += "'voltage':" + "'" + voltage + "',";
        }
        if (brand != null) {
            result += "'brand':" + "'" + brand + "',";
        }
        if (seller != null) {
            result += "'seller':" + "'" + seller + "',";
        }
        if (connectorType != null) {
            result += "'connectorType':" + "'" + connectorType + "',";
        }
        if (bulbColor != null) {
            result += "'bulbColor':" + "'" + bulbColor + "',";
        }
        if (bulbType != null) {
            result += "'bulbType':" + "'" + bulbType + "',";
        }
        result = result.substring(0, result.length() - 1);
        return result += "}";
    }
}