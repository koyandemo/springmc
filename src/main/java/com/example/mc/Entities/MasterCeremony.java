package com.example.mc.Entities;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "MC")
@AllArgsConstructor

@Getter
@Setter
public class MasterCeremony {

    @Id
    private String id;
    @Indexed(direction = IndexDirection.ASCENDING)
    private String name;
    private String image;
    private String phone;
    @Field("price")
    private Price price;
    private String city;
    private String description;
    private String email;



    public MasterCeremony() {

    }
}
