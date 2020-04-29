package com.natth.FixitWebservice.presentation;

import com.natth.FixitWebservice.business.BusinessService;
import com.natth.FixitWebservice.model.CauseCancelFixandHistory;
import com.natth.FixitWebservice.model.History;
import com.natth.FixitWebservice.model.RequestFixAndHistory;
import com.natth.FixitWebservice.model.Technicians;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
public class TechnicainsController {
    @Autowired
    private BusinessService businessService;

    @PostMapping(value = "/technicain" , produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity add_Technician(@RequestBody Technicians technicians) throws Exception {
        return businessService.saveTechnicains( technicians.getNameStore(),technicians.getNameOwn(),technicians.getEmail(),technicians.getNumberphone(),technicians.getLatitude() ,technicians.getLongitude(),technicians.getPassword() ,technicians.getAddress());

    }

    @GetMapping(value = "/technicians" , produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity findAllTechnicians(){
        return businessService.QueryTechnicians();
    }

    @GetMapping(value = "/reviewsbytech/{id}" , produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity findAllReviewsByTechnicians (@PathVariable(value = "id") Long id ) {
        return  businessService.QueryReviewsByTechnician(id);
    }

    @GetMapping(value = "/requestfixbytech/{id}" , produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity findRequestFixByStore(@PathVariable(value = "id")Long id){
        return businessService.getRequestFixByStore(id);
    }

    @GetMapping(value = "/requestfixbyidFix/{id}" , produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity findRequestFixByIdFix(@PathVariable(value = "id")Long id){
        return businessService.getRequestFixByFix(id);
    }

    @PostMapping(value = "/cancelFix" , produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity add_CancelFxi(@RequestBody CauseCancelFixandHistory cancelFixandHistory) throws Exception {
        return businessService.addCauseCancelFix(cancelFixandHistory.getIdFix(), cancelFixandHistory.getCause() , cancelFixandHistory.getStatus());
    }


}
