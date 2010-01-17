package org.usc.guestbook;

import java.util.Date;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import com.google.appengine.api.users.User;

/**
 * 
 * 
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2010-1-17上午11:56:27<br>
 *        Revision of last commit:$Revision$<br>
 *        Author of last commit:$Author$<br>
 *        Date of last commit:$Date$<br>
 *        <p>
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Greeting
{
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;

	@Persistent
	private User author;

	@Persistent
	private String content;

	@Persistent
	private Date date;

	public Greeting(User author, String content, Date date)
	{
		this.author = author;
		this.content = content;
		this.date = date;
	}

	public Long getId()
	{
		return id;
	}

	public User getAuthor()
	{
		return author;
	}

	public String getContent()
	{
		return content;
	}

	public Date getDate()
	{
		return date;
	}

	public void setAuthor(User author)
	{
		this.author = author;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}
}
