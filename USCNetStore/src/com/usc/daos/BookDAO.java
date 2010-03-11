package com.usc.daos;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for Book
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.usc.daos.Book
 * @author MyEclipse Persistence Tools
 */

public class BookDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(BookDAO.class);
	// property constants
	public static final String BOOK_NAME = "bookName";
	public static final String AUTHOR = "author";
	public static final String PUBLISHER = "publisher";
	public static final String VERSION = "version";
	public static final String ISBN = "isbn";
	public static final String PUBLISHED_PRICE = "publishedPrice";
	public static final String CATALOG = "catalog";
	public static final String PICTURE = "picture";
	public static final String BRIEF_INTRODUCTION = "briefIntroduction";
	public static final String PRODUCTS_PFLAG = "productsPflag";

	protected void initDao()
	{
		// do nothing
	}

	public void save(Book transientInstance)
	{
		log.debug("saving Book instance");
		try
		{
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re)
		{
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Book persistentInstance)
	{
		log.debug("deleting Book instance");
		try
		{
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re)
		{
			log.error("delete failed", re);
			throw re;
		}
	}

	public Book findById(java.lang.Integer id)
	{
		log.debug("getting Book instance with id: " + id);
		try
		{
			Book instance = (Book) getHibernateTemplate().get(
					"com.usc.daos.Book", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Book instance)
	{
		log.debug("finding Book instance by example");
		try
		{
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re)
		{
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value)
	{
		log.debug("finding Book instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from Book as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByBookName(Object bookName)
	{
		return findByProperty(BOOK_NAME, bookName);
	}

	/**
	 * ͼ�����ģ����� ������־λΪ0
	 * 
	 * @param bookName
	 * @return
	 */

	public List<Book> findByLikeBookName(String bookName)
	{
		String queryString = "from Book as b where b.productsPflag = 0 and b.bookName like '%"
				+ bookName + "%'";
		return getHibernateTemplate().find(queryString);
	}

	/**
	 * ͼ�����ģ����� �Ѿ������Ĳ�ƷҲ����ͨ��Ʒ��ģ����� ������־λΪ0
	 * 
	 * @param bookName
	 * @return
	 */

	public List<Book> findByLikeCommonBookName(String bookName)
	{
		String queryString = "from Book as b where b.productsPflag = 1 and b.bookName like '%"
				+ bookName + "%'";
		return getHibernateTemplate().find(queryString);
	}

	/**
	 * ͼ��ĸ߼�����
	 * 
	 * @param author
	 * @return
	 */

	public List<Book> AdvancedBookSearch(String bookName, String author,
			String isbn, String publisher)
	{
		String queryString = "from Book as b where b.productsPflag = 1 and b.bookName like '%"
				+ bookName
				+ "%' and b.author like '%"
				+ author
				+ "%' and b.isbn like '%"
				+ isbn
				+ "%' and b.publisher like '%" + publisher + "%'";
		return getHibernateTemplate().find(queryString);

	}

	

	
	public List findByAuthor(Object author)
	{
		return findByProperty(AUTHOR, author);
	}

	public List findByPublisher(Object publisher)
	{
		return findByProperty(PUBLISHER, publisher);
	}

	public List findByVersion(Object version)
	{
		return findByProperty(VERSION, version);
	}

	public List<Book> findByIsbn(Object isbn)
	{
		return findByProperty(ISBN, isbn);
	}

	public List findByPublishedPrice(Object publishedPrice)
	{
		return findByProperty(PUBLISHED_PRICE, publishedPrice);
	}

	public List findByCatalog(Object catalog)
	{
		return findByProperty(CATALOG, catalog);
	}

	public List findByPicture(Object picture)
	{
		return findByProperty(PICTURE, picture);
	}

	public List findByBriefIntroduction(Object briefIntroduction)
	{
		return findByProperty(BRIEF_INTRODUCTION, briefIntroduction);
	}

	public List findByProductsPflag(Object productsPflag)
	{
		return findByProperty(PRODUCTS_PFLAG, productsPflag);
	}

	public List<Book> findAll()
	{
		log.debug("finding all Book instances");
		try
		{
			String queryString = "from Book";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public Book merge(Book detachedInstance)
	{
		log.debug("merging Book instance");
		try
		{
			Book result = (Book) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Book instance)
	{
		log.debug("attaching dirty Book instance");
		try
		{
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Book instance)
	{
		log.debug("attaching clean Book instance");
		try
		{
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public static BookDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (BookDAO) ctx.getBean("BookDAO");
	}
}