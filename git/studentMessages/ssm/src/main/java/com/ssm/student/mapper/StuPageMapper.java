package com.ssm.student.mapper;

import com.ssm.student.entity.StuEntity;
import com.ssm.student.entity.StudentEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by chensui on 2017/3/18.
 */
public interface StuPageMapper {

    /**
     * 查询学生表中的记录数
     * @return
     */
    public Integer queryStudentCount(@Param("majorId") Integer majorId,
                                     @Param("gradeId") Integer gradeId,
                                     @Param("sexId") Integer sexId,
                                     @Param("nationId") Integer nationId,
                                     @Param("nativePlaceId") Integer nativePlaceId,
                                     @Param("politicsStatusId") Integer politicsStatusId);

    /**
     * 删除单个学生资料
     * @param studentId
     * @return
     */
    public void deleteOneStudent(@Param("studentId")Integer  studentId);

    /**
     * 删除批量学生资料
     * @param studentId
     * @return
     */
    public void deleteBatchStu(@Param("studentId")List  studentId);



    /**
     * 更新学生数据
     * @return
     */
    public void updateStuData(@Param("studentEntity")StudentEntity studentEntity);

    /**
     * 查询从offset开始的pageSize条学生记录
     * @param offset
     * @param pageSize
     * @return
     */
    public List<StuEntity> queryStuPage(@Param("offset")Integer offset,@Param("pageSize") Integer pageSize,
                                        @Param("majorId") Integer majorId,
                                        @Param("gradeId") Integer gradeId,
                                        @Param("sexId") Integer sexId,
                                        @Param("nationId") Integer nationId,
                                        @Param("nativePlaceId") Integer nativePlaceId,
                                        @Param("politicsStatusId") Integer politicsStatusId,
                                        @Param("flag")Integer flag
    );



}
