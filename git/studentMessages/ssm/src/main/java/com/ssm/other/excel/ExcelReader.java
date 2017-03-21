package com.ssm.other.excel;

import com.ssm.student.entity.StuIdEntity;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 读取excel文件的数据
 */
public class ExcelReader {

    public static List<StuIdEntity> readExcel(CommonsMultipartFile file){

        List<StuIdEntity> stuIdEntities=new ArrayList<StuIdEntity>();

        InputStream is = null;
        try
        {
            /** 判断文件的类型，是2003还是2007 */

            boolean isExcel2003 = true;

            if (ExcelUtil.isExcel2007(file.getOriginalFilename()))
            {

                isExcel2003 = false;

            }

            /** 调用本类提供的根据流读取的方法 */

            is = file.getInputStream();

            stuIdEntities = read(is, isExcel2003);

            is.close();

        }
        catch (Exception ex)
        {

            ex.printStackTrace();

        }
        finally
        {

            if (is != null)
            {

                try
                {

                    is.close();

                }
                catch (IOException e)
                {

                    is = null;

                    e.printStackTrace();

                }

            }

        }

        /** 返回最后读取的结果 */

        return stuIdEntities;
    }


    /**
     *
     * @描述：根据流读取Excel文件
     *
     * @参数：@param inputStream
     *
     * @参数：@param isExcel2003
     *
     * @参数：@return
     *
     * @返回值：List
     */

    public static List<StuIdEntity> read(InputStream inputStream, boolean isExcel2003)
    {

        List<StuIdEntity> stuIdEntities = null;

        try
        {

            /** 根据版本选择创建Workbook的方式 */

            Workbook wb = null;

            if (isExcel2003)
            {
                wb = new HSSFWorkbook(inputStream);
            }
            else
            {
                wb = new XSSFWorkbook(inputStream);
            }
            stuIdEntities = read(wb);

        }
        catch (IOException e)
        {

            e.printStackTrace();

        }

        return stuIdEntities;

    }


    /**
     *
     * @描述：读取数据
     *
     *
     * @参数：@param Workbook
     *
     * @参数：@return
     *
     * @返回值：List<List<String>>
     */

    private static List<StuIdEntity> read(Workbook wb)
    {

        List<StuIdEntity> stuIdEntitys = new ArrayList<StuIdEntity>();

        /** 得到第一个shell */
        Sheet sheet = wb.getSheetAt(0);

        /** 得到Excel的行数 */
        int totalRows = sheet.getPhysicalNumberOfRows();

        Row row0 = sheet.getRow(1);
        //获取年级id
        Cell cell1 = row0.getCell(1);
        Integer gradeId = Double.valueOf(cell1.getNumericCellValue()).intValue();
        //获取班级id
        Cell cell3 = row0.getCell(3);
        Integer majorId = Double.valueOf(cell3.getNumericCellValue()).intValue();



        /** 循环Excel的行 */

        for (int r = 3; r < 17; r++)
        {
            Row row = sheet.getRow(r);
            if (row == null)
            {
                continue;
            }

            StuIdEntity stuIdentity=new StuIdEntity();
            //设置学号
            stuIdentity.setStudentId(Double.valueOf(row.getCell(0).getNumericCellValue()).intValue());
            //设置姓名
            stuIdentity.setStudentName(row.getCell(1).getStringCellValue());
            //设置住址
            stuIdentity.setAddress(row.getCell(2).getStringCellValue());
            //设置出生日期
            stuIdentity.setBirth(row.getCell(3).getStringCellValue());
            //设置身份证号
            stuIdentity.setIdentityCard(row.getCell(4).getStringCellValue());
            //设置邮箱
            stuIdentity.setEmail(row.getCell(5).getStringCellValue());
            //性别
            stuIdentity.setSexId(Double.valueOf(row.getCell(6).getNumericCellValue()).intValue());
            //民族
            stuIdentity.setNationId(Double.valueOf(row.getCell(7).getNumericCellValue()).intValue());
            //政治面貌
            stuIdentity.setPoliticsStatusId(Double.valueOf(row.getCell(8).getNumericCellValue()).intValue());
            //籍贯
            stuIdentity.setNativePlaceId(Double.valueOf(row.getCell(9).getNumericCellValue()).intValue());
            //年级
            stuIdentity.setGradeId(gradeId);
            //专业
            stuIdentity.setMajorId(majorId);
            /** 保存第r行的第c列 */

        stuIdEntitys.add(stuIdentity);
        }
        return stuIdEntitys;
    }
}
