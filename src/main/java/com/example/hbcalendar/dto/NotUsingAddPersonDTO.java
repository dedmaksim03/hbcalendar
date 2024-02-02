package com.example.hbcalendar.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
//@JsonDeserialize(builder = AddPersonDTO.Builder.class)
public class NotUsingAddPersonDTO {

    @NotNull(message = "Key 'name' is mandatory")
    private final String name;
    private final int yearOfBirth;

    public static Builder builder() {return new Builder();}

    private NotUsingAddPersonDTO(Builder builder){
        this.yearOfBirth = builder.yearOfBirth;
        this.name = builder.name;
    }

    @Override
    public String toString(){

        return "{" +
                "name='" + name + '\'' +
                ", yearOfBirth='" + yearOfBirth + '\'' +
                '}';
    }

    //@JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{

        private String name;
        private int yearOfBirth;

        public Builder setName(String name){
            this.name = name;
            return this;
        }

        public Builder setYearOfBirth(int yearOfBirth){
            this.yearOfBirth = yearOfBirth;
            return this;
        }

        public NotUsingAddPersonDTO build() {return new NotUsingAddPersonDTO(this);}
    }
}

