package com.spring.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.User;
import com.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService
{	
	private static final Logger logger3 = Logger.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional(readOnly=true)
	public List<User> findAllRecords() 
	{
		return (List<User>) userRepository.findAll();
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<User> findAllRecordsSortsWithName() 
	{
		 return userRepository.findAll(new Sort(Direction.ASC,"username"));
	}
	
	@Override
	@Transactional(readOnly=true)
	public Page<User> findAllRecordsSortsWithNamegetmethod(int i) 
	{
		 return userRepository.findAll(new PageRequest(i, 4));
	}

	@Override
	public User findOneRecord(int id) 
	{		
		User user1 = userRepository.findOne(id); 
		if(user1==null)
		{
			logger3.warn("Invalid ID : "+id+"...Please Put Valid ID....");
		}
		return user1;
	}
	
	@Override
	public List<User> findOneMoreRecord(List<Integer> ids) 
	{
		List<User> user2 = userRepository.findAll(ids);
		if(user2==null)
		{
			logger3.warn("Invalid ID : "+ids+"...Please Put Valid ID....");
		}
		return user2;
	}
	
	@Override
	public String InserStudentRecords(User obj1) 
	{	
		userRepository.save(obj1);
		return "SuccessFully";
	}

	@Override
	public String DeleteStudentRecord(int id) 
	{
		
		if(!userRepository.exists(id))  // its means id don't exists in db.
		{
			logger3.warn("Invalid ID to Delete: "+id+"...Please Put Valid ID....");
		}
		else
		{
			userRepository.delete(id);
			logger3.info(id+" ID has been deleted");
		}
		return "SuccessFuly";
	}

	@Override
	public String UpdateStudentRecords(User obj) 
	{
		userRepository.save(obj);	
		return "SuccessFully";
	}
    
	@Override
	public List<User> findstudentwithname(String name) 
	{
		return userRepository.findByUsername(name);
	}

	@Override
	public List<User> findstudentNameandAge(String username, String age) 
	{
		try 
		{
		Thread.sleep(200);
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		return userRepository.findByUsernameOrUserage(username, age);
	}

	@Override
	public List<User> findstudentwithnamepagination(String username,Pageable pageable) 
	{
		return userRepository.findByUsername(username,pageable);
	}
}