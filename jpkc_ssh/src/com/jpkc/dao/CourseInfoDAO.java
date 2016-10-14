package com.jpkc.dao;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jpkc.common.IResult;
import com.jpkc.pojo.Course;
import com.jpkc.pojo.CourseInfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * CourseInfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.jpkc.pojo.CourseInfo
 * @author MyEclipse Persistence Tools
 */
public class CourseInfoDAO extends BaseHibernateDAO
{
	private static final Logger log = LoggerFactory.getLogger(CourseInfoDAO.class);
	// property constants
	public static final String VIDEO_MP4 = "videoMp4";
	public static final String VIDEO_FLV = "videoFlv";
	public static final String STAR_SCORE = "starScore";
	public static final String DOC1 = "doc1";
	public static final String DOC2 = "doc2";
	public static final String DOC3 = "doc3";
	public static final String DOC4 = "doc4";
	public static final String DOC5 = "doc5";
	public static final String DOC6 = "doc6";
	public static final String DOC7 = "doc7";
	public static final String DOC8 = "doc8";

	public CourseInfo save(CourseInfo transientInstance)
	{
		Transaction tx = null;
		try
		{
			tx = getSession().beginTransaction();
			getSession().saveOrUpdate(transientInstance);
			tx.commit();
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
			if (tx != null)
			{
				tx.rollback();
			}
			return null;
		}
		finally
		{
			if (getSession() != null && getSession().isOpen() == true)
			{
				getSession().close();
			}
		}
		return transientInstance;
	}

	public List<CourseInfo> saveList(List<CourseInfo> list)
	{
		Transaction tx = null;
		try
		{
			tx = getSession().beginTransaction();
			for (CourseInfo listRecord : list)
			{
				getSession().saveOrUpdate(listRecord);
			}
			tx.commit();
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
			if (tx != null)
			{
				tx.rollback();
			}
			return null;
		}
		finally
		{
			if (getSession() != null && getSession().isOpen() == true)
			{
				getSession().close();
			}
		}
		return list;
	}

	public int delete(CourseInfo persistentInstance)
	{
		Transaction tx = null;
		try
		{
			tx = getSession().beginTransaction();
			getSession().delete(persistentInstance);
			tx.commit();
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
			if (tx != null)
			{
				tx.rollback();
			}
			return IResult.DELETE_EXCEPTION;
		}
		finally
		{
			if (getSession() != null && getSession().isOpen() == true)
			{
				getSession().close();
			}
		}
		return IResult.DELETE_SUCCESS;
	}

	public CourseInfo findById(java.lang.String id)
	{
		log.debug("getting CourseInfo instance with id: " + id);
		try
		{
			CourseInfo instance = (CourseInfo) getSession().get("com.jpkc.pojo.CourseInfo", id);
			return instance;
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
			return null;
		}
		finally
		{
			if (getSession() != null && getSession().isOpen() == true)
			{
				getSession().close();
			}
		}
	}

	public List findByProperty(String propertyName, Object value)
	{
		log.debug("finding CourseInfo instance with property: " + propertyName + ", value: " + value);
		try
		{
			String queryString = "from CourseInfo as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
			return null;
		}
		finally
		{
			if (getSession() != null && getSession().isOpen() == true)
			{
				getSession().close();
			}
		}
	}

	public List findByVideoMp4(Object videoMp4)
	{
		return findByProperty(VIDEO_MP4, videoMp4);
	}

	public List findByVideoFlv(Object videoFlv)
	{
		return findByProperty(VIDEO_FLV, videoFlv);
	}

	public List findByStarScore(Object starScore)
	{
		return findByProperty(STAR_SCORE, starScore);
	}

	public List findByDoc1(Object doc1)
	{
		return findByProperty(DOC1, doc1);
	}

	public List findByDoc2(Object doc2)
	{
		return findByProperty(DOC2, doc2);
	}

	public List findByDoc3(Object doc3)
	{
		return findByProperty(DOC3, doc3);
	}

	public List findByDoc4(Object doc4)
	{
		return findByProperty(DOC4, doc4);
	}

	public List findByDoc5(Object doc5)
	{
		return findByProperty(DOC5, doc5);
	}

	public List findByDoc6(Object doc6)
	{
		return findByProperty(DOC6, doc6);
	}

	public List findByDoc7(Object doc7)
	{
		return findByProperty(DOC7, doc7);
	}

	public List findByDoc8(Object doc8)
	{
		return findByProperty(DOC8, doc8);
	}

	public List getList(int index, int pageSize)
	{
		try
		{
			String sql = "from CourseInfo order by courseId asc";
			Query query = getSession().createQuery(sql);
			query.setFirstResult((index - 1) * pageSize);
			query.setMaxResults(pageSize);
			List tempList = query.list();
			if (tempList == null)
			{
				return null;
			}
			else
			{
				if (tempList.size() > 0)
				{
					return tempList;
				}
				else
				{
					return null;
				}
			}
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
			return null;
		}
		finally
		{
			if (getSession() != null && getSession().isOpen() == true)
			{
				getSession().close();
			}
		}
	}

	public int getTotalCount()
	{
		try
		{
			String sql = "select count(*) from CourseInfo";
			Query query = getSession().createQuery(sql);
			int num = ((Number) query.iterate().next()).intValue();
			return num;
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
			return -1;
		}
		finally
		{
			if (getSession() != null && getSession().isOpen() == true)
			{
				getSession().close();
			}
		}
	}

}