package com.bayzat.bayztracker.controller;

import com.bayzat.bayztracker.common.ApiConstants;
import com.bayzat.bayztracker.entity.Alert;
import com.bayzat.bayztracker.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiConstants.BASE_ALERT_URL)
public class AlertController {

    @Autowired
    private AlertService alertService;

    @PostMapping(ApiConstants.ADD_ALERT)
    public ResponseEntity createAlert(@RequestBody Alert alert){
        try{
            Alert newAlert = this.alertService.save(alert);
            return new ResponseEntity(newAlert, HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(ApiConstants.UPDATE_ALERT)
    public ResponseEntity updateAlert(@RequestBody Alert alert, @PathVariable(name="alert-id") Long alertId){
        try{
            alert.setId(alertId);
            Alert newAlert = this.alertService.update(alert);
            return new ResponseEntity(newAlert, HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping(ApiConstants.DELETE_ALERT)
    public ResponseEntity deleteAlert(@PathVariable(name = "alert-id") Long alertId){
        try{
            alertService.delete(alertId);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(ApiConstants.CANCEL_ALERT)
    public ResponseEntity cancelAlert(@RequestParam(name = "alert-id") Long alertId){
        try{
            return new ResponseEntity(alertService.cancel(alertId), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
