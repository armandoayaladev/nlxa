package com.nlxa.java.usecase.level;

import com.nlxa.java.dto.level.LevelListResponse;
import com.nlxa.java.level.LevelBusiness;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GetAllLevels {

    private LevelBusiness levelBusiness;

    @Autowired
    public GetAllLevels(LevelBusiness levelBusiness){
        this.levelBusiness = levelBusiness;
    }

    public LevelListResponse execute() {
        log.info("Call to: GetAllLevels.execute()");
        LevelListResponse response = null;
        try {
            response = this.levelBusiness.getAllLevels();
        } catch (Exception e) {
            log.error("Error in: LevelController.getAllLevels() ", e);
        }
        return response;
    }

}
