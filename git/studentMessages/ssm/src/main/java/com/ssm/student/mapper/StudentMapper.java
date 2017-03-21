package com.ssm.student.mapper;

import com.ssm.other.entity.*;
import com.ssm.student.entity.StuIdEntity;
import com.ssm.student.entity.StudentEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by chensui on 2017/3/16.
 */
public interface StudentMapper {
    /**
     * 查询所有的性别
     * @return
     */
    public List<SexEntity> querySexList();

    /**
     * 查询所有的政治面貌
     * @return
     */
    public List<PoliticsStatusEntity> queryPSList();

    /**
     * 查询所有的籍贯
     * @return
     */
    public List<NativePlaceEntity> queryNPList();

    /**
     * 查询所有的民族
     * @return
     */
    public List<NationEntity> queryNationList();

    /**
     * 查询所有年级
     * @return
     */
    public List<GradeEntity> queryGradeList();

    /**
     * 查询所有专业
     * @return
     */
    public List<MajorEntity> queryMajorList();

    /**
     * 添加单个学生资料
     * @param studentEntity
     * @return
     */
    public int addOneStudent(
            @Param("studentEntity")StudentEntity  studentEntity
    );

    /**
     * 查询单个学生资料
     * @param studentId
     * @return
     */
    public StudentEntity queryOneStudent(
            @Param("studentId")Integer  studentId
           );

    public void addUserStu(@Param("studentId")Integer  studentId,@Param("userId")Integer  userId);

    /**
     * 批量插入学生资料
     * @param stuIdEntityList
     * @return
     */
    public Integer addBatchStuData(@Param("stuIdEntityList")List<StuIdEntity> stuIdEntityList);

    /**
     * 根据名称查询单个学生资料
     * @param studentName
     * @return
     */
    public List<StudentEntity> queryOneStuByName(
            @Param("studentName")String  studentName
    );

}
