package com.ohgiraffers.section02.preparedstatement;

import com.ohgiraffers.model.dto.EmployeeDTO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application05 {
    public static void main(String[] args) {

        Connection con = getConnection();

        PreparedStatement pstmt = null;

        ResultSet rest = null;

        // 1명의 회원정보를 관리 할 Employee DTO 사용

        EmployeeDTO emp = null;

        List<EmployeeDTO> empList = null;

        Scanner sc = new Scanner(System.in);
        System.out.print("조회하실 성을 입력 해주세요 : ");
        String empName = sc.nextLine();

        // 프로퍼티 파일에 SQL 작성
        Properties prop = new Properties();

        try { // createStatement 가 예외처리를 강제화 되었기 때문에 try/catch 로 감싸줌.
            
            prop.loadFromXML(
                    new FileInputStream("src/main/java/com/ohgiraffers/section02/preparedstatement/employee-query.xml")
            );
            
            String query = prop.getProperty("selectByFamilyName");
            System.out.println("query = " + query);
            
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, empName);

            rest = pstmt.executeQuery(query);

            empList = new ArrayList<>(); // 일단, 제네릭 형태의 인스턴스 생성

            // 조회한 결과를 객체에 담기
            while (rest.next()) { // if 문에서 while 반복문으로 변경.
                emp = new EmployeeDTO();
                // emp_id 라는 값을 가져와서 으로 셋!팅!을 해줌.
                emp.setEmpId(rest.getString("EMP_ID"));
                emp.setEmpName(rest.getString("EMP_NAME"));
                emp.setEmpNo(rest.getString("EMP_NO"));
                emp.setEmpEmail(rest.getString("EMAIL"));
                emp.setEmpPhone(rest.getString("PHONE"));
                emp.setEmpDeptCode(rest.getString("DEPT_CODE"));
                emp.setEmpJopCode(rest.getString("JOB_CODE"));
                emp.setEmpSalLevel(rest.getString("SAL_LEVEL"));
                emp.setEmpSalary(rest.getInt("SALARY"));
                emp.setEmpBonus(rest.getDouble("BONUS"));
                emp.setEmpManagerId(rest.getString("MANAGER_ID"));
                emp.setEmpHireDate(rest.getDate("HIRE_DATE"));
                emp.setEmpEntDate(rest.getDate("ENT_DATE"));
                emp.setEmpEntYn(rest.getString("ENT_YN"));

                // 여러개를 담아줘야 하기 때문에, add 로 담고 보내고 담고 보내고~
                empList.add(emp); // 반복시켜~
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InvalidPropertiesFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            close(rest);
            close(pstmt);
            close(con);
        }

        for (EmployeeDTO empDTO : empList) {
            System.out.println("EmpDTO = " + empDTO);
        } // 향상된 포~문~

    }
}
