package src.Services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import src.DAO.TransactionDAO;
import src.Enum.*;
import src.entity.Transaction;

public class TransactionService {

    public static void deposit(Double amount, int accountId)
    {
        Date date = new Date();
        Transaction transaction = new Transaction(date, amount,TransactionType.DEPOSIT, "SAFI", accountId);
        if(!TransactionDAO.createTransaction(transaction)){
            System.out.println("Error Adding a Transaction");
        }
    }

    public static void withdrawal(Double amount, int accountId)
    {
        Date date = new Date();
        Transaction transaction = new Transaction(date, amount,TransactionType.WITHDRAWAL, "SAFI", accountId);
        if(!TransactionDAO.createTransaction(transaction)){
            System.out.println("Error Adding a Transaction");
        }
    }

    public static void transfer(Double amount, int accountId)
    {
        Date date = new Date();
        Transaction transaction = new Transaction(date, amount,TransactionType.TRANSFER, "SAFI", accountId);
        if(!TransactionDAO.createTransaction(transaction)){
            System.out.println("Error Adding a Transaction");
        }
    }
    
    public static void viewTransactions(String userEmail){

    try(ResultSet rs = TransactionDAO.getTransactionByUserEmail(userEmail)){

        while(rs.next()){
            Date date = rs.getDate("date");
            int amount = rs.getInt("amount");
            String type = rs.getString("type");
            String location = rs.getString("location");
            System.out.println(type + " | " + amount + "DH " + date + " " + location);
        }

    }catch(SQLException e){
        System.out.println(e.getMessage());
    }
    }
}
