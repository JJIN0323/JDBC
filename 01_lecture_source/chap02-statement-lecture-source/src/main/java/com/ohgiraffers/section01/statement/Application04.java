package com.ohgiraffers.section01.statement;

import com.ohgiraffers.model.dto.EmployeeDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application04 {
    public static void main(String[] args) {

        /* 수업목표. 사원의 테이블의 전체 사원정보를
                         EmployeeDTO 를 통해 객체에 담아서 출력. */

        /* 1. Connection 말그대로 통로를 만든다 */

        Connection con = getConnection();

        /* 2. 어플리케이션에서 쿼리문을 실행시킬 Statement 를 만든다. */

        Statement stmt = null;

        /* 3. 결과를 담을 ResultSet 을 만든다 */

        ResultSet rest = null;

        /* 4. Dto 를 불러온다. 1번 실행 ▶ 2번 실행을 계속 반복한다 */

        // 1. 회원 한명의 정보를 담을 DTO
        EmployeeDTO emp = null; // 나중에 데이터 넣을거임.

        // 2. 회원 여러명의 정보를 담을 DOT ( 하나의 인스턴스로 묶음 )
        List<EmployeeDTO> empList = null;

        String query = "SELECT * FROM EMPLOYEE"; // where 조건절 없음.

        try { // createStatement 가 예외처리를 강제화 되었기 때문에 try/catch 로 감싸줌.
            stmt = con.createStatement();
            rest = stmt.executeQuery(query);

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
        } finally {
            close(rest);
            close(stmt);
            close(con);
        }
        
        for (EmployeeDTO Emp : empList) {
            System.out.println("Emp = " + Emp);
        } // 향상된 포~문~

        // System.out.println("emp = " + emp);

    }
}
