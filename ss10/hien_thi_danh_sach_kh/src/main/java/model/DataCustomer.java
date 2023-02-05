package model;

import java.util.ArrayList;
import java.util.List;

public class DataCustomer {
    public static List<Customer> customerList=new ArrayList<>();
    static {
        customerList.add(new Customer("Mai Van Hoang","1983-08-20","Ha Noi",
                "https://tophinhanh.com/wp-content/uploads/2021/12/hinh-anh-gai-xinh-nhat-the-gioi.jpg"));
        customerList.add(new Customer("Nguyen Van Nam","1983-08-21","Bac Giang",
                "https://tophinhanh.com/wp-content/uploads/2021/12/hinh-anh-gai-xinh-nhat-the-gioi.jpg"));
        customerList.add(new Customer("Nguyen Thai Hoa","1983-08-22","Nam Dinh",
                "https://tophinhanh.com/wp-content/uploads/2021/12/hinh-anh-gai-xinh-nhat-the-gioi.jpg"));
        customerList.add(new Customer("Tran Dang Khoa","1983-08-17","Ha Tay",
                "https://tophinhanh.com/wp-content/uploads/2021/12/hinh-anh-gai-xinh-nhat-the-gioi.jpg"));
        customerList.add(new Customer("Nguyen Dinh Thi","1983-08-19","Ha Noi",
                "https://tophinhanh.com/wp-content/uploads/2021/12/hinh-anh-gai-xinh-nhat-the-gioi.jpg"));
    }
    }

