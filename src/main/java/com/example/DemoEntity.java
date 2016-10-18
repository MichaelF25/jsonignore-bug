package com.example;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@JsonIgnoreProperties("id") // that works, but I hate specifying property names (error prone)
public class DemoEntity {

    @Id
    @GeneratedValue
    @JsonIgnore // does not work, @JsonIgnore is ignored ;-)
    private int id;

    private String name;

    private String ignored;

    @JsonIgnore // works as expected
    public String getIgnored() {
        return ignored;
    }
}
