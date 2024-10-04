package com.ohgiraffers.section01.statement;

import com.ohgiraffers.model.dto.EmployeeDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application03 {
    public static void main(String[] args) {

        /* 수업목표. Scanner 사용해서 사번을 입력받고,
        *               해당 사번의 사원정보를 EmployeeDTO 를 통해 객체에 담아서 출력. */

        /* 1. Connection 을 만든다 */

        Connection con = getConnection();

        /* 2. Statement 를 만든다. */

        Statement stmt = null;

        /* 3. 결과를 담을 ResultSet 을 만든다 */

        ResultSet rst = null;

        /* 4. Dto 를 불러온다. (일단은 null 값으로) */

        EmployeeDTO emp = null; // 나중에 데이터 넣을거임.

        Scanner sc = new Scanner(System.in);
        System.out.print("조회하실 사번을 입력하세요 = ");
        String empId = sc.nextLine();

        String query = "SELECT * FROM EMPLOYEE WHERE EMP_ID = '" + empId + "'";

        try { // createStatement 가 예외처리를 강제화 되었기 때문에 try/catch 로 감싸줌.
            stmt = con.createStatement();
            rst = stmt.executeQuery(query);

            // 조회한 결과를 객체에 담기
            if (rst.next()) {
                emp = new EmployeeDTO();
                // emp_id 라는 값을 가져와서 으로 셋!팅!을 해줌.
                emp.setEmpId(rst.getString("EMP_ID"));
                emp.setEmpName(rst.getString("EMP_NAME"));
                emp.setEmpNo(rst.getString("EMP_NO"));
                emp.setEmpEmail(rst.getString("EMAIL"));
                emp.setEmpPhone(rst.getString("PHONE"));
                emp.setEmpDeptCode(rst.getString("DEPT_CODE"));
                emp.setEmpJopCode(rst.getString("JOB_CODE"));
                emp.setEmpSalLevel(rst.getString("SAL_LEVEL"));
                emp.setEmpSalary(rst.getInt("SALARY"));
                emp.setEmpBonus(rst.getDouble("BONUS"));
                emp.setEmpManagerId(rst.getString("MANAGER_ID"));
                emp.setEmpHireDate(rst.getDate("HIRE_DATE"));
                emp.setEmpEntDate(rst.getDate("ENT_DATE"));
                emp.setEmpEntYn(rst.getString("ENT_YN"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rst);
            close(stmt);
            close(con);
        }

        System.out.println("emp = " + emp);
        
    }
}
