package com.nlxa.java.dto.level;

import com.nlxa.java.domain.Level;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class LevelResponse {

    private String id;
    private String description;

    public LevelResponse() {
    }

    public LevelResponse(Level level) {
        toLevelResponse(level);
    }

    public void toLevelResponse(Level level) {
        setId(level.getLevelId());
        setDescription(level.getDescription());
    }

}
