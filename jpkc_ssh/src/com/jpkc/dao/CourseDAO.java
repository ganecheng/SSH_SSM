package com.jpkc.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jpkc.pojo.Course;
import com.jpkc.common.IResult;

/**
 * A data access object (DAO) providing persistence and search support for
 * Course entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.jpkc.pojo.Course
 * @author MyEclipse Persistence Tools
 */
public class CourseDAO extends BaseHibernateDAO
{
	private static final Logger log = LoggerFactory.getLogger(CourseDAO.class);
	// property constants
	public static final String COURSE_NAME = "courseName";
	public static final String COURSE_PARENT_ID = "courseParentId";

	public Course save(Course transientInstance)
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

	public List<Course> saveList(List<Course> list)
	{
		Transaction tx = null;
		try
		{
			tx = getSession().beginTransaction();
			for (Course listRecord : list)
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

	public int delete(Course persistentInstance)
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

	public Course findById(java.lang.String id)
	{
		log.debug("getting Course instance with id: " + id);
		try
		{
			Course instance = (Course) getSession().get("com.jpkc.pojo.Course", id);
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
		log.debug("finding Course instance with property: " + propertyName + ", value: " + value);
		try
		{
			String queryString = "from Course as model where model." + propertyName + "= ?";
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

	public List findByCourseName(Object courseName)
	{
		return findByProperty(COURSE_NAME, courseName);
	}

	public List findByCourseParentId(Object courseParentId)
	{
		return findByProperty(COURSE_PARENT_ID, courseParentId);
	}

	public List getList(int index, int pageSize)
	{
		try
		{
			String sql = "from Course order by courseId asc";
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
			String sql = "select count(*) from Course";
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


	public List findAll()
	{
		log.debug("finding all Course instances");
		try
		{
			String queryString = "from Course";
			Query queryObject = getSession().createQuery(queryString);
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

	public int deleteListByIds(List<String> idsList)
	{
		Transaction tx = null;
		int num = 0;
		try
		{
			tx = getSession().beginTransaction();
			String sql = "delete from Course c where c.courseId in :idsList";
			Query query = getSession().createQuery(sql);
			query.setParameterList("idsList", idsList);
			num = query.executeUpdate();
			tx.commit();

			if (num > 0)
			{
				return IResult.DELETE_SUCCESS;
			}
			else
			{
				return IResult.DELETE_EXCEPTION;
			}
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
	}
}