package com.ansible;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepo extends JpaRepository<Registration, String>{
	 @Query("SELECT u FROM Registration u WHERE u.mail = ?1")
	    public Registration findByMail(String mail);
	
}