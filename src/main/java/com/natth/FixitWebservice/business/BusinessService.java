package com.natth.FixitWebservice.business;

import com.natth.FixitWebservice.repository.Persisrepo;
import com.natth.FixitWebservice.repository.Queryrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;
import java.util.HashMap;
import java.util.regex.Pattern;

@Service
public class BusinessService {
    private final Queryrepo queryrepo;
    private final Persisrepo persisrepo;

    @Autowired
    public BusinessService(Queryrepo queryrepo, Persisrepo persisrepo) {
        this.queryrepo = queryrepo;
        this.persisrepo = persisrepo;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ResponseEntity saveTechnicains(String name_store,String name_own,String email ,String tel ,String latitude ,String longitude ,String password ,String address) throws Exception {
        int insert =persisrepo.addTechnician(name_store, name_own, email,tel ,latitude ,longitude , password,address);
        String status = null;
        HashMap<String,String> map = new HashMap<>();
        if (insert==1){
            status = "Insert Success";
            System.out.println(status);
            map.put("status",status);

            return ResponseEntity.status(HttpStatus.CREATED).body(map);
        }else {
            status = "Insert Fail";
            System.out.println(status);
            map.put("status",status);
            return ResponseEntity.status(HttpStatus.CREATED).body(map);
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public ResponseEntity QueryTechnicians() {
        return ResponseEntity.ok(queryrepo.getTechnicians());
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public ResponseEntity QueryReviewsByTechnician(Long id) {
        return ResponseEntity.ok(queryrepo.getReviewsByTechnician(id));

    }

    @Transactional(propagation = Propagation.SUPPORTS)
public ResponseEntity QueryMxIdFix(){
        return ResponseEntity.ok(queryrepo.getRequsetFix());
}

    @Transactional(propagation = Propagation.REQUIRES_NEW )
    public ResponseEntity addRequestFixWithHistory(int id_user , int id_tech , int id_request ,String status ,String user_lat ,String user_lon ,String user_address ){
        String msg = null;
        HashMap<String,Integer> map = new HashMap<>();
        String current_status = status;
        int InsertFix = persisrepo.addRequestFix(id_user,id_tech ,current_status ,user_lat ,user_lon ,user_address);
        if (InsertFix == 1){
           Object IdFix  = queryrepo.getRequsetFix();
            id_request = ((Integer)IdFix).intValue();

            int InsertHis = persisrepo.addHistoryRequest( id_request ,status);
            if (InsertHis == 1 ){
                msg = "insert RequestFixWithHistory Success";
                map.put("idRequestFix",id_request);
                return ResponseEntity.status(HttpStatus.CREATED).body(map);
            }else {
                msg = "insert History Fail";
                map.put("idRequestFix",0);
                return ResponseEntity.status(HttpStatus.CREATED).body(map);
            }

        }else {
            msg = "insert RequestFix Fail";
            map.put("idRequestFix",0);
            return  ResponseEntity.status(HttpStatus.CREATED).body(map);
        }
    }
//เมื่อมีการเปลี่ยนแปลงสถานะ การซ่อม เช่น
    //1. request -> accept -> done -> review
    //2. request -> reject
    //3. request -> cancel
    //4. request -> overtime
    //5.  request -> accept -> dismiss
    //6.  request -> accept -> done
    @Transactional(propagation = Propagation.REQUIRES_NEW )
    public ResponseEntity addHistoryFix(int id_request , String status ){
        String msg = null;
        HashMap<String,String> map = new HashMap<>();
        int change_status_fix = persisrepo.addHistoryRequest(id_request ,status);
        if (change_status_fix == 1){
            int change_current_status = persisrepo.updateCurrentRequestFix(id_request , status);

            if (change_current_status == 1) {
                msg = "insert change_status_fix Success";
                map.put("status", msg);

                return ResponseEntity.status(HttpStatus.CREATED).body(map);
            }

            msg = "insert RequestFix Fail";
            map.put("status",msg);
            return  ResponseEntity.status(HttpStatus.CREATED).body(map);
        }else {
            msg = "insert RequestFix Fail";
            map.put("status",msg);
            return  ResponseEntity.status(HttpStatus.CREATED).body(map);
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public  ResponseEntity getHistoryFix(int id){
       return ResponseEntity.ok(queryrepo.getHistoryRequestFix(id));
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public ResponseEntity getRequestFixByStore(Long id ){
        return  ResponseEntity.ok(queryrepo.getRequestFixByStore(id));
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public ResponseEntity getRequestFixByFix(Long id ){
        return  ResponseEntity.ok(queryrepo.getRequestFixByIdFix(id));
    }
    @Transactional(propagation = Propagation.SUPPORTS)
    public ResponseEntity getRequestFixByUser(Long id ){

        return  ResponseEntity.ok(queryrepo.getRequestFixByUser(id));
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW )
    public ResponseEntity addReview(int id_request , String text_review , int rating ,String status){
        String msg = null;
        int id= id_request;
        HashMap<String,String> map = new HashMap<>();
        int InsertHis = persisrepo.addHistoryRequest( id_request ,status);
        int insert_review = persisrepo.addReviewFix(id_request,text_review ,rating);

        if (InsertHis == 1 &&  insert_review == 1 ){
            int change_current_status = persisrepo.updateCurrentRequestFix(id , status);
            if (change_current_status == 1) {
                msg = "insert change_status_fix Success";
                map.put("status", msg);

                return ResponseEntity.status(HttpStatus.CREATED).body(map);
            }else {
                msg = "insert ReviewFix Fail";
                map.put("status", msg);
                return ResponseEntity.status(HttpStatus.CREATED).body(map);
            }
            }else {
            msg = "insert ReviewFix Fail ";
            map.put("status",msg);
            return  ResponseEntity.status(HttpStatus.CREATED).body(map);
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public ResponseEntity getReviewByIdFix(Long id ){

        return  ResponseEntity.ok(queryrepo.getReviewByIdFix(id));
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW )
    public ResponseEntity addCauseCancelFix(int id_request , String cause ,String status){
        String msg = null;
        int id= id_request;
        HashMap<String,String> map = new HashMap<>();
        int InsertHis = persisrepo.addHistoryRequest( id_request ,status);
        int insertCause = persisrepo.addCauseCancelFix(id_request ,cause );

        if (InsertHis == 1 &&  insertCause == 1 ){
            int change_current_status = persisrepo.updateCurrentRequestFix(id , status);
            if (change_current_status == 1) {
                msg = "insert change_status_fix to dismiss and cause  Success";
                map.put("status", msg);

                return ResponseEntity.status(HttpStatus.CREATED).body(map);
            }else {
                msg = "insert  Fail";
                map.put("status", msg);
                return ResponseEntity.status(HttpStatus.CREATED).body(map);
            }
        }else {
            msg = "insert  Fail ";
            map.put("status",msg);
            return  ResponseEntity.status(HttpStatus.CREATED).body(map);
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public ResponseEntity getCancelListByUserId(Long id ){

        return  ResponseEntity.ok(queryrepo.getCauseCancel(id));
    }
}
