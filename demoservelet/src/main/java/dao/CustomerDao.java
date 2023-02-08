package dao;

import model.Customer;

import java.util.*;

public class CustomerDao {
    private static final Map<Integer, Customer>listCustomer=new HashMap<Integer, Customer>();
   static {
       initCustomer();
   }
   private static void initCustomer(){
       Customer cus1=new Customer(1,"Phạm Thắng","0974862596","thangpham103150211@gmail.com");
       Customer cus2=new Customer(2,"Thắng","0974862596","thangpham103150211@gmail.com");
       Customer cus3=new Customer(3,"Thano","0974862596","thangpham103150211@gmail.com");
       Customer cus4=new Customer(4,"Lê","0974862596","thangpham103150211@gmail.com");
       listCustomer.put(cus1.getId(),cus1);
       listCustomer.put(cus2.getId(),cus2);
       listCustomer.put(cus3.getId(),cus3);
       listCustomer.put(cus4.getId(),cus4);
   }
    //Viết phương thức xử lys get thông tin cu 1 customer thông qua id
    public static Customer getCus(int cusId){
       return listCustomer.get(cusId);
    }
    //viết phương thưc thêm mới customer
    public static void addCus(Customer customer){
       listCustomer.put(customer.getId(),customer);
    }
    //viết phương thức update
    public static Customer updateCus(Customer customer){
       listCustomer.put(customer.getId(),customer);
       return customer;
    }
    //Viết phương thức xoá theo id
    public static void deleteCus(int cusID){
       listCustomer.remove(cusID);
    }
    public static List<Customer>getAllCus(){
        Collection<Customer>c=listCustomer.values();
        List<Customer>customerList=new ArrayList<>();
        customerList.addAll(c);
        return customerList;
    }
}
