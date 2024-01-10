package Practice.visitor;



import java.util.*;

abstract class  Client {
    private final String name;
    private final String address;
    private final String phone;
    private int loanAmount;


    public abstract void accept(Visitor visitor);

    public String getName() {
        return this.name;
    }

    public int getLoanAmount() {
        return this.loanAmount;
    }

    public void setLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
    }

    Client(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.loanAmount = 0;
    }

}

class Bank extends Client {
    public Bank(String name, String address, String phone) {
        super(name, address, phone);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }




}

class Company extends Client {
    public Company(String name, String address, String phone) {
        super(name, address, phone);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Resident extends Client{
    public Resident(String name, String address, String phone) {
        super(name, address, phone);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Restaurant extends Client {
    public Restaurant(String name, String address, String phone) {
        super(name, address, phone);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

interface Visitor {
   void visit(Bank bank);
   void visit(Company company);
    void visit(Resident resident);
    void visit(Restaurant restaurant);
}

class InsuranceMessageVisitor implements Visitor {
    public void sendInsuranceMessage(List<Client> clients) {
        for (Client client : clients) {
            client.accept(this);
        }

    }

    @Override
    public void visit(Bank bank) {
        System.out.println("Insurance Message for Bank: "+ bank.getName());
    }

    @Override
    public void visit(Company company) {
        System.out.println("Insurance Message for Company: " + company.getName());
    }

    @Override
    public void visit(Resident resident) {
        System.out.println("Insurance Message for Resident: " + resident.getName());
    }

    @Override
    public void visit(Restaurant restaurant) {
        System.out.println("Insurance Message for Restaurant: " + restaurant.getName());
    }
}


class LoanMessageVisitor implements Visitor {
    public void sendLoanMessage(List<Client> clients) {
        for (Client client : clients) {
            client.accept(this);
        }
    }

    @Override
    public void visit(Bank bank) {
        int loanAmount = new Random().nextInt(100000);
        bank.setLoanAmount(loanAmount);
        System.out.println("Loan Message for Bank: Assigned Loan to "+ bank.getName() + " is " + bank.getLoanAmount());
    }

    @Override
    public void visit(Company company) {
        int loanAmount = new Random().nextInt(100000);
        company.setLoanAmount(loanAmount);
        System.out.println("Loan Message for Company: Assigned Loan to "+ company.getName() + " is " + company.getLoanAmount());
    }

    @Override
    public void visit(Resident resident) {
        int loanAmount = new Random().nextInt(100000);
        resident.setLoanAmount(loanAmount);
        System.out.println("Loan Message for Resident: Assigned Loan to "+ resident.getName() + " is " + resident.getLoanAmount());
    }

    @Override
    public void visit(Restaurant restaurant) {
        int loanAmount = new Random().nextInt(100000);
        restaurant.setLoanAmount(loanAmount);
        System.out.println("Loan Message for Restaurant: Assigned Loan to "+ restaurant.getName() + " is " + restaurant.getLoanAmount());
    }
}
public class MessagingVisitorApp{
    public static void main(String[] args) {
        List<Client> clients = List.of(
                new Bank("Bank1", "Address1", "Phone1"),
                new Company("Company1", "Address2", "Phone2"),
                new Resident("Resident1", "Address3", "Phone3"),
                new Restaurant("Restaurant1", "Address4", "Phone4")
        );

        InsuranceMessageVisitor insuranceMessageVisitor = new InsuranceMessageVisitor();
        insuranceMessageVisitor.sendInsuranceMessage(clients);

        LoanMessageVisitor loanMessageVisitor = new LoanMessageVisitor();
        loanMessageVisitor.sendLoanMessage(clients);

    }
}
