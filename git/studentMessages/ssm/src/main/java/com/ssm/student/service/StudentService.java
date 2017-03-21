package com.ssm.student.service;

import com.ssm.other.entity.*;
import com.ssm.student.entity.StuIdEntity;
import com.ssm.student.entity.StudentEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chensui on 2017/3/16.
 */
@Service
public interface StudentService {
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
     * 添加学生资料
     * @return
     */
    public StudentEntity addOneStudent(
            StudentEntity studentEntity,
            SexEntity sex,NationEntity nation,NativePlaceEntity nativePlace,
            PoliticsStatusEntity politicsStatus,GradeEntity grade,
            MajorEntity major
    );

    /**
     * 批量添加学生资料
     * @param stuIdEntityList
     * @return
     */
    public  List<StudentEntity> addBatchStuData(List<StuIdEntity> stuIdEntityList);




}
