package com.jpkc.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StarExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StarExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andStarIdIsNull() {
            addCriterion("star_id is null");
            return (Criteria) this;
        }

        public Criteria andStarIdIsNotNull() {
            addCriterion("star_id is not null");
            return (Criteria) this;
        }

        public Criteria andStarIdEqualTo(String value) {
            addCriterion("star_id =", value, "starId");
            return (Criteria) this;
        }

        public Criteria andStarIdNotEqualTo(String value) {
            addCriterion("star_id <>", value, "starId");
            return (Criteria) this;
        }

        public Criteria andStarIdGreaterThan(String value) {
            addCriterion("star_id >", value, "starId");
            return (Criteria) this;
        }

        public Criteria andStarIdGreaterThanOrEqualTo(String value) {
            addCriterion("star_id >=", value, "starId");
            return (Criteria) this;
        }

        public Criteria andStarIdLessThan(String value) {
            addCriterion("star_id <", value, "starId");
            return (Criteria) this;
        }

        public Criteria andStarIdLessThanOrEqualTo(String value) {
            addCriterion("star_id <=", value, "starId");
            return (Criteria) this;
        }

        public Criteria andStarIdLike(String value) {
            addCriterion("star_id like", value, "starId");
            return (Criteria) this;
        }

        public Criteria andStarIdNotLike(String value) {
            addCriterion("star_id not like", value, "starId");
            return (Criteria) this;
        }

        public Criteria andStarIdIn(List<String> values) {
            addCriterion("star_id in", values, "starId");
            return (Criteria) this;
        }

        public Criteria andStarIdNotIn(List<String> values) {
            addCriterion("star_id not in", values, "starId");
            return (Criteria) this;
        }

        public Criteria andStarIdBetween(String value1, String value2) {
            addCriterion("star_id between", value1, value2, "starId");
            return (Criteria) this;
        }

        public Criteria andStarIdNotBetween(String value1, String value2) {
            addCriterion("star_id not between", value1, value2, "starId");
            return (Criteria) this;
        }

        public Criteria andCourseIdIsNull() {
            addCriterion("course_id is null");
            return (Criteria) this;
        }

        public Criteria andCourseIdIsNotNull() {
            addCriterion("course_id is not null");
            return (Criteria) this;
        }

        public Criteria andCourseIdEqualTo(String value) {
            addCriterion("course_id =", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotEqualTo(String value) {
            addCriterion("course_id <>", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThan(String value) {
            addCriterion("course_id >", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThanOrEqualTo(String value) {
            addCriterion("course_id >=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThan(String value) {
            addCriterion("course_id <", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThanOrEqualTo(String value) {
            addCriterion("course_id <=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLike(String value) {
            addCriterion("course_id like", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotLike(String value) {
            addCriterion("course_id not like", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdIn(List<String> values) {
            addCriterion("course_id in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotIn(List<String> values) {
            addCriterion("course_id not in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdBetween(String value1, String value2) {
            addCriterion("course_id between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotBetween(String value1, String value2) {
            addCriterion("course_id not between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andStarScoreIsNull() {
            addCriterion("star_score is null");
            return (Criteria) this;
        }

        public Criteria andStarScoreIsNotNull() {
            addCriterion("star_score is not null");
            return (Criteria) this;
        }

        public Criteria andStarScoreEqualTo(Integer value) {
            addCriterion("star_score =", value, "starScore");
            return (Criteria) this;
        }

        public Criteria andStarScoreNotEqualTo(Integer value) {
            addCriterion("star_score <>", value, "starScore");
            return (Criteria) this;
        }

        public Criteria andStarScoreGreaterThan(Integer value) {
            addCriterion("star_score >", value, "starScore");
            return (Criteria) this;
        }

        public Criteria andStarScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("star_score >=", value, "starScore");
            return (Criteria) this;
        }

        public Criteria andStarScoreLessThan(Integer value) {
            addCriterion("star_score <", value, "starScore");
            return (Criteria) this;
        }

        public Criteria andStarScoreLessThanOrEqualTo(Integer value) {
            addCriterion("star_score <=", value, "starScore");
            return (Criteria) this;
        }

        public Criteria andStarScoreIn(List<Integer> values) {
            addCriterion("star_score in", values, "starScore");
            return (Criteria) this;
        }

        public Criteria andStarScoreNotIn(List<Integer> values) {
            addCriterion("star_score not in", values, "starScore");
            return (Criteria) this;
        }

        public Criteria andStarScoreBetween(Integer value1, Integer value2) {
            addCriterion("star_score between", value1, value2, "starScore");
            return (Criteria) this;
        }

        public Criteria andStarScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("star_score not between", value1, value2, "starScore");
            return (Criteria) this;
        }

        public Criteria andStarTimeIsNull() {
            addCriterion("star_time is null");
            return (Criteria) this;
        }

        public Criteria andStarTimeIsNotNull() {
            addCriterion("star_time is not null");
            return (Criteria) this;
        }

        public Criteria andStarTimeEqualTo(Date value) {
            addCriterion("star_time =", value, "starTime");
            return (Criteria) this;
        }

        public Criteria andStarTimeNotEqualTo(Date value) {
            addCriterion("star_time <>", value, "starTime");
            return (Criteria) this;
        }

        public Criteria andStarTimeGreaterThan(Date value) {
            addCriterion("star_time >", value, "starTime");
            return (Criteria) this;
        }

        public Criteria andStarTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("star_time >=", value, "starTime");
            return (Criteria) this;
        }

        public Criteria andStarTimeLessThan(Date value) {
            addCriterion("star_time <", value, "starTime");
            return (Criteria) this;
        }

        public Criteria andStarTimeLessThanOrEqualTo(Date value) {
            addCriterion("star_time <=", value, "starTime");
            return (Criteria) this;
        }

        public Criteria andStarTimeIn(List<Date> values) {
            addCriterion("star_time in", values, "starTime");
            return (Criteria) this;
        }

        public Criteria andStarTimeNotIn(List<Date> values) {
            addCriterion("star_time not in", values, "starTime");
            return (Criteria) this;
        }

        public Criteria andStarTimeBetween(Date value1, Date value2) {
            addCriterion("star_time between", value1, value2, "starTime");
            return (Criteria) this;
        }

        public Criteria andStarTimeNotBetween(Date value1, Date value2) {
            addCriterion("star_time not between", value1, value2, "starTime");
            return (Criteria) this;
        }

        public Criteria andDeviceInfoIsNull() {
            addCriterion("device_info is null");
            return (Criteria) this;
        }

        public Criteria andDeviceInfoIsNotNull() {
            addCriterion("device_info is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceInfoEqualTo(String value) {
            addCriterion("device_info =", value, "deviceInfo");
            return (Criteria) this;
        }

        public Criteria andDeviceInfoNotEqualTo(String value) {
            addCriterion("device_info <>", value, "deviceInfo");
            return (Criteria) this;
        }

        public Criteria andDeviceInfoGreaterThan(String value) {
            addCriterion("device_info >", value, "deviceInfo");
            return (Criteria) this;
        }

        public Criteria andDeviceInfoGreaterThanOrEqualTo(String value) {
            addCriterion("device_info >=", value, "deviceInfo");
            return (Criteria) this;
        }

        public Criteria andDeviceInfoLessThan(String value) {
            addCriterion("device_info <", value, "deviceInfo");
            return (Criteria) this;
        }

        public Criteria andDeviceInfoLessThanOrEqualTo(String value) {
            addCriterion("device_info <=", value, "deviceInfo");
            return (Criteria) this;
        }

        public Criteria andDeviceInfoLike(String value) {
            addCriterion("device_info like", value, "deviceInfo");
            return (Criteria) this;
        }

        public Criteria andDeviceInfoNotLike(String value) {
            addCriterion("device_info not like", value, "deviceInfo");
            return (Criteria) this;
        }

        public Criteria andDeviceInfoIn(List<String> values) {
            addCriterion("device_info in", values, "deviceInfo");
            return (Criteria) this;
        }

        public Criteria andDeviceInfoNotIn(List<String> values) {
            addCriterion("device_info not in", values, "deviceInfo");
            return (Criteria) this;
        }

        public Criteria andDeviceInfoBetween(String value1, String value2) {
            addCriterion("device_info between", value1, value2, "deviceInfo");
            return (Criteria) this;
        }

        public Criteria andDeviceInfoNotBetween(String value1, String value2) {
            addCriterion("device_info not between", value1, value2, "deviceInfo");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}