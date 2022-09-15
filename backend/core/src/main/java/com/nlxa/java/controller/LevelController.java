package com.nlxa.java.controller;

import com.nlxa.java.dto.level.GetLevelByIdRequest;
import com.nlxa.java.dto.level.LevelListResponse;
import com.nlxa.java.dto.level.LevelResponse;
import com.nlxa.java.level.LevelBusiness;
import com.nlxa.java.usecase.level.GetAllLevels;
import com.nlxa.java.usecase.level.GetLevelById;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/level")
public class LevelController {

    private GetAllLevels getAllLevels;
    private GetLevelById getLevelById;

    @Autowired
    public LevelController(GetAllLevels getAllLevels, GetLevelById getLevelById){
        this.getAllLevels = getAllLevels;
        this.getLevelById = getLevelById;
    }

    @GetMapping(value = "/all")
    public LevelListResponse getAllLevels() {
        log.info("Call to: LevelController.getAllLevels()");
        LevelListResponse response = null;
        try {
            response = this.getAllLevels.execute();
        } catch (Exception e) {
            log.error("Error in: LevelController.getAllLevels() ", e);
        }
        return response;
    }

    @GetMapping(value = "/byId")
    public LevelResponse getById(@RequestBody GetLevelByIdRequest request) {
        log.info("Call to: LevelController.getById()");
        LevelResponse response = null;
        try {
            response = this.getLevelById.execute(request);
        } catch (Exception e) {
            log.error("Error in: LevelController.getById() ", e);
        }
        return response;
    }



}
