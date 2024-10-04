package com.ohgiraffers.section02.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application02 {
    public static void main(String[] args) {

        /* 필기
        *   ? = Placeholder
        *   ? 부분에서만 동적으로 변경해줌. 시작값 ( 1 ) */

        Connection con = getConnection();

        PreparedStatement pstmt = null;

        ResultSet rest = null;

        Scanner sc = new Scanner(System.in);
        System.out.print("조회하실 사번을 입력해주세요 : ");
        String empId = sc.nextLine();

        String query = "SELECT EMP_ID, EMP_NAME FROM EMPLOYEE WHERE EMP_ID = ?";

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, empId);

            rest = pstmt.executeQuery();

            if (rest.next()) { // 어짜피 결과는 1개니까~
                System.out.println(rest.getString("EMP_ID") + " / " + rest.getString("EMP_NAME"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
            close(con);
            close(rest);
        }

    }
}
