package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojo.Attendence;
import java.util.List;
import java.util.Date;
import com.app.pojo.User;



public interface AttendenceDao extends JpaRepository<Attendence, Long>{
           public Attendence findByUserAndDate(User user, Date date);
           public List<Attendence> findByUser(User user);
}
