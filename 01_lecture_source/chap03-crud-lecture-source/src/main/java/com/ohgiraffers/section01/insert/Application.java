package com.ohgiraffers.section01.insert;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application {
    public static void main(String[] args) {

        /* MENU DB 활용 */

        Connection con = getConnection();

        PreparedStatement pstmt = null;

        // ResultSet 대신 int 형의 자료형 만들어둠.
        // 이제 ResultSet 은 조회 = select 임.
        int result = 0;

        Properties prop = new Properties();

        try {
            prop.loadFromXML(
                    new FileInputStream("src/main/java/com/ohgiraffers/mapper/menu-query.xml")
            );

            String query = prop.getProperty("insertMenu");
            System.out.println("query = " + query);

            Scanner sc = new Scanner(System.in);
            System.out.print("신규 메뉴 이름 입력 : ");
            String menuName = sc.nextLine();
            System.out.print("신규 메뉴 가격 입력 : ");
            int menuPrice = sc.nextInt();
            System.out.print("신규 메뉴 종류 입력 : ");
            int menuCategoryCode = sc.nextInt();
            System.out.print("판매여부(Y/N) 입력 : ");
            sc.nextLine();
            String menuOrderAbleStatus = sc.nextLine().toUpperCase();

            pstmt = con.prepareStatement(query);
            pstmt.setString(1, menuName);
            pstmt.setInt(2,  menuPrice);
            pstmt.setInt(3,  menuCategoryCode);
            pstmt.setString(4, menuOrderAbleStatus);

            result = pstmt.executeUpdate(); // 반환형이 int 임.

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(con);
            close(pstmt);
        }

        System.out.println("result = " + result);

        if (result > 0) {
            System.out.println("메뉴 등록 성공 ~ ");
        } else {
            System.out.println("오류가 발생했습니다.");
        }
    }
}
