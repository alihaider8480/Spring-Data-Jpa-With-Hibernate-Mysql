package com.spring.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
@Table(name="user")
@NamedNativeQuery(name = "User.findByUsername",query = "select * from user where username=?1",
                                        resultClass=User.class)
public class User 
{
	@Id
	private int userid;
    private String username;
    private String userage;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserage() {
		return userage;
	}
	public void setUserage(String userage) {
		this.userage = userage;
	}     
}








/*
 @NamedQueries(value = {@NamedQuery(name = "findByUsername", query = "SELECT P FROM User P WHERE P.username=?1")})

 agar ma multiple query select karo ga to  ma @namedQueries use karo ga 
 agar single ao ga to @namedquery use karo ga
 
 or isma name = "findByUsername" is ma method ka name ae ga jo repository
 ma banaya hoga  jasa he ma wo method call karo ga to ya wali query call
 hogi like chala gi or query ko cappital letter ma likho to acha  ha.
 
 
*/

/*
NamedQuery

@NamedQueries
(
 value ={ 
		@NamedQuery(name = "findByUsername", query = "SELECT P FROM User P WHERE P.username=?1"),
		@NamedQuery(name = "findByUsernameOrUserage", query = "SELECT P FROM User P WHERE P.username=?1 And P.userage=?2")

        }
)

is tarika sa hum multiple query call karsakta ha.
*/

/*

@NamedNativeQueries(value=
{
  @NamedNativeQuery(name = "User.findByUsername",query = "select * from user where username=?1",resultClass=User.class),
   @NamedNativeQuery(name = "User.findByUsernameOrUserage",query = "select * from user where username=?1 or userage = ?2",resultClass=User.class) 
}
)

is ma name ka andar pojo class ka name ae ga jasa ha same wasa like Employee ha to Employee.method name ae ga
tab he ya direct sql ki query chalae ga.  

*/