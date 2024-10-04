package com.ohgiraffers.section02.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application01 {
    public static void main(String[] args) {

        /* 필기.
        *   PreparedStatement 는  준비된 Statement 이다.
        *   Statement 는 SQL 쿼리문을 실행할 때마다 SQL 문이
        *   DBMS 에 전송되어 DBMS 에서 SQL 문으로 번역(파싱)하고 컴파일을
        *   하는 과정을 거치게 되는데, PreparedStatement 는 최초에 한번 !
        *   실행했을 때 SQL  문을 파싱하고 컴파일을 하지만
        *   동일한 SQL 구문을 여러번 실행하게 되면 최초에 컴파일한 SQL 구문을 재사용하게 된다.
        *   따라서, 파싱하고 컴파일하는 과정을 생략하게되어 성능이 향상된다. */

        // 연결 통로
        Connection con = getConnection();

        // 쿼리문을 실행할 PreparedStatement
        PreparedStatement pstmt = null;

        // 쿼리문 실행 결과
        ResultSet rest = null;

        String query = "SELECT EMP_ID, EMP_NAME FROM EMPLOYEE";

        try {
            pstmt = con.prepareStatement(query);

            // 실행해줘
            // 결과담아
             rest = pstmt.executeQuery();

             // 반복문으로 출력해줘
             while (rest.next()) {
                 System.out.println(rest.getString("EMP_ID") + " " + rest.getString("EMP_NAME"));
             }
             
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rest);
            close(con);
            close(pstmt);
        }


    }
}
