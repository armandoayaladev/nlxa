package com.nlxa.java.usecase.level;

import com.nlxa.java.dto.level.GetLevelByIdRequest;
import com.nlxa.java.dto.level.LevelListResponse;
import com.nlxa.java.dto.level.LevelResponse;
import com.nlxa.java.level.LevelBusiness;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GetLevelById {

    private LevelBusiness levelBusiness;

    @Autowired
    public GetLevelById(LevelBusiness levelBusiness){
        this.levelBusiness = levelBusiness;
    }

    public LevelResponse execute(GetLevelByIdRequest request) {
        log.info("Call to: GetAllLevels.execute()");
        LevelResponse response = null;
        try {
            if(verifyRequestInfo(request)){
                response = this.levelBusiness.getById(request);
            }
        } catch (Exception e) {
            log.error("Error in: GetAllLevels.execute() ", e);
        }
        return response;
    }

    private Boolean verifyRequestInfo(GetLevelByIdRequest request){
        log.info("Call to: GetLevelById.verifyRequestInfo()");
        Boolean result = true;
        if(request == null || request.getLevelId() == null) {
            log.warn("Warn: The request or the request info is null");
            result = false;
        } else if(request.getLevelId().equals("")){
            log.warn("Warn: The request info is empty");
            result = false;
        }
        return result;
    }
}
