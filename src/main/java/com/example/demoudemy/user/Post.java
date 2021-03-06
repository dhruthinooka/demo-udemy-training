
  package com.example.demoudemy.user;
  
  import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
  
  @Entity
  public class Post {
  
  @Id
  @GeneratedValue
  private int id; 
  
  private String description;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JsonIgnore
  private User user;
 /**
	 * @return the id
	 */

  public int getId() { 
	  return id;
	  }
 /**
	 * @param id the id to set
	 */

  public void setId(int id) {
	  this.id = id;
	  }
 /**
	 * @return the description
	 */

  public String getDescription() {
	  return description; 
	  }
 /**
	 * @param description the description to set
	 */

  public void setDescription(String description) { 
	  this.description =
  description; 
	  }
  
 /**
	 * @return the user
	 */

  public User getUser() { 
	  return user;
	  }
 /**
	 * @param user the user to set
	 */
		  public void setUser(User user) {
			  this.user = user;
			  }
		  
		  @Override public String toString() { return "Post [id=" + id +
		  ", description=" + description + "]"; }
		  
		  
		  
		  }
		 