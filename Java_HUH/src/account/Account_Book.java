package account;

import java.io.Serializable;
public class Account_Book implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -7776708214059163959L;
	
	int account_Book_Date;
    int account_Book_Income;
    String account_Book_Type;
    int account_Book_Coin;
    String account_Book_Detail;

    public Account_Book() {
    }

	@Override
	public String toString() {
		return intToDate(account_Book_Date) + " | " + toIncome(account_Book_Income)
				+ " | " + account_Book_Type + " | " + account_Book_Coin
				+ " | " + account_Book_Detail;
	}

    private String toIncome(int a){
        if (a == 1) return "수입";
        if (a == 2) return "지출";
        else return "잘못된 입력. 수정요망";
    }

	public String intToDate(int date)  {
//0123 45 67
		String strDate = "" + date;

		StringBuffer stb = new StringBuffer();
		stb.append(strDate);
		stb.insert(6, " - ");
		stb.insert(4, " - ");
		String result = String.valueOf(stb);
		return result;
		
		
		
//		try {
////			String strDate = "" + date;
//			SimpleDateFormat format1 = new SimpleDateFormat("yyyy - MM - dd");
//			Date formatDate = format1.parse(strDate);
//			String result = format1.format(strDate);
//			return result;
//		} catch (ParseException e) {
//
//		}

//		return "Err";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public Account_Book(int account_Book_Date, int account_Book_Income, String account_Book_Type, int account_Book_Coin,
			String account_Book_Detail) {
		this.account_Book_Date = account_Book_Date;
		this.account_Book_Income = account_Book_Income;
		this.account_Book_Type = account_Book_Type;
		this.account_Book_Coin = account_Book_Coin;
		this.account_Book_Detail = account_Book_Detail;
	}

	public int getAccount_Book_Date() {
		return account_Book_Date;
	}

	public void setAccount_Book_Date(int account_Book_Date) {
		this.account_Book_Date = account_Book_Date;
	}

	public int getAccount_Book_Income() {
		return account_Book_Income;
	}

	public void setAccount_Book_Income(int account_Book_Income) {
		this.account_Book_Income = account_Book_Income;
	}

	public String getAccount_Book_Type() {
		return account_Book_Type;
	}

	public void setAccount_Book_Type(String account_Book_Type) {
		this.account_Book_Type = account_Book_Type;
	}

	public int getAccount_Book_Coin() {
		return account_Book_Coin;
	}

	public void setAccount_Book_Coin(int account_Book_Coin) {
		this.account_Book_Coin = account_Book_Coin;
	}

	public String getAccount_Book_Detail() {
		return account_Book_Detail;
	}

	public void setAccount_Book_Detail(String account_Book_Detail) {
		this.account_Book_Detail = account_Book_Detail;
	}

}