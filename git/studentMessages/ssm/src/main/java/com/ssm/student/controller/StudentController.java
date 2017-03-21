package com.ssm.student.controller;

import com.ssm.login.service.LoginService;
import com.ssm.other.entity.*;
import com.ssm.other.excel.ExcelReader;
import com.ssm.student.entity.StuIdEntity;
import com.ssm.student.entity.StudentEntity;
import com.ssm.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.List;

/**
 * Created by chensui on 2017/3/16.
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private LoginService loginService;

    /**
     * 从数据库调用选项资料，传至添加页面
     * @param modelMap
     * @return
     */
    @RequestMapping("/toAddOneStuData")
    public String toAddOneStuData(ModelMap modelMap){
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
        return  "/back/student/toAddOneStuData";
    }

    /**
     * 添加一个学生资料
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
    @RequestMapping("/addOneStuData")
    public String addOneStuData(
            MajorEntity major, GradeEntity grade, StudentEntity student,
            SexEntity sex,NationEntity nation,NativePlaceEntity nativePlace,
            PoliticsStatusEntity politicsStatus,
            ModelMap modelMap
            ){
        StudentEntity studentEntity=studentService.addOneStudent(student,sex,nation,nativePlace
                ,politicsStatus,grade,major);
        modelMap.addAttribute("studentEntity",studentEntity);
        return  "/back/student/oneStuData";
    }

    /**
     * 转至读取学生资料文件页面
     * @return
     */
    @RequestMapping("/toAddBatchStuData")
    public  String toAddBatchStuData(){
        return "/back/student/toAddBatchStuData";
    }

    /**
     * 将资料文件中的数据读取，并转至结果显示页面
     * @return
     */
    @RequestMapping(value = "/addBatchStuData",method = RequestMethod.POST)
    public  String addBatchStuData(@RequestParam("file")CommonsMultipartFile file,ModelMap modelMap){
        List<StuIdEntity> stuIdEntities= ExcelReader.readExcel(file);
        List<StudentEntity> studentEntityList =studentService.addBatchStuData(stuIdEntities);
        modelMap.addAttribute("studentEntityList",studentEntityList);
        return "/back/student/readBatchStuData";
    }





}
