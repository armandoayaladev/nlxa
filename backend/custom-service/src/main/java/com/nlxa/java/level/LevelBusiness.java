package com.nlxa.java.level;

import com.nlxa.java.domain.Level;
import com.nlxa.java.dto.level.GetLevelByIdRequest;
import com.nlxa.java.dto.level.LevelListResponse;
import com.nlxa.java.dto.level.LevelResponse;
import com.nlxa.java.jpa.LevelJPAComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class LevelBusiness {

    private LevelJPAComponent levelJPAComponent;

    @Autowired
    public LevelBusiness(LevelJPAComponent levelJPAComponent){
        this.levelJPAComponent = levelJPAComponent;
    }


    public LevelListResponse getAllLevels() {
        log.info("Call to: LevelBusiness.getAllLevels()");
        LevelListResponse response = null;
        try {
            response = new LevelListResponse();
            List<Level> levels = this.levelJPAComponent.getAll();

            for (Level levelAux : levels){
                response.getLevelResponseList().add(new LevelResponse(levelAux));
            }
        } catch (Exception e) {
            log.error("Error in: LevelBusiness.getAllLevels() -> Verify that the conection is correct");
        }

        return response;
    }

    public LevelResponse getById(GetLevelByIdRequest request) {
        log.info("Call to: LevelBusiness.getAllLevels()");
        LevelResponse response = null;
        try {
            Level level = this.levelJPAComponent.getById(request.getLevelId());
            response = new LevelResponse(level);
        } catch (Exception e) {
            log.error("Error in: LevelBusiness.getAllLevels() -> Verify that the conection is correct");
        }

        return response;
    }
}
