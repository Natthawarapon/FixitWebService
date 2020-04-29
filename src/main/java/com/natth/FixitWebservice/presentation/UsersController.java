package com.natth.FixitWebservice.presentation;

import com.natth.FixitWebservice.business.BusinessService;
import com.natth.FixitWebservice.model.History;
import com.natth.FixitWebservice.model.RequestFixAndHistory;
import com.natth.FixitWebservice.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
public class UsersController {

    @Autowired
    private BusinessService businessService;

    @PostMapping(value = "/requestFix" , produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity add_RequestFixAndHistory(@RequestBody RequestFixAndHistory requestFixAndHistory){
        return businessService.addRequestFixWithHistory(requestFixAndHistory.getIdUser() ,
                requestFixAndHistory.getIdTechnician(),
                requestFixAndHistory.getIdRequest() ,
                requestFixAndHistory.getStatus() ,
                requestFixAndHistory.getUser_lat(),
                requestFixAndHistory.getUser_lon(),
                requestFixAndHistory.getUser_address()
                );
    }

    @GetMapping(value = "/maxidfix" ,produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity getMaxIdFix(){
        return businessService.QueryMxIdFix();
    }

    @PostMapping(value = "/change_status_fix" ,produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity change_status_fix(@RequestBody History history){
        return businessService.addHistoryFix(history.getIdRequest(),history.getStatus());
    }

    @GetMapping(value = "/historyFix/{id}")
    public ResponseEntity getHistoryFix(@PathVariable(value = "id") int id){
        return businessService.getHistoryFix(id);
    }

    @GetMapping(value = "/requestfixbyUser/{id}" , produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity findRequestFixByUser(@PathVariable(value = "id")Long id){
        return businessService.getRequestFixByUser(id);
    }

    @PostMapping(value = "/review_store" ,produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity review_store(@RequestBody Review review){
        return businessService.addReview(review.getIdRequest(),review.getTextreview() ,review.getRating() , review.getStatus());
    }

    @GetMapping(value = "/IdFix/review/{id}" , produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity findReviewByIdFix(@PathVariable(value = "id")Long id){
        return businessService.getReviewByIdFix(id);
    }

    @GetMapping(value = "/cancelFix/{id}" , produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity findCancelListFixByUserId(@PathVariable(value = "id")Long id){
        return businessService.getCancelListByUserId(id);
    }
}
