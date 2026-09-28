package src.Services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import src.DAO.AccountDAO;
import src.DAO.ClientDAO;
import src.DAO.TransactionDAO;

public class ReportService {

	public static void accountAnalysis(String email)
	{
		int clientId = ClientDAO.getClientId(email);

		if(clientId == 0){
			return;
		}

		int accounts = 0;
		double totalBalance = 0;

		try{
			ResultSet result = AccountDAO.getAccountsbyClientId(clientId);

			while(result.next()){
				accounts++;
				totalBalance += result.getDouble("balance");
			}

			if(accounts == 0){
				System.out.println("You Don't Have Any Accounts");
				return;
			}

			System.out.println("Number Of Accounts: " + accounts);
			System.out.println("Total Balance: " + totalBalance + "DH");
		}catch(SQLException e){
			System.out.println(e);
		}
	}

	public static void alerts(String email)
	{
		int clientId = ClientDAO.getClientId(email);

		if(clientId == 0){
			return;
		}

		LocalDate lastActivity = null;
		LocalDate today = LocalDate.now();
		Map<LocalDate, Double> withdrawals = new HashMap<>();

		try(ResultSet result = TransactionDAO.getTransactionsByClientId(clientId)){
			while(result.next()){
				LocalDate date = result.getDate("date").toLocalDate();

				if(lastActivity == null || date.isAfter(lastActivity)){
					lastActivity = date;
				}

				if(result.getString("type").equals("WITHDRAWAL")){
					double amount = result.getDouble("amount");
					withdrawals.put(date, withdrawals.getOrDefault(date, 0.0) + amount);
				}
			}

			if(lastActivity == null){
				System.out.println("No Alerts");
				return;
			}

			if(lastActivity.isBefore(today.minusMonths(5))){
				System.out.println("Alert: No Activity For 5 Months");
			}

			for(Map.Entry<LocalDate, Double> withdrawal : withdrawals.entrySet()){
				if(withdrawal.getValue() >= 1000){
					System.out.println("Alert: Withdrawals Of " + withdrawal.getValue() +
						"DH On " + withdrawal.getKey());
				}
			}
		}catch(SQLException e){
			System.out.println(e);
		}
	}
}
