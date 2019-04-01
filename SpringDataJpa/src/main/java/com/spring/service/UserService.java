package com.spring.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spring.model.User;

@Service
public interface UserService 
{
   public List<User> findAllRecords();
   
   public List<User> findAllRecordsSortsWithName();
   
   public Page<User> findAllRecordsSortsWithNamegetmethod(int i);
   
   public  User findOneRecord(int id);
   
   public List<User> findOneMoreRecord(List<Integer> ids);
   
   public String InserStudentRecords(User obj1);
   
   public String DeleteStudentRecord(int id);
   
   public String UpdateStudentRecords(User obj);

   public List<User> findstudentwithname(String name);
   
   public List<User> findstudentNameandAge(String username,String age);

   public List<User> findstudentwithnamepagination(String username,Pageable pageable);   

}
