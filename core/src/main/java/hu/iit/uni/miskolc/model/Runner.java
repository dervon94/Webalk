package hu.iit.uni.miskolc.model;

import hu.iit.uni.miskolc.model.exceptions.InvalidCountryException;
import hu.iit.uni.miskolc.model.exceptions.InvalidDistanceException;
import hu.iit.uni.miskolc.model.exceptions.InvalidGenderException;

import javax.xml.datatype.XMLGregorianCalendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Runner {


    public Runner(String idNumber, String name, RunnerCountry country, Date birthDate, String birthCity, RunnerGender gender, RunnerDistance distance) {
        this.idNumber = idNumber;
        this.name = name;
        this.country = country;
        this.birthDate = birthDate;
        this.birthCity = birthCity;
        this.gender = gender;
        this.distance = distance;
        this.regdate = new Date();
    }

    public Runner(String idNumber, String name, String country, XMLGregorianCalendar birthDate, String birthCity, String gender, String distance) throws InvalidCountryException,InvalidDistanceException,InvalidGenderException {
        this.idNumber = idNumber;
        this.name = name;
        try {
            this.country = RunnerCountry.valueOf(country);
        } catch (IllegalArgumentException e) {
            throw new InvalidCountryException();
        }


        this.birthDate = birthDate.toGregorianCalendar().getTime();

        this.birthCity = birthCity;
        try {
            this.gender = RunnerGender.valueOf(gender);
        } catch (IllegalArgumentException e) {
            throw new InvalidGenderException();
        }
        try {
            this.distance = RunnerDistance.valueOf(distance);
        } catch (IllegalArgumentException e) {
            throw new InvalidDistanceException();
        }
        this.regdate = new Date();
    }

    private String idNumber;
    private String name;
    private RunnerCountry country;
    private Date birthDate;
    private String birthCity;
    private RunnerGender gender;
    private RunnerDistance distance;
    private Date regdate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public RunnerCountry getCountry() {
        return country;
    }

    public void setCountry(RunnerCountry country) {
        this.country = country;
    }

    public Date getBirthDate() {
        return birthDate;
    }

   /* public String getBirthDate() {

        DateFormat df = new SimpleDateFormat("yyyy-MM-DD");
        return df.format(birthDate);
    }*/

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthCity() {
        return birthCity;
    }

    public void setBirthCity(String birthCity) {
        this.birthCity = birthCity;
    }

    public RunnerGender getGender() {
        return gender;
    }

    public void setGender(RunnerGender gender) {
        this.gender = gender;
    }

    public RunnerDistance getDistance() {
        return distance;
    }

    public void setDistance(RunnerDistance distance) {
        this.distance = distance;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }
}
