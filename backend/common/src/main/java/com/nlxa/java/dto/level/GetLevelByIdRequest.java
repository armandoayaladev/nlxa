package com.nlxa.java.dto.level;

import lombok.Data;

import java.io.Serializable;

@Data
public class GetLevelByIdRequest implements Serializable {

    private String levelId;

    public GetLevelByIdRequest() {
    }

}
