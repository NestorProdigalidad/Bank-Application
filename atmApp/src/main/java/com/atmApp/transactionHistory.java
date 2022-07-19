package com.atmApp;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.commons.io.input.UnsynchronizedByteArrayInputStream;
import org.apache.xmlbeans.XmlObject;
import org.apache.commons.collections4.ListValuedMap;
import org.apache.logging.log4j.LogManager;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook;
import java.util.Date;
import java.text.SimpleDateFormat;

public class transactionHistory{
    private XSSFWorkbook transactionHistoryDatabase = new XSSFWorkbook();
    private XSSFSheet accountHistory;
    private XSSFRow row;
    private int rowNum =  0;
    private Cell transactionTypeCell,dateTimeCell,depositAmountCell,withdrawAmountCell,newBalanceCell;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Date date = new Date();
    public transactionHistory(){

    }
    public transactionHistory(Account account){
        accountHistory = transactionHistoryDatabase.createSheet(account.getName()+"_transactionHistory");
    }
    public void depositTransaction(double depositAmount, double currentBalance){
        row = accountHistory.createRow(rowNum++);
        dateTimeCell = row.createCell(0);
        transactionTypeCell = row.createCell(1);
        depositAmountCell = row.createCell(2);
        newBalanceCell = row.createCell(3);
        dateTimeCell.setCellValue(formatter.format(date));
        transactionTypeCell.setCellValue("Deposit");
        depositAmountCell.setCellValue("$"+depositAmount);
        newBalanceCell.setCellValue("$"+currentBalance);
    }
    public void withdrawTransaction(double withdrawAmount, double currentBalance){
        row = accountHistory.createRow(rowNum++);
        dateTimeCell = row.createCell(0);
        transactionTypeCell = row.createCell(1);
        withdrawAmountCell = row.createCell(2);
        newBalanceCell = row.createCell(3);
        dateTimeCell.setCellValue(formatter.format(date));
        transactionTypeCell.setCellValue("Withdrawal");
        withdrawAmountCell.setCellValue("$"+withdrawAmount);
        newBalanceCell.setCellValue("$"+currentBalance);
    }
    public void transferTransaction(){
        row = accountHistory.createRow(rowNum);
        dateTimeCell.setCellValue(formatter.format(date));
    }
}
