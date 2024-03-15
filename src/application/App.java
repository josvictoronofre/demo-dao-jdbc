package application;

import java.util.Date;
import java.util.List;

import model_dao.DaoFactory;
import model_dao.SellerDao;
import model_entities.Department;
import model_entities.Seller;

public class App {

    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("-- Test 1 - Seller find by ID --");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("-- Test 2 - Seller find by Department --");
        Department dep = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(dep);

        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("-- Test 3 - Seller findAll --");
        list = sellerDao.findAll();

        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("-- Test 4 - Seller insert --");
        Seller newSeller = new Seller(null, "Greg Thompson", "greg@gmail.com", new Date(), 3600.0, dep);
        sellerDao.insert(newSeller);

        System.out.println("-- Test 5 - Seller Update --");
        seller = sellerDao.findById(1);
        seller.setName("Bruce Wayne");
        sellerDao.update(seller);
        System.out.println("Update complete!");
    }
}
