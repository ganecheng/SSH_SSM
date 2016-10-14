package com.jpkc.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CourseInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CourseInfoExample() {
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

        public Criteria andVideoMp4IsNull() {
            addCriterion("video_mp4 is null");
            return (Criteria) this;
        }

        public Criteria andVideoMp4IsNotNull() {
            addCriterion("video_mp4 is not null");
            return (Criteria) this;
        }

        public Criteria andVideoMp4EqualTo(String value) {
            addCriterion("video_mp4 =", value, "videoMp4");
            return (Criteria) this;
        }

        public Criteria andVideoMp4NotEqualTo(String value) {
            addCriterion("video_mp4 <>", value, "videoMp4");
            return (Criteria) this;
        }

        public Criteria andVideoMp4GreaterThan(String value) {
            addCriterion("video_mp4 >", value, "videoMp4");
            return (Criteria) this;
        }

        public Criteria andVideoMp4GreaterThanOrEqualTo(String value) {
            addCriterion("video_mp4 >=", value, "videoMp4");
            return (Criteria) this;
        }

        public Criteria andVideoMp4LessThan(String value) {
            addCriterion("video_mp4 <", value, "videoMp4");
            return (Criteria) this;
        }

        public Criteria andVideoMp4LessThanOrEqualTo(String value) {
            addCriterion("video_mp4 <=", value, "videoMp4");
            return (Criteria) this;
        }

        public Criteria andVideoMp4Like(String value) {
            addCriterion("video_mp4 like", value, "videoMp4");
            return (Criteria) this;
        }

        public Criteria andVideoMp4NotLike(String value) {
            addCriterion("video_mp4 not like", value, "videoMp4");
            return (Criteria) this;
        }

        public Criteria andVideoMp4In(List<String> values) {
            addCriterion("video_mp4 in", values, "videoMp4");
            return (Criteria) this;
        }

        public Criteria andVideoMp4NotIn(List<String> values) {
            addCriterion("video_mp4 not in", values, "videoMp4");
            return (Criteria) this;
        }

        public Criteria andVideoMp4Between(String value1, String value2) {
            addCriterion("video_mp4 between", value1, value2, "videoMp4");
            return (Criteria) this;
        }

        public Criteria andVideoMp4NotBetween(String value1, String value2) {
            addCriterion("video_mp4 not between", value1, value2, "videoMp4");
            return (Criteria) this;
        }

        public Criteria andVideoFlvIsNull() {
            addCriterion("video_flv is null");
            return (Criteria) this;
        }

        public Criteria andVideoFlvIsNotNull() {
            addCriterion("video_flv is not null");
            return (Criteria) this;
        }

        public Criteria andVideoFlvEqualTo(String value) {
            addCriterion("video_flv =", value, "videoFlv");
            return (Criteria) this;
        }

        public Criteria andVideoFlvNotEqualTo(String value) {
            addCriterion("video_flv <>", value, "videoFlv");
            return (Criteria) this;
        }

        public Criteria andVideoFlvGreaterThan(String value) {
            addCriterion("video_flv >", value, "videoFlv");
            return (Criteria) this;
        }

        public Criteria andVideoFlvGreaterThanOrEqualTo(String value) {
            addCriterion("video_flv >=", value, "videoFlv");
            return (Criteria) this;
        }

        public Criteria andVideoFlvLessThan(String value) {
            addCriterion("video_flv <", value, "videoFlv");
            return (Criteria) this;
        }

        public Criteria andVideoFlvLessThanOrEqualTo(String value) {
            addCriterion("video_flv <=", value, "videoFlv");
            return (Criteria) this;
        }

        public Criteria andVideoFlvLike(String value) {
            addCriterion("video_flv like", value, "videoFlv");
            return (Criteria) this;
        }

        public Criteria andVideoFlvNotLike(String value) {
            addCriterion("video_flv not like", value, "videoFlv");
            return (Criteria) this;
        }

        public Criteria andVideoFlvIn(List<String> values) {
            addCriterion("video_flv in", values, "videoFlv");
            return (Criteria) this;
        }

        public Criteria andVideoFlvNotIn(List<String> values) {
            addCriterion("video_flv not in", values, "videoFlv");
            return (Criteria) this;
        }

        public Criteria andVideoFlvBetween(String value1, String value2) {
            addCriterion("video_flv between", value1, value2, "videoFlv");
            return (Criteria) this;
        }

        public Criteria andVideoFlvNotBetween(String value1, String value2) {
            addCriterion("video_flv not between", value1, value2, "videoFlv");
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

        public Criteria andStarScoreEqualTo(Double value) {
            addCriterion("star_score =", value, "starScore");
            return (Criteria) this;
        }

        public Criteria andStarScoreNotEqualTo(Double value) {
            addCriterion("star_score <>", value, "starScore");
            return (Criteria) this;
        }

        public Criteria andStarScoreGreaterThan(Double value) {
            addCriterion("star_score >", value, "starScore");
            return (Criteria) this;
        }

        public Criteria andStarScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("star_score >=", value, "starScore");
            return (Criteria) this;
        }

        public Criteria andStarScoreLessThan(Double value) {
            addCriterion("star_score <", value, "starScore");
            return (Criteria) this;
        }

        public Criteria andStarScoreLessThanOrEqualTo(Double value) {
            addCriterion("star_score <=", value, "starScore");
            return (Criteria) this;
        }

        public Criteria andStarScoreIn(List<Double> values) {
            addCriterion("star_score in", values, "starScore");
            return (Criteria) this;
        }

        public Criteria andStarScoreNotIn(List<Double> values) {
            addCriterion("star_score not in", values, "starScore");
            return (Criteria) this;
        }

        public Criteria andStarScoreBetween(Double value1, Double value2) {
            addCriterion("star_score between", value1, value2, "starScore");
            return (Criteria) this;
        }

        public Criteria andStarScoreNotBetween(Double value1, Double value2) {
            addCriterion("star_score not between", value1, value2, "starScore");
            return (Criteria) this;
        }

        public Criteria andDoc1IsNull() {
            addCriterion("doc_1 is null");
            return (Criteria) this;
        }

        public Criteria andDoc1IsNotNull() {
            addCriterion("doc_1 is not null");
            return (Criteria) this;
        }

        public Criteria andDoc1EqualTo(String value) {
            addCriterion("doc_1 =", value, "doc1");
            return (Criteria) this;
        }

        public Criteria andDoc1NotEqualTo(String value) {
            addCriterion("doc_1 <>", value, "doc1");
            return (Criteria) this;
        }

        public Criteria andDoc1GreaterThan(String value) {
            addCriterion("doc_1 >", value, "doc1");
            return (Criteria) this;
        }

        public Criteria andDoc1GreaterThanOrEqualTo(String value) {
            addCriterion("doc_1 >=", value, "doc1");
            return (Criteria) this;
        }

        public Criteria andDoc1LessThan(String value) {
            addCriterion("doc_1 <", value, "doc1");
            return (Criteria) this;
        }

        public Criteria andDoc1LessThanOrEqualTo(String value) {
            addCriterion("doc_1 <=", value, "doc1");
            return (Criteria) this;
        }

        public Criteria andDoc1Like(String value) {
            addCriterion("doc_1 like", value, "doc1");
            return (Criteria) this;
        }

        public Criteria andDoc1NotLike(String value) {
            addCriterion("doc_1 not like", value, "doc1");
            return (Criteria) this;
        }

        public Criteria andDoc1In(List<String> values) {
            addCriterion("doc_1 in", values, "doc1");
            return (Criteria) this;
        }

        public Criteria andDoc1NotIn(List<String> values) {
            addCriterion("doc_1 not in", values, "doc1");
            return (Criteria) this;
        }

        public Criteria andDoc1Between(String value1, String value2) {
            addCriterion("doc_1 between", value1, value2, "doc1");
            return (Criteria) this;
        }

        public Criteria andDoc1NotBetween(String value1, String value2) {
            addCriterion("doc_1 not between", value1, value2, "doc1");
            return (Criteria) this;
        }

        public Criteria andDoc2IsNull() {
            addCriterion("doc_2 is null");
            return (Criteria) this;
        }

        public Criteria andDoc2IsNotNull() {
            addCriterion("doc_2 is not null");
            return (Criteria) this;
        }

        public Criteria andDoc2EqualTo(String value) {
            addCriterion("doc_2 =", value, "doc2");
            return (Criteria) this;
        }

        public Criteria andDoc2NotEqualTo(String value) {
            addCriterion("doc_2 <>", value, "doc2");
            return (Criteria) this;
        }

        public Criteria andDoc2GreaterThan(String value) {
            addCriterion("doc_2 >", value, "doc2");
            return (Criteria) this;
        }

        public Criteria andDoc2GreaterThanOrEqualTo(String value) {
            addCriterion("doc_2 >=", value, "doc2");
            return (Criteria) this;
        }

        public Criteria andDoc2LessThan(String value) {
            addCriterion("doc_2 <", value, "doc2");
            return (Criteria) this;
        }

        public Criteria andDoc2LessThanOrEqualTo(String value) {
            addCriterion("doc_2 <=", value, "doc2");
            return (Criteria) this;
        }

        public Criteria andDoc2Like(String value) {
            addCriterion("doc_2 like", value, "doc2");
            return (Criteria) this;
        }

        public Criteria andDoc2NotLike(String value) {
            addCriterion("doc_2 not like", value, "doc2");
            return (Criteria) this;
        }

        public Criteria andDoc2In(List<String> values) {
            addCriterion("doc_2 in", values, "doc2");
            return (Criteria) this;
        }

        public Criteria andDoc2NotIn(List<String> values) {
            addCriterion("doc_2 not in", values, "doc2");
            return (Criteria) this;
        }

        public Criteria andDoc2Between(String value1, String value2) {
            addCriterion("doc_2 between", value1, value2, "doc2");
            return (Criteria) this;
        }

        public Criteria andDoc2NotBetween(String value1, String value2) {
            addCriterion("doc_2 not between", value1, value2, "doc2");
            return (Criteria) this;
        }

        public Criteria andDoc3IsNull() {
            addCriterion("doc_3 is null");
            return (Criteria) this;
        }

        public Criteria andDoc3IsNotNull() {
            addCriterion("doc_3 is not null");
            return (Criteria) this;
        }

        public Criteria andDoc3EqualTo(String value) {
            addCriterion("doc_3 =", value, "doc3");
            return (Criteria) this;
        }

        public Criteria andDoc3NotEqualTo(String value) {
            addCriterion("doc_3 <>", value, "doc3");
            return (Criteria) this;
        }

        public Criteria andDoc3GreaterThan(String value) {
            addCriterion("doc_3 >", value, "doc3");
            return (Criteria) this;
        }

        public Criteria andDoc3GreaterThanOrEqualTo(String value) {
            addCriterion("doc_3 >=", value, "doc3");
            return (Criteria) this;
        }

        public Criteria andDoc3LessThan(String value) {
            addCriterion("doc_3 <", value, "doc3");
            return (Criteria) this;
        }

        public Criteria andDoc3LessThanOrEqualTo(String value) {
            addCriterion("doc_3 <=", value, "doc3");
            return (Criteria) this;
        }

        public Criteria andDoc3Like(String value) {
            addCriterion("doc_3 like", value, "doc3");
            return (Criteria) this;
        }

        public Criteria andDoc3NotLike(String value) {
            addCriterion("doc_3 not like", value, "doc3");
            return (Criteria) this;
        }

        public Criteria andDoc3In(List<String> values) {
            addCriterion("doc_3 in", values, "doc3");
            return (Criteria) this;
        }

        public Criteria andDoc3NotIn(List<String> values) {
            addCriterion("doc_3 not in", values, "doc3");
            return (Criteria) this;
        }

        public Criteria andDoc3Between(String value1, String value2) {
            addCriterion("doc_3 between", value1, value2, "doc3");
            return (Criteria) this;
        }

        public Criteria andDoc3NotBetween(String value1, String value2) {
            addCriterion("doc_3 not between", value1, value2, "doc3");
            return (Criteria) this;
        }

        public Criteria andDoc4IsNull() {
            addCriterion("doc_4 is null");
            return (Criteria) this;
        }

        public Criteria andDoc4IsNotNull() {
            addCriterion("doc_4 is not null");
            return (Criteria) this;
        }

        public Criteria andDoc4EqualTo(String value) {
            addCriterion("doc_4 =", value, "doc4");
            return (Criteria) this;
        }

        public Criteria andDoc4NotEqualTo(String value) {
            addCriterion("doc_4 <>", value, "doc4");
            return (Criteria) this;
        }

        public Criteria andDoc4GreaterThan(String value) {
            addCriterion("doc_4 >", value, "doc4");
            return (Criteria) this;
        }

        public Criteria andDoc4GreaterThanOrEqualTo(String value) {
            addCriterion("doc_4 >=", value, "doc4");
            return (Criteria) this;
        }

        public Criteria andDoc4LessThan(String value) {
            addCriterion("doc_4 <", value, "doc4");
            return (Criteria) this;
        }

        public Criteria andDoc4LessThanOrEqualTo(String value) {
            addCriterion("doc_4 <=", value, "doc4");
            return (Criteria) this;
        }

        public Criteria andDoc4Like(String value) {
            addCriterion("doc_4 like", value, "doc4");
            return (Criteria) this;
        }

        public Criteria andDoc4NotLike(String value) {
            addCriterion("doc_4 not like", value, "doc4");
            return (Criteria) this;
        }

        public Criteria andDoc4In(List<String> values) {
            addCriterion("doc_4 in", values, "doc4");
            return (Criteria) this;
        }

        public Criteria andDoc4NotIn(List<String> values) {
            addCriterion("doc_4 not in", values, "doc4");
            return (Criteria) this;
        }

        public Criteria andDoc4Between(String value1, String value2) {
            addCriterion("doc_4 between", value1, value2, "doc4");
            return (Criteria) this;
        }

        public Criteria andDoc4NotBetween(String value1, String value2) {
            addCriterion("doc_4 not between", value1, value2, "doc4");
            return (Criteria) this;
        }

        public Criteria andDoc5IsNull() {
            addCriterion("doc_5 is null");
            return (Criteria) this;
        }

        public Criteria andDoc5IsNotNull() {
            addCriterion("doc_5 is not null");
            return (Criteria) this;
        }

        public Criteria andDoc5EqualTo(String value) {
            addCriterion("doc_5 =", value, "doc5");
            return (Criteria) this;
        }

        public Criteria andDoc5NotEqualTo(String value) {
            addCriterion("doc_5 <>", value, "doc5");
            return (Criteria) this;
        }

        public Criteria andDoc5GreaterThan(String value) {
            addCriterion("doc_5 >", value, "doc5");
            return (Criteria) this;
        }

        public Criteria andDoc5GreaterThanOrEqualTo(String value) {
            addCriterion("doc_5 >=", value, "doc5");
            return (Criteria) this;
        }

        public Criteria andDoc5LessThan(String value) {
            addCriterion("doc_5 <", value, "doc5");
            return (Criteria) this;
        }

        public Criteria andDoc5LessThanOrEqualTo(String value) {
            addCriterion("doc_5 <=", value, "doc5");
            return (Criteria) this;
        }

        public Criteria andDoc5Like(String value) {
            addCriterion("doc_5 like", value, "doc5");
            return (Criteria) this;
        }

        public Criteria andDoc5NotLike(String value) {
            addCriterion("doc_5 not like", value, "doc5");
            return (Criteria) this;
        }

        public Criteria andDoc5In(List<String> values) {
            addCriterion("doc_5 in", values, "doc5");
            return (Criteria) this;
        }

        public Criteria andDoc5NotIn(List<String> values) {
            addCriterion("doc_5 not in", values, "doc5");
            return (Criteria) this;
        }

        public Criteria andDoc5Between(String value1, String value2) {
            addCriterion("doc_5 between", value1, value2, "doc5");
            return (Criteria) this;
        }

        public Criteria andDoc5NotBetween(String value1, String value2) {
            addCriterion("doc_5 not between", value1, value2, "doc5");
            return (Criteria) this;
        }

        public Criteria andDoc6IsNull() {
            addCriterion("doc_6 is null");
            return (Criteria) this;
        }

        public Criteria andDoc6IsNotNull() {
            addCriterion("doc_6 is not null");
            return (Criteria) this;
        }

        public Criteria andDoc6EqualTo(String value) {
            addCriterion("doc_6 =", value, "doc6");
            return (Criteria) this;
        }

        public Criteria andDoc6NotEqualTo(String value) {
            addCriterion("doc_6 <>", value, "doc6");
            return (Criteria) this;
        }

        public Criteria andDoc6GreaterThan(String value) {
            addCriterion("doc_6 >", value, "doc6");
            return (Criteria) this;
        }

        public Criteria andDoc6GreaterThanOrEqualTo(String value) {
            addCriterion("doc_6 >=", value, "doc6");
            return (Criteria) this;
        }

        public Criteria andDoc6LessThan(String value) {
            addCriterion("doc_6 <", value, "doc6");
            return (Criteria) this;
        }

        public Criteria andDoc6LessThanOrEqualTo(String value) {
            addCriterion("doc_6 <=", value, "doc6");
            return (Criteria) this;
        }

        public Criteria andDoc6Like(String value) {
            addCriterion("doc_6 like", value, "doc6");
            return (Criteria) this;
        }

        public Criteria andDoc6NotLike(String value) {
            addCriterion("doc_6 not like", value, "doc6");
            return (Criteria) this;
        }

        public Criteria andDoc6In(List<String> values) {
            addCriterion("doc_6 in", values, "doc6");
            return (Criteria) this;
        }

        public Criteria andDoc6NotIn(List<String> values) {
            addCriterion("doc_6 not in", values, "doc6");
            return (Criteria) this;
        }

        public Criteria andDoc6Between(String value1, String value2) {
            addCriterion("doc_6 between", value1, value2, "doc6");
            return (Criteria) this;
        }

        public Criteria andDoc6NotBetween(String value1, String value2) {
            addCriterion("doc_6 not between", value1, value2, "doc6");
            return (Criteria) this;
        }

        public Criteria andDoc7IsNull() {
            addCriterion("doc_7 is null");
            return (Criteria) this;
        }

        public Criteria andDoc7IsNotNull() {
            addCriterion("doc_7 is not null");
            return (Criteria) this;
        }

        public Criteria andDoc7EqualTo(String value) {
            addCriterion("doc_7 =", value, "doc7");
            return (Criteria) this;
        }

        public Criteria andDoc7NotEqualTo(String value) {
            addCriterion("doc_7 <>", value, "doc7");
            return (Criteria) this;
        }

        public Criteria andDoc7GreaterThan(String value) {
            addCriterion("doc_7 >", value, "doc7");
            return (Criteria) this;
        }

        public Criteria andDoc7GreaterThanOrEqualTo(String value) {
            addCriterion("doc_7 >=", value, "doc7");
            return (Criteria) this;
        }

        public Criteria andDoc7LessThan(String value) {
            addCriterion("doc_7 <", value, "doc7");
            return (Criteria) this;
        }

        public Criteria andDoc7LessThanOrEqualTo(String value) {
            addCriterion("doc_7 <=", value, "doc7");
            return (Criteria) this;
        }

        public Criteria andDoc7Like(String value) {
            addCriterion("doc_7 like", value, "doc7");
            return (Criteria) this;
        }

        public Criteria andDoc7NotLike(String value) {
            addCriterion("doc_7 not like", value, "doc7");
            return (Criteria) this;
        }

        public Criteria andDoc7In(List<String> values) {
            addCriterion("doc_7 in", values, "doc7");
            return (Criteria) this;
        }

        public Criteria andDoc7NotIn(List<String> values) {
            addCriterion("doc_7 not in", values, "doc7");
            return (Criteria) this;
        }

        public Criteria andDoc7Between(String value1, String value2) {
            addCriterion("doc_7 between", value1, value2, "doc7");
            return (Criteria) this;
        }

        public Criteria andDoc7NotBetween(String value1, String value2) {
            addCriterion("doc_7 not between", value1, value2, "doc7");
            return (Criteria) this;
        }

        public Criteria andDoc8IsNull() {
            addCriterion("doc_8 is null");
            return (Criteria) this;
        }

        public Criteria andDoc8IsNotNull() {
            addCriterion("doc_8 is not null");
            return (Criteria) this;
        }

        public Criteria andDoc8EqualTo(String value) {
            addCriterion("doc_8 =", value, "doc8");
            return (Criteria) this;
        }

        public Criteria andDoc8NotEqualTo(String value) {
            addCriterion("doc_8 <>", value, "doc8");
            return (Criteria) this;
        }

        public Criteria andDoc8GreaterThan(String value) {
            addCriterion("doc_8 >", value, "doc8");
            return (Criteria) this;
        }

        public Criteria andDoc8GreaterThanOrEqualTo(String value) {
            addCriterion("doc_8 >=", value, "doc8");
            return (Criteria) this;
        }

        public Criteria andDoc8LessThan(String value) {
            addCriterion("doc_8 <", value, "doc8");
            return (Criteria) this;
        }

        public Criteria andDoc8LessThanOrEqualTo(String value) {
            addCriterion("doc_8 <=", value, "doc8");
            return (Criteria) this;
        }

        public Criteria andDoc8Like(String value) {
            addCriterion("doc_8 like", value, "doc8");
            return (Criteria) this;
        }

        public Criteria andDoc8NotLike(String value) {
            addCriterion("doc_8 not like", value, "doc8");
            return (Criteria) this;
        }

        public Criteria andDoc8In(List<String> values) {
            addCriterion("doc_8 in", values, "doc8");
            return (Criteria) this;
        }

        public Criteria andDoc8NotIn(List<String> values) {
            addCriterion("doc_8 not in", values, "doc8");
            return (Criteria) this;
        }

        public Criteria andDoc8Between(String value1, String value2) {
            addCriterion("doc_8 between", value1, value2, "doc8");
            return (Criteria) this;
        }

        public Criteria andDoc8NotBetween(String value1, String value2) {
            addCriterion("doc_8 not between", value1, value2, "doc8");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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