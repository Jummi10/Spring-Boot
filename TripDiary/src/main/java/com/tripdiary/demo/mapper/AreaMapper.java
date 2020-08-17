package com.tripdiary.demo.mapper;

import com.tripdiary.demo.model.CONTINENTS;
import com.tripdiary.demo.model.COUNTRIES;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaMapper {

    @Select("SELECT * FROM CONTINENTS")
    List<CONTINENTS> getAll();

    @Select("SELECT * FROM CONTINENTS WHERE id = #{id}")
    CONTINENTS getContinent(@Param("id") int id);

    @Select("SELECT * FROM COUNTRIES")
    List<COUNTRIES> getAllCountries();

    @Select("SELECT * FROM COUNTRIES WHERE continentId = #{continentId}")
    List<COUNTRIES> getCountries(@Param("continentId") int continentId);

    @Select("SELECT * FROM COUNTRIES WHERE continentName = #{continentName}")
    List<COUNTRIES> getCountriesConId(@Param("continentName") String continentName);

    @Insert("INSERT INTO COUNTRIES(countryName, continentId, createdAt, updatedAt) VALUES(#{countryName}, #{continentId}, now(), now())")
    void insertCountry(@Param("countryName") String countryName, @Param("continentId") int continentId);

    @Insert("INSERT INTO CITIES(cityName, countryId, createdAt, updatedAt) VALUES(#{cityName}, #{countryId}, now(), now()")
    void insertCity(@Param("cityName") String cityName, @Param("countryId") int countryId);

    //@Delete()

    //@Update()
}
