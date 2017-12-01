package entity;

public class Customers {
    private int idCustomers;
    private String name;
    private String company;

    public Customers() {
    }

    public Customers(String name, String company) {
        this.name = name;
        this.company = company;
    }

    public Customers(int idCustomers, String name, String company) {
        this.idCustomers = idCustomers;
        this.name = name;
        this.company = company;
    }

    public int getIdCustomers() {
        return idCustomers;
    }

    public void setIdCustomers(int idCustomers) {
        this.idCustomers = idCustomers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Customer{" + "idCustomers" + idCustomers +
                ", name=" + name +
                ", company=" + company + '}';
    }
}
