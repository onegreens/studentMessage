package com.ssm.student.service;

import com.ssm.other.entity.*;
import com.ssm.other.page.Page;
import com.ssm.student.entity.StudentEntity;

import java.util.List;

/**
 * Created by chensui on 2017/3/18.
 */
public interface StuPageService {

    /**
     * 查询从offset开始的pageSize条学生记录
     * @param
     * @return
     */
    public Page queryStuPage(Page page,
                            Integer majorId,
                            Integer gradeId,
                            Integer sexId,
                            Integer nationId,
                            Integer nativePlaceId,
                            Integer politicsStatusId,
                            Integer flag);

    /**
     * 查询单个学生资料
     * @param studentId
     * @return
     */
    public StudentEntity queryOneStudent(
           Integer  studentId
    );

    /**
     * 查询单个学生资料
     * @param studentId
     * @return
     */
    public void deleteOneStudent(Integer  studentId);


    /**
     * 删除批量学生资料
     * @param studentId
     * @return
     */
    public void deleteBatchStu(List  studentId);


    /**
     * 更新学生资料
     * @return
     */
    public StudentEntity updateOneStudent(
            StudentEntity studentEntity,
            SexEntity sex,NationEntity nation,NativePlaceEntity nativePlace,
            PoliticsStatusEntity politicsStatus,GradeEntity grade,
            MajorEntity major
    );

    /**
     * 根据名称查询单个学生资料
     * @param studentName
     * @return
     */
    public List<StudentEntity> queryOneStuByName(String studentName);


}
