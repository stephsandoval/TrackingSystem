package Controllers;

import java.time.LocalDate;

import Orders.OrderMaker;
import Packages.IDGenerator;
import Packages.PackageMaker;
import People.Employee;
import Screens.AddScreen;

public class AddController {
    
    private AddScreen screen;
    private Employee employee;
    private OrderMaker orderMaker;
    private PackageMaker packageMaker;

    public AddController (AddScreen screen){
        this.screen = screen;
        callCreators();
        System.out.println(packageMaker.getPackage());
    }

    private void callCreators (){
        callEmployee();
        callOrderMaker();
        callPackageMaker();
    }

    private void callEmployee (){
        employee = new Employee("Pete", IDGenerator.getInstance().getNewID(), "FTS");
        employee.takeOrder(screen.getUserSelection(), screen.getArrivalPlace(), screen.getArrivalDate(), LocalDate.now(), screen.getClientName());
    }

    private void callOrderMaker (){
        orderMaker = new OrderMaker(employee.getOrder());
    }

    private void callPackageMaker (){
        packageMaker = new PackageMaker(employee.getOrder(), orderMaker.getPrepackage(), orderMaker.isComplete());
    }
}