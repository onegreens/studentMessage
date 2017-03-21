package com.ssm.student.service.impl;

import com.ssm.other.entity.*;
import com.ssm.other.page.Page;
import com.ssm.student.entity.StudentEntity;
import com.ssm.student.mapper.StuPageMapper;
import com.ssm.student.mapper.StudentMapper;
import com.ssm.student.service.StuPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chensui on 2017/3/16.
 */
@Service
public class StuPageServiceImpl implements StuPageService {

    @Autowired
    private StuPageMapper stuPageMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Page queryStuPage(Page page,Integer majorId,
                             Integer gradeId,
                             Integer sexId,
                             Integer nationId,
                             Integer nativePlaceId,
                             Integer politicsStatusId,
                             Integer flag)
    {
        page.setRowCount(stuPageMapper.queryStudentCount(majorId,gradeId,sexId,nationId,
                nativePlaceId,politicsStatusId));
        if (page.getPageSize() == 0) {
            Page.init(page);
        }
        page.setList(null);
        page.setList(stuPageMapper.queryStuPage(page.getOffset(),page.getPageSize(),majorId,
                 gradeId,sexId,nationId,
                nativePlaceId,politicsStatusId,flag));
        return page;
    }

    @Override
    public StudentEntity queryOneStudent(Integer studentId) {
        return studentMapper.queryOneStudent(studentId);
    }

    @Override
    public void deleteOneStudent(Integer studentId) {
        stuPageMapper.deleteOneStudent(studentId);
    }

    @Override
    public void deleteBatchStu(List studentId) {
        stuPageMapper.deleteBatchStu(studentId);
    }

    @Override
    public StudentEntity updateOneStudent(StudentEntity studentEntity, SexEntity sex, NationEntity nation, NativePlaceEntity nativePlace, PoliticsStatusEntity politicsStatus, GradeEntity grade, MajorEntity major) {
        studentEntity.setSexEntity(sex);
        studentEntity.setNationEntity(nation);
        studentEntity.setNativePlaceEntity(nativePlace);
        studentEntity.setPoliticsStatusEntity(politicsStatus);
        studentEntity.setGradeEntity(grade);
        studentEntity.setMajorEntity(major);
        stuPageMapper.updateStuData(studentEntity);
        return studentMapper.queryOneStudent(studentEntity.getStudentId());
    }

    @Override
    public List<StudentEntity> queryOneStuByName(String studentName) {
        return studentMapper.queryOneStuByName(studentName);
    }
}
