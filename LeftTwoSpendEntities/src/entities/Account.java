package entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="account")
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="monthly_allowance")
	private Double monthlyAllowance;
	
	@OneToMany(mappedBy = "account")
	private List<User> users;
	
	@Column(name="spent_this_month")
	private Double spentThisMonth;

	public int getId() {
		return id;
	}

	public Double getMonthlyAllowance() {
		return monthlyAllowance;
	}

	public List<User> getUsers() {
		return users;
	}

	public Double getSpentThisMonth() {
		return spentThisMonth;
	}
	
	public void setMonthlyAllowance(Double monthlyAllowance) {
		this.monthlyAllowance = monthlyAllowance;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public void addUser(User user) {
		this.users.add(user);
	}


	public void setSpentThisMonth(Double spentThisMonth) {
		this.spentThisMonth = spentThisMonth;
	}
	
	
	
}
