package com.natth.FixitWebservice.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Repository
public class Persisrepo {

    @PersistenceContext
    private EntityManager entityManager;

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
    public  int addTechnician(String name_store ,String name_own,String email,String tel, String latitude, String longitude ,String password ,String address) throws Exception {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String last_update = sdf.format(timestamp);
       try {
           String sql = "INSERT INTO fixitdb.technicians (name_store, name_own, email, tel, latitude, longitude, password , last_update,address) VALUES ( :name_store , :name_own , :email , :tel ,:latitude , :longitude , :password , :last_update ,:address)";
           Query query = entityManager.createNativeQuery(sql);
           query.setParameter("name_store", name_store);
           query.setParameter("name_own", name_own);
           query.setParameter("email", email);
           query.setParameter("tel", tel);
           query.setParameter("latitude", latitude);
           query.setParameter("longitude", longitude);
           query.setParameter("password", password);
           query.setParameter("last_update" ,last_update);
            query.setParameter("address" ,address);
           return query.executeUpdate();
       }catch (Exception e){
           throw  new Exception();
       }

    }

    public int addRequestFix(int id_user , int id_tech , String current_status ,String user_lat ,String user_lon ,String user_address){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String last_update_request = sdf.format(timestamp);
        String sql ="INSERT INTO fixitdb.requestfix (id_user ,id_technician ,request_last_update ,current_status,user_lat ,user_lon ,user_address) VALUES (:id_user,:id_tech , :last_update ,:current_status , :user_lat, :user_lon ,:user_address)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id_user" ,id_user);
        query.setParameter("id_tech" ,id_tech);
        query.setParameter("last_update",last_update_request );
        query.setParameter("current_status" ,current_status);
        query.setParameter("user_lat" ,user_lat);
        query.setParameter("user_lon" , user_lon);
        query.setParameter("user_address" ,user_address);
        return query.executeUpdate();
    }

    public int addHistoryRequest(int id_request , String status){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String last_update_history = sdf.format(timestamp);
        String sql = "INSERT INTO fixitdb.history (id_request ,status ,history_last_update ) VALUES (:id_request ,:status ,:last_update_history)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id_request" ,id_request );
        query.setParameter("status" ,status);
        query.setParameter("last_update_history" ,last_update_history);
        return query.executeUpdate();
    }

    public int updateCurrentRequestFix(int id , String current_status){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String last_update_request = sdf.format(timestamp);
        String sql = "update fixitdb.requestfix SET request_last_update = :last_update_request, current_status = :current_status where id_requestFix = :id";

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id" ,id);
        query.setParameter("current_status" ,current_status);
        query.setParameter("last_update_request" ,last_update_request);
        return query.executeUpdate();

    }

    public int addReviewFix(int idFix , String textReview ,int rating){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String last_update_review = sdf.format(timestamp);
        String sql = "INSERT INTO fixitdb.review (textreview ,rating,review_last_update,id_request_fix) VALUES (:textReview ,:rating ,:last_update_review ,:idFix)" ;
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("idFix" ,idFix);
        query.setParameter("textReview" ,textReview);
        query.setParameter("rating" ,rating);
        query.setParameter("last_update_review" ,last_update_review);
        return query.executeUpdate();
    }

    public  int addCauseCancelFix(int idFix , String cause){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String last_update_cause  = sdf.format(timestamp);

        String sql = "INSERT INTO  fixitdb.cancel_repair_list (cause , id_listFix ,last_update) VALUES (:cause , :idFix ,:last_update_cause )" ;
        Query query = entityManager.createNativeQuery(sql );
        query.setParameter("idFix" ,idFix);
        query.setParameter("cause" ,cause);
        query.setParameter("last_update_cause" ,last_update_cause);

        return query.executeUpdate();

    }

}

