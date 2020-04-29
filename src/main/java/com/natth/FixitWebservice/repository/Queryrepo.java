package com.natth.FixitWebservice.repository;

import com.natth.FixitWebservice.model.*;
import com.sun.corba.se.impl.protocol.AddressingDispositionException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Repository
public class Queryrepo {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Technicians> getTechnicians() {

        String sql = "SELECT id_technicians ,name_store , name_own ,email ,tel ,latitude ,longitude ,address FROM fixitdb.technicians";
        Query query = entityManager.createNativeQuery(sql);
        List<Object[]> resultList = query.getResultList();
        List<Technicians> technicians = new ArrayList<>();

        resultList.forEach(objects -> {
            Technicians tech = new Technicians();
            tech.setIdTechnicians(((Integer) (objects[0])));
            tech.setNameStore((String) objects[1]);
            tech.setNameOwn((String) objects[2]);
            tech.setEmail((String) objects[3]);
            tech.setNumberphone((String) objects[4]);
            tech.setLatitude((String) objects[5]);
            tech.setLongitude((String) objects[6]);
            tech.setAddress((String) objects[7]);

            technicians.add(tech);
        });
        return technicians;
    }

    public List getReviewsByTechnician(Long id) {

        String sql = "SELECT  t.name_store ,u.firstname, u.lastname   , rw.textreview ,rw.rating , rw.review_last_update\n" +
                "            FROM fixitdb.technicians t\n" +
                "            INNER JOIN requestfix rf\n" +
                "            ON  t.id_technicians = rf.id_technician\n" +
                "            INNER JOIN users u\n" +
                "            ON  u.id_users = rf.id_user \n" +
                "            INNER JOIN review rw \n" +
                "            ON rw.id_request_fix = rf.id_requestFix\n" +
                "            where t.id_technicians = :id";

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", id);
        List<Object[]> resultList = query.getResultList();

        List<ReviewsByTechnician> reviewsByTechnicians = new ArrayList<>();
        resultList.forEach(objects -> {
            ReviewsByTechnician rwt = new ReviewsByTechnician();
            rwt.setNameStore((String) objects[0]);
            rwt.setFirstname((String) objects[1]);
            rwt.setLastname((String) objects[2]);
            rwt.setTextrevew((String) objects[3]);
            rwt.setRating(((Integer) (objects[4])));
            rwt.setLastUpdate(((Timestamp) objects[5]).toString());
            reviewsByTechnicians.add(rwt);
        });

        return reviewsByTechnicians;
    }

    public Object getRequsetFix() {
        String sql = "SELECT  MAX(id_requestFix) from requestfix";
        Query query = entityManager.createNativeQuery(sql);

        return query.getSingleResult();
    }

    public List getHistoryRequestFix(int id) {
        String sql = "SELECT  rf.id_requestFix , h.status ,h.history_last_update,rf.id_user , rf.id_technician\n" +
                "from fixitdb.requestfix rf\n" +
                "INNER JOIN history  h\n" +
                "ON rf.id_requestFix = h.id_request\n" +
                "where id_requestFix = :id";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", id);

        List<Object[]> resultlist = query.getResultList();
        List<RequestFixAndHistory> requestFixAndHistoryList = new ArrayList<>();
        resultlist.forEach(objects -> {
            RequestFixAndHistory fix = new RequestFixAndHistory();
            fix.setIdRequest((Integer) objects[0]);
            fix.setStatus((String) objects[1]);
            fix.setLastUpdate(((Timestamp) objects[2]).toString());
            fix.setIdUser((Integer) objects[3]);
            fix.setIdTechnician((Integer) objects[4]);
            requestFixAndHistoryList.add(fix);

        });
        return requestFixAndHistoryList;
    }

    public List getRequestFixByStore(Long id) {
        String sql = "SELECT   rf.id_technician,t.name_store,rf.id_requestFix , rf.current_status ,rf.request_last_update ,rf.user_lat ,rf.user_lon  , rf.id_user , u.firstname , u.lastname ,t.latitude , t.longitude ,rf.user_address\n" +
                "from fixitdb.requestfix rf\n" +
                "INNER JOIN users u\n" +
                "ON rf.id_user = u.id_users\n" +
                "INNER JOIN technicians t\n" +
                "ON rf.id_technician = t.id_technicians\n" +
                "where id_technician =  :id\n" +
                "ORDER BY rf.request_last_update DESC ";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", id);
        List<Object[]> resultList = query.getResultList();
        List<RequestFixByTechnician> requestFixByTechnicianList = new ArrayList<>();
        resultList.forEach(objects -> {
            RequestFixByTechnician rqt = new RequestFixByTechnician();
            rqt.setIdTechnician((Integer) objects[0]);
            rqt.setNameStore((String) objects[1]);
            rqt.setIdRequest((Integer) objects[2]);
            rqt.setStatus((String) objects[3]);
            rqt.setLastUpdate(((Timestamp) objects[4]).toString());
            rqt.setUser_lat((String) objects[5]);
            rqt.setUser_lon((String) objects[6]);
            rqt.setIdUser((Integer) objects[7]);
            rqt.setFirstnameUser((String) objects[8]);
            rqt.setLastnameUser((String) objects[9]);
            rqt.setTech_lat((String) objects[10]);
            rqt.setTech_lon((String) objects[11]);
            rqt.setUser_address((String) objects[12]);

            requestFixByTechnicianList.add(rqt);

        });
        return requestFixByTechnicianList;
    }

