package com.jpkc.dao;

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
import com.jpkc.pojo.Star;

/**
 * A data access object (DAO) providing persistence and search support for Star
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.jpkc.pojo.Star
 * @author MyEclipse Persistence Tools
 */
public class StarDAO extends BaseHibernateDAO
{
	private static final Logger log = LoggerFactory.getLogger(StarDAO.class);
	// property constants
	public static final String COURSE_ID = "courseId";
	public static final String STAR_SCORE = "starScore";
	public static final String DEVICE_INFO = "deviceInfo";

	public Star save(Star transientInstance)
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

	public List<Star> saveList(List<Star> list)
	{
		Transaction tx = null;
		try
		{
			tx = getSession().beginTransaction();
			for (Star listRecord : list)
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

	public int delete(Star persistentInstance)
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

	public Star findById(java.lang.String id)
	{
		log.debug("getting Star instance with id: " + id);
		try
		{
			Star instance = (Star) getSession().get("com.jpkc.pojo.Star", id);
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
		log.debug("finding Star instance with property: " + propertyName + ", value: " + value);
		try
		{
			String queryString = "from Star as model where model." + propertyName + "= ?";
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

	public List findByCourseId(Object courseId)
	{
		return findByProperty(COURSE_ID, courseId);
	}

	public List findByStarScore(Object starScore)
	{
		return findByProperty(STAR_SCORE, starScore);
	}

	public List findByDeviceInfo(Object deviceInfo)
	{
		return findByProperty(DEVICE_INFO, deviceInfo);
	}

	public List getList(int index, int pageSize)
	{
		try
		{
			String sql = "from Star order by starId asc";
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
			String sql = "select count(*) from Star";
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