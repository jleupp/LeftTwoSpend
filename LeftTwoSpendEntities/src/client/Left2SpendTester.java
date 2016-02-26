package client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entities.Account;
import entities.User;

public class Left2SpendTester {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("LeftPU");
	EntityManager em = emf.createEntityManager();
	
	public static void main(String[] args) {
		Left2SpendTester test = new Left2SpendTester();
		
//		test.addStuffToDB();
		
		test.removeStuffDB();
		
		
		
//		CriteriaQuery<User> cq = em.getCriteriaBuilder().createQuery(User.class);
//		cq.select(cq.from(User.class));
//		List<User> users = em.createQuery(cq).getResultList();
//		for(User user : users) {
//			System.out.println(user.getEmail());
//			System.out.println(user.getPassword());
//			System.out.println(user.getAmountSpent());
//			System.out.println(user.getAccount().getMonthlyAllowance());
//			List<User> acctUsers = user.getAccount().getUsers();
//			for (User acctUser : acctUsers) {
//				System.out.println("FromAccount: " + acctUser.getEmail() + " " + acctUser.getPassword() + " " + acctUser.getAmountSpent() + " " + acctUser.getAccount().getMonthlyAllowance());
//			}
//			System.out.println(user.getAccount().getUsers());
//			System.out.println("--------------------------------------");
//		}
//		
//		CriteriaQuery<Account> cq2 = em.getCriteriaBuilder().createQuery(Account.class);
//		cq2.select(cq2.from(Account.class));
//		List<Account> accounts = em.createQuery(cq2).getResultList();
//		for (Account account : accounts) {
//			System.out.println(account.getId());
//			System.out.println(account.getMonthlyAllowance());
//			List<User> acctUsers = account.getUsers();
//			for (User acctUser : acctUsers) {
//				System.out.println("FromAccount: " + acctUser.getEmail() + " " + acctUser.getPassword() + " " + acctUser.getAmountSpent() + " " + acctUser.getAccount().getMonthlyAllowance());
//			}
//			System.out.println(account.getUsers().get(0).getEmail());
//			System.out.println("--------------------------------------");
//		}
//		
		
		
	}

//	public void addStuffToDB() {
//		EntityTransaction et = em.getTransaction();
//		et.begin();
//		User user = new User();
//		user.setEmail("tleupp@aol.com");
//		user.setAmountSpent(0.0);
//		user.setPassword("password");
//		
//		Account account = new Account();
//		account.setMonthlyAllowance(5000.);
//		account.setSpentThisMonth(0.0);
//		user.setAccount(account);
//		em.persist(account);
//		em.persist(user);
//		et.commit();
//	}
	
	public void removeStuffDB() {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(em.find(User.class, "tleupp@aol.com"));
		em.remove(em.find(Account.class, 3));
		et.commit();
		
	}
}