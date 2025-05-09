//package com.zeroco.integration;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook; 
//
//public class UserInformation {
//    
//    public final static String FILE_NAME = "D:\\User_Details.xlsx";
//    
//    public static Connection getConnection() throws SQLException {
//        String url = "jdbc:mysql://localhost:3306/user";
//        String user = "root";
//        String password = "the@123";
//        return DriverManager.getConnection(url, user, password);
//    }
//    
//    public static String importExcelData() {
////    	String url = "jdbc:mysql://localhost:3306/user";
////    	String user = "root";
////    	String password = "the@123";
//    	Connection connection = null;
//    	Workbook workBook = null;
//    	FileInputStream file = null;
//    	String insertQuery = "INSERT INTO details (name, email, phone_number, address) VALUES (?, ?, ?, ?)";
//    	try {
//    	    Class.forName("com.mysql.cj.jdbc.Driver");
//    	    connection = getConnection();
//    	    file = new FileInputStream(FILE_NAME);
//    	    workBook = new XSSFWorkbook(file);
//    	    Sheet sheet = workBook.getSheetAt(1);
//    	    try (PreparedStatement insertStmt = connection.prepareStatement(insertQuery)) {
//    	        for (Row row : sheet) {
//    	            if (row.getRowNum() == 0) continue; 
//    	            String name = row.getCell(0).getStringCellValue();
//    	            String email = row.getCell(1).getStringCellValue();
//    	            String phoneNumber = String.valueOf((long) row.getCell(2).getNumericCellValue());
//    	            String address = row.getCell(3).getStringCellValue();
//    	            if (!isDuplicateEmail(connection, email)) {
//    	                insertStmt.setString(1, name);
//    	                insertStmt.setString(2, email);
//    	                insertStmt.setString(3, phoneNumber);
//    	                insertStmt.setString(4, address);
////    	                System.out.println("Inserting: " + name + ", " + email + ", " + phoneNumber + ", " + address);
//    	                insertStmt.executeUpdate();
//    	            }
//    	        }
//    	    }
//    	} catch (SQLException e) {
//    	    e.printStackTrace();
//    	} finally {
//    	    try {
//    	        if (workBook != null) workBook.close();
//    	        if (file != null) file.close();
//    	        if (connection != null) connection.close();
//    	    } catch (IOException | SQLException e) {
//    	        e.printStackTrace();
//    	    }
//    	}
//    	return "Import completed";
//    }
//
//    private static boolean isDuplicateEmail(Connection connection, String email) throws SQLException {
//        String checkQuery = "SELECT COUNT(*) FROM details WHERE email = ?";
//        try (PreparedStatement checkStmt = connection.prepareStatement(checkQuery)) {
//            checkStmt.setString(1, email);
//            ResultSet resultSet = checkStmt.executeQuery();
//            resultSet.next();
////            System.out.println("d+checking data");
//            return resultSet.getInt(1) > 0; 
//        }
//    }
//    
//    public static void main(String[] args) {
//        System.out.println(importExcelData());
//    }
//}
