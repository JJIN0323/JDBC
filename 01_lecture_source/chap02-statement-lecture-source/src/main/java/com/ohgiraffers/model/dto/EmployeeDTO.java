package com.ohgiraffers.model.dto;

import java.sql.Date;

public class EmployeeDTO {

    /* 필기.
     *   DTO~
     *   - 어려 계층간의 데이터 전송을 위해 다양한 타입의 데이터를 하나로 묶어주기 위한 클래스
     *   - 유사어로 DTO, VO, Entity  등등이 있다.
     *     1. 기본생성자
     *     2. getter / setter
     *     3. toString() 오버라이딩
     *     4. 모든 필드 초기화하는 생성자
     *     5. 필드 캡슐화. private
     *
     *   - DTO 필드 구성 예시 (상황에 따라 다름)
     *   + 화면 위주로 구성
     *   + 데이터베이스 기반으로 구성 */

    private String empId;
    private String empName;
    private String empNo;
    private String empEmail;
    private String empPhone;
    private String empDeptCode;
    private String empJopCode;
    private String empSalLevel;
    private int empSalary;
    private double empBonus;
    private String empManagerId;
    private Date empHireDate;
    private Date empEntDate;
    private String empEntYn;

    public EmployeeDTO(String empId, String empName, String empNo, String empEmail, String empPhone, String empDeptCode, String empJopCode, String empSalLevel, int empSalary, double empBonus, String empManagerId, Date empHireDate, Date empEntDate, String empEntYn) {
        this.empId = empId;
        this.empName = empName;
        this.empNo = empNo;
        this.empEmail = empEmail;
        this.empPhone = empPhone;
        this.empDeptCode = empDeptCode;
        this.empJopCode = empJopCode;
        this.empSalLevel = empSalLevel;
        this.empSalary = empSalary;
        this.empBonus = empBonus;
        this.empManagerId = empManagerId;
        this.empHireDate = empHireDate;
        this.empEntDate = empEntDate;
        this.empEntYn = empEntYn;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    public String getEmpDeptCode() {
        return empDeptCode;
    }

    public void setEmpDeptCode(String empDeptCode) {
        this.empDeptCode = empDeptCode;
    }

    public String getEmpJopCode() {
        return empJopCode;
    }

    public void setEmpJopCode(String empJopCode) {
        this.empJopCode = empJopCode;
    }

    public String getEmpSalLevel() {
        return empSalLevel;
    }

    public void setEmpSalLevel(String empSalLevel) {
        this.empSalLevel = empSalLevel;
    }

    public int getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(int empSalary) {
        this.empSalary = empSalary;
    }

    public double getEmpBonus() {
        return empBonus;
    }

    public void setEmpBonus(double empBonus) {
        this.empBonus = empBonus;
    }

    public String getEmpManagerId() {
        return empManagerId;
    }

    public void setEmpManagerId(String empManagerId) {
        this.empManagerId = empManagerId;
    }

    public Date getEmpHireDate() {
        return empHireDate;
    }

    public void setEmpHireDate(Date empHireDate) {
        this.empHireDate = empHireDate;
    }

    public Date getEmpEntDate() {
        return empEntDate;
    }

    public void setEmpEntDate(Date empEntDate) {
        this.empEntDate = empEntDate;
    }

    public String getEmpEntYn() {
        return empEntYn;
    }

    public void setEmpEntYn(String empEntYn) {
        this.empEntYn = empEntYn;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", empNo='" + empNo + '\'' +
                ", empEmail='" + empEmail + '\'' +
                ", empPhone='" + empPhone + '\'' +
                ", empDeptCode='" + empDeptCode + '\'' +
                ", empJopCode='" + empJopCode + '\'' +
                ", empSalLevel='" + empSalLevel + '\'' +
                ", empSalary=" + empSalary +
                ", empBonus=" + empBonus +
                ", empManagerId='" + empManagerId + '\'' +
                ", empHireDate=" + empHireDate +
                ", empEntDate=" + empEntDate +
                ", empEntYn='" + empEntYn + '\'' +
                '}';
    }

    public EmployeeDTO() {
        super();
    }
}