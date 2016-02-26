package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	@Id
	private String email;
	
	@Column(name="amount_spent")
	private Double amountSpent;
	
	private String password;
	
	@ManyToOne
	@JoinColumn(name="account_id")
	private Account account;

	public String getEmail() {
		return email;
	}

	public Double getAmountSpent() {
		return amountSpent;
	}

	public String getPassword() {
		return password;
	}

	public Account getAccount() {
		return account;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAmountSpent(Double amountSpent) {
		this.amountSpent = amountSpent;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	

}
