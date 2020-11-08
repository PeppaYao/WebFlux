package com.bytedance.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@Data
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 3L;

    private int id;
    private String name;
    private int pwd;

    public User(int id, String name, int pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }
}