    public List getRequestFixByIdFix(Long id) {
        String sql = "select rf.id_technician ,t.name_store, rf.id_requestFix , rf.current_status ,rf.request_last_update ,rf.user_lat ,rf.user_lon  , rf.id_user , u.firstname , u.lastname ,rf.user_address \n" +
                "from fixitdb.requestfix rf \n" +
                "inner join fixitdb.users u\n" +
                "on rf.id_user = u.id_users\n" +
                "inner join fixitdb.technicians t \n" +
                "on rf.id_technician = t.id_technicians \n" +
                "where id_requestFix = :id";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", id);
        List<Object[]> resultList = query.getResultList();
        List<RequestFixByTechnician> requestFixByIdFix = new ArrayList<>();
        resultList.forEach(objects -> {
            RequestFixByTechnician rqt = new RequestFixByTechnician();
            rqt.setIdTechnician((Integer) objects[0]);
            rqt.setNameStore((String) objects[1]);
            rqt.setIdRequest((Integer) objects[2]);
            rqt.setStatus((String) objects[3]);
            rqt.setLastUpdate(((Timestamp) objects[4]).toString());
            rqt.setUser_lat((String) objects[5]);
            rqt.setUser_lon((String) objects[6]);
            rqt.setIdUser((Integer) objects[7]);
            rqt.setFirstnameUser((String) objects[8]);
            rqt.setLastnameUser((String) objects[9]);
            rqt.setUser_address((String) objects[10]);

            requestFixByIdFix.add(rqt);

        });
        return requestFixByIdFix;
    }

    public List getRequestFixByUser(Long id) {
        String sql = "select rf.id_user , t.name_store , rf.id_requestFix , rf.current_status ,rf.request_last_update ,u.firstname ,u.lastname ,rf.user_lat ,rf.user_lon ,t.latitude ,t.longitude ,rf.user_address\n" +
                "from fixitdb.requestfix rf \n" +
                "inner join fixitdb.users u\n" +
                "on rf.id_user = u.id_users\n" +
                "inner join fixitdb.technicians t \n" +
                "on rf.id_technician = t.id_technicians \n" +
                "where id_user = :id\n" +
                "order by id_requestFix desc";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", id);
        List<Object[]> resultList = query.getResultList();
        List<RequestFixByUser> requestFixByUsers = new ArrayList<>();
        resultList.forEach(objects -> {
            RequestFixByUser rqt = new RequestFixByUser();
            rqt.setIdUser((Integer) objects[0]);
            rqt.setNameStore((String) objects[1]);
            rqt.setIdRequest((Integer) objects[2]);
            rqt.setStatus((String) objects[3]);
            rqt.setLastUpdate(((Timestamp) objects[4]).toString());
            rqt.setFirstnameUser((String) objects[5]);
            rqt.setLastnameUser((String) objects[6]);
            rqt.setUser_lat((String) objects[7]);
            rqt.setUser_lon((String) objects[8]);
            rqt.setTech_lat((String) objects[9]);
            rqt.setTech_lon((String) objects[10]);
            rqt.setUser_address((String) objects[11]);

            requestFixByUsers.add(rqt);
        });
        return requestFixByUsers;
    }

    public List getReviewByIdFix(Long id) {
        String sql = "SELECT rw.id_request_fix ,rw.textreview ,rw.rating , rw.review_last_update, u.firstname ,u.lastname ,t.name_store\n" +
                "FROM fixitdb.review  rw \n" +
                "INNER JOIN  fixitdb.requestfix rf \n" +
                "ON rw.id_request_fix = rf.id_requestFix \n" +
                "INNER JOIN fixitdb.users u \n" +
                "ON u.id_users = rf.id_user \n" +
                "INNER JOIN fixitdb.technicians t\n" +
                "ON t.id_technicians = rf.id_technician \n" +
                "WHERE id_request_fix = :id";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", id);
        List<Object[]> rsReview = query.getResultList();
        List<ReviewByIdFix> reviewByIdFixes = new ArrayList<>();
        rsReview.forEach(objects -> {
            ReviewByIdFix rwf = new ReviewByIdFix();

            rwf.setIdRequest((Integer) objects[0]);
            rwf.setTextReview((String) objects[1]);
            rwf.setRating((Integer) objects[2]);
            rwf.setLastUpdate(((Timestamp) objects[3]).toString());
            rwf.setFirstNameUser((String) objects[4]);
            rwf.setLastNameUser((String) objects[5]);
            rwf.setNameStore((String) objects[6]);
            reviewByIdFixes.add(rwf);
        });

        return reviewByIdFixes;
    }

//    public List getRequestFixByID(Long id){
//        String sql = "";
//        Query query = entityManager.createNativeQuery(sql);
//        query.setParameter("id", id);
//        List<Object[]> resultList = query.getResultList();
//
//    }
//
    public  List getCauseCancel (Long id){
        String sql = "SELECT rw.id_requestFix ,  c.cause , c.last_update  ,t.name_store , rw.current_status\n" +
                "FROM fixitdb.requestfix rw \n" +
                "INNER JOIN fixitdb.cancel_repair_list c \n" +
                "ON  rw.id_requestFix = c.id_listFix\n" +
                "INNER JOIN fixitdb.technicians t\n" +
                "ON  rw.id_technician = t.id_technicians\n" +
                "WHERE id_user = :id";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", id);
        List<Object[]> rsCancelFix = query.getResultList();
        List<CauseCancelFixandHistory> cancelFixandHistories = new ArrayList<>();
        rsCancelFix.forEach(objects -> {
            CauseCancelFixandHistory ccf = new CauseCancelFixandHistory();
            ccf.setIdFix((Integer) objects[0]);
            ccf.setCause((String) objects[1]);
            ccf.setLast_update(((Timestamp) objects[2]).toString());
            ccf.setName_store((String) objects[3]);
            ccf.setStatus((String) objects[4]);
            cancelFixandHistories.add(ccf);
        });

        return cancelFixandHistories;
    }

}
