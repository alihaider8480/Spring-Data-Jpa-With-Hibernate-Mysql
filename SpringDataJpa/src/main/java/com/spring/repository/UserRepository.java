package com.spring.repository;



import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{

	List<User> findByUsername(String username);
	
	List<User> findByUsername(String username,Pageable value);
	
	@Query(value="select * from user where username=?1 or userage=?2",nativeQuery=true)
	List<User> findByUsernameOrUserage(String username,String age); 
}























/*
 List<User> findByUsernameOrUserage(String username,String age);   

Or ka matlab ha ka Username or userage sa search Kara ga return type list 
hogi islia kio ga agar username 3 4 ka same howa ya age bhe same hoi islia.
or is ma ya ha ka agar username da rahe hoon age ni da raeh ho to phr bhe
search kara ga ya phir age da rahe hoon name ni da rahe hoon to bhe search
karaga. 
agar ma And Use karo ga to dono he aik he waqat ma dana para gi to he 
search kara ga warna search ni kara ga 

*/


/*
 @Query(value="SELECT p.user_id,p.user_name,p.user_age FROM User p where p.user_name =?1 ",nativeQuery=true)  
 */


/*nativeQuery=true      is sa run time ma apni query dikha gi like
                      select p.user_name,p.user_id,p.user_age from User
                      where p.username=? agar hum nativeQuery False 
                      kardda ya ni likha ga to wo wali query ae gi user0,username1=?
*/  
