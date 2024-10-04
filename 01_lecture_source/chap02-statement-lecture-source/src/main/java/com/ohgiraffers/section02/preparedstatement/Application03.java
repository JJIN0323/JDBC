package com.ohgiraffers.section02.preparedstatement;

import com.ohgiraffers.model.dto.EmployeeDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application03 {
    public static void main(String[] args) {

        Connection con = getConnection();

        PreparedStatement pstmt = null;

        ResultSet rest = null;

        // 1명의 회원정보를 관리 할 Employee DTO 사용

        EmployeeDTO emp = null;

        Scanner sc = new Scanner(System.in);
        System.out.print("조회하실 사번을 입력 해주세요 : ");
        String empId = sc.nextLine();

        String query = "SELECT * FROM EMPLOYEE WHERE EMP_ID = ?";

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, empId);

            rest = pstmt.executeQuery();

            if(rest.next()) {
                emp = new EmployeeDTO();
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
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
            close(rest);
            close(con);
        }
        System.out.println("emp" + emp);
    }
}
