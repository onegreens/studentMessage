package com.ssm.student.service.impl;

import com.ssm.login.entity.UserEntity;
import com.ssm.login.mapper.UserMapper;
import com.ssm.other.entity.*;
import com.ssm.student.entity.StuIdEntity;
import com.ssm.student.entity.StudentEntity;
import com.ssm.student.mapper.StudentMapper;
import com.ssm.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chensui on 2017/3/16.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<SexEntity> querySexList() {
        return studentMapper.querySexList();
    }

    @Override
    public List<PoliticsStatusEntity> queryPSList() {
        return studentMapper.queryPSList();
    }

    @Override
    public List<NativePlaceEntity> queryNPList() {
        return studentMapper.queryNPList();
    }

    @Override
    public List<NationEntity> queryNationList() {
        return studentMapper.queryNationList();
    }

    @Override
    public List<GradeEntity> queryGradeList() {
        return studentMapper.queryGradeList();
    }

    @Override
    public List<MajorEntity> queryMajorList() {
        return studentMapper.queryMajorList();
    }

    @Override
    public StudentEntity addOneStudent(StudentEntity studentEntity, SexEntity sex, NationEntity nation, NativePlaceEntity nativePlace, PoliticsStatusEntity politicsStatus, GradeEntity grade, MajorEntity major) {
        //赋值
        studentEntity.setSexEntity(sex);
        studentEntity.setNationEntity(nation);
        studentEntity.setNativePlaceEntity(nativePlace);
        studentEntity.setPoliticsStatusEntity(politicsStatus);
        studentEntity.setGradeEntity(grade);
        studentEntity.setMajorEntity(major);

        //获取对应的id
        Integer s=studentMapper.addOneStudent(studentEntity);
        Integer studentId=studentEntity.getStudentId();
        //创建对应的用户
        UserEntity userEntity=new UserEntity();
        //密码和账号全部为学生的身份证号
        userEntity.setAccount(studentId.toString());
        userEntity.setPassword(studentEntity.getIdentityCard());
        userEntity.setEmail(studentEntity.getEmail());
        //获取用户ID
        Integer u= userMapper.addUser(userEntity);
        Integer userId=userEntity.getUserEntityId();

        //建立用户和角色的关系
        userMapper.addUserRoleStu(userId,2);
        //将该学生赋予用户
        studentMapper.addUserStu(studentId,userId);
        return studentMapper.queryOneStudent(studentId);
    }

    @Override
    public  List<StudentEntity> addBatchStuData(List<StuIdEntity> stuIdEntityList) {
        List<Integer> studentIdList=new ArrayList<Integer>();
        for(int i=0;i<stuIdEntityList.size();i++){
            StuIdEntity stuIdEntity=stuIdEntityList.get(i);
            //添加用户
            UserEntity userEntity=new UserEntity();
            //密码和账号全部为学生的身份证号
            userEntity.setAccount(stuIdEntity.getStudentId().toString());
            userEntity.setPassword(stuIdEntity.getIdentityCard());
            userEntity.setEmail(stuIdEntity.getEmail());
            //获取用户ID
            Integer userId= userMapper.addUser(userEntity);
            stuIdEntityList.get(i).setUserId(userEntity.getUserEntityId());
            studentIdList.add(stuIdEntity.getStudentId());
        }
        studentMapper.addBatchStuData(stuIdEntityList);

        List<StudentEntity> studentEntityList=new ArrayList<StudentEntity>();

        for(int i=0;i<studentIdList.size();i++){
            StudentEntity studentEntity=studentMapper.queryOneStudent(studentIdList.get(i));
            studentEntityList.add(studentEntity);
        }
        return studentEntityList;
    }



}
