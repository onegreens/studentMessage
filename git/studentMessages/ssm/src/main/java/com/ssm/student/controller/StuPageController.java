package com.ssm.student.controller;

import com.ssm.other.entity.*;
import com.ssm.other.page.Page;
import com.ssm.student.entity.StudentEntity;
import com.ssm.student.service.StuPageService;
import com.ssm.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 分页
 */
@Controller
@RequestMapping("/student")
public class StuPageController {

    @Autowired
    private StuPageService stuPageService;
    @Autowired
    private StudentService studentService;


    /**
     * 批量查询学生资料
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/QueryBatchStuByData")
    public  String QueryBatchStuByData(
            Integer majorId,
            Integer gradeId,
            Integer sexId,
            Integer nationId,
            Integer nativePlaceId,
            Integer politicsStatusId,
            Integer flag,
            Page page,ModelMap modelMap){
        if(flag == null)
        {flag = 2; }
        else {flag =1 ;}
        page=stuPageService.queryStuPage(page,majorId,gradeId,sexId,nationId,nativePlaceId,politicsStatusId,flag);

        List<GradeEntity> gradeEntities=studentService.queryGradeList();
        List<MajorEntity> majorEntities=studentService.queryMajorList();
        List<SexEntity> sexEntities=studentService.querySexList();
        List<NationEntity> nationEntities=studentService.queryNationList();
        List<NativePlaceEntity> nativePlaceEntities=studentService.queryNPList();
        List<PoliticsStatusEntity> politicsStatusEntities=studentService.queryPSList();

        modelMap.addAttribute("gradeEntities",gradeEntities);
        modelMap.addAttribute("majorEntities",majorEntities);
        modelMap.addAttribute("sexEntities",sexEntities);
        modelMap.addAttribute("nationEntities",nationEntities);
        modelMap.addAttribute("nativePlaceEntities",nativePlaceEntities);
        modelMap.addAttribute("politicsStatusEntities",politicsStatusEntities);

        modelMap.addAttribute("page",page);
        modelMap.addAttribute("majorId",majorId);
        modelMap.addAttribute("gradeId",gradeId);
        modelMap.addAttribute("nationId",nationId);
        modelMap.addAttribute("sexId",sexId);
        modelMap.addAttribute("flag",flag);
        modelMap.addAttribute("nativePlaceId",nativePlaceId);
        modelMap.addAttribute("politicsStatusId",politicsStatusId);
        return "/back/student/readBatchStuData";
    }

    /**
     * 查询学生资料
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/queryOneStudent")
    public  String queryOneStudent(Integer studentId,ModelMap modelMap){
        StudentEntity studentEntity=stuPageService.queryOneStudent(studentId);
        if(studentEntity == null){
            modelMap.addAttribute("message","该学生不存在！！！");
            return "/back/student/studentResult";
        }else {
            modelMap.addAttribute("studentEntity",studentEntity);
            return "/back/student/oneStuData";
        }
    }

    /**
     * 根据姓名查询学生资料
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/queryOneStuByName")
    public  String queryOneStuByName(String studentName,ModelMap modelMap){
        List<StudentEntity> studentEntityList=stuPageService.queryOneStuByName(studentName);
        if(studentEntityList == null || studentEntityList.size()==0){
            modelMap.addAttribute("message","该姓名的学生不存在！！！");
            return "/back/student/studentResult";
        }else {
            modelMap.addAttribute("studentEntityList",studentEntityList);
            return "/back/student/stuDataByName";
        }
    }



    /**
     * 编辑学生资料
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/editOneStudent")
    public  String editOneStudent(@RequestParam("studentId")Integer studentId,ModelMap modelMap){

        StudentEntity studentEntity=stuPageService.queryOneStudent(studentId);
        List<GradeEntity> gradeEntities=studentService.queryGradeList();
        List<MajorEntity> majorEntities=studentService.queryMajorList();
        List<SexEntity> sexEntities=studentService.querySexList();
        List<NationEntity> nationEntities=studentService.queryNationList();
        List<NativePlaceEntity> nativePlaceEntities=studentService.queryNPList();
        List<PoliticsStatusEntity> politicsStatusEntities=studentService.queryPSList();

        modelMap.addAttribute("gradeEntities",gradeEntities);
        modelMap.addAttribute("majorEntities",majorEntities);
        modelMap.addAttribute("sexEntities",sexEntities);
        modelMap.addAttribute("nationEntities",nationEntities);
        modelMap.addAttribute("nativePlaceEntities",nativePlaceEntities);
        modelMap.addAttribute("politicsStatusEntities",politicsStatusEntities);
        modelMap.addAttribute("studentEntity",studentEntity);
        return "/back/student/editOneStuData";
    }

    /**
     * 修改一个学生资料
     * @param major
     * @param grade
     * @param student
     * @param sex
     * @param nation
     * @param nativePlace
     * @param politicsStatus
     * @param modelMap
     * @return
     */
    @RequestMapping("/updateOneStuData")
    public String updateOneStuData(
            MajorEntity major, GradeEntity grade, StudentEntity student,
            SexEntity sex,NationEntity nation,NativePlaceEntity nativePlace,
            PoliticsStatusEntity politicsStatus,
            ModelMap modelMap
    ){
        StudentEntity studentEntity=stuPageService.updateOneStudent(student,sex,nation,nativePlace
                ,politicsStatus,grade,major);
        modelMap.addAttribute("studentEntity",studentEntity);
        return  "/back/student/oneStuData";
    }


    /**
     * 删除学生资料
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/deleteOneStudent")
    public  String deleteOneStudent(@RequestParam("studentId")Integer studentId,ModelMap modelMap){
        stuPageService.deleteOneStudent(studentId);
        modelMap.addAttribute("message","删除成功!!!");
        return "/back/student/studentResult";
    }


    /**
     * 删除学生资料
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/deleteBatchStu")
    public  String deleteBatchStu(@RequestParam("studentId")List studentId,ModelMap modelMap){
        stuPageService.deleteBatchStu(studentId);
        modelMap.addAttribute("message","批量删除成功!!!");
        return "/back/student/studentResult";
    }







}
