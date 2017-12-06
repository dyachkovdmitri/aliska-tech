package com.neiron.neiron.repos;

import com.neiron.neiron.entities.Item;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.ArrayList;

public interface ItemRepo extends CrudRepository<Item, Long> {


    ArrayList<Item> findByPriceId(Long priceId);

@Query("select i from Item i WHERE " +
        "(:type1 is null OR i.type1 = :type1) and" +
        "(:type2 is null OR i.type2 = :type2) and" +
        "(:type3 is null OR i.type3 = :type3) and" +
        "(:type4 is null OR i.type4 = :type4) and" +
        "(:type5 is null OR i.type5 = :type5) and" +
        "(:wattage is null OR i.wattage = :wattage) and" +
        "(:voltage is null OR i.voltage = :voltage) and" +
        "(:connectorType is null OR i.connectorType = :connectorType) and" +
        "(:bulbColor is null OR i.bulbColor = :bulbColor) and" +
        "(:bulbType is null OR i.bulbType = :bulbType) and" +
        "(:brand is null OR i.brand = :brand) and "+
        "(:kelvin is null OR i.kelvin = :kelvin)")
    ArrayList<Item> getItemByAttributes(@Param("type1")Integer type1,
                                        @Param("type2")Integer type2,
                                        @Param("type3")Integer type3,
                                        @Param("type4")Integer type4,
                                        @Param("type5")Integer type5,
                                        @Param("wattage") Integer wattage,
                                        @Param("voltage")Integer voltage,
                                        @Param("connectorType")Integer connectorType,
                                        @Param("bulbColor")Integer bulbColor,
                                        @Param("bulbType") Integer bulbType,
                                        @Param("brand") Integer brand,
                                        @Param("kelvin") Integer kelvin);
   // select * from item i where (CASE WHEN 1 is null THEN true ELSE i.connector_type = 1 END)

}