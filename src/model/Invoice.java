package model;
import java.util.Calendar;

public class Invoice {
    
    private Calendar operation_Date;
    private double invoicePrice;
    
    public Invoice (Calendar operation_Date, double invoicePrice) {
        this.operation_Date = operation_Date;
        this.invoicePrice = invoicePrice; 
    }

    public Calendar getOperation_Date() {
        return operation_Date;
    }

    public void setOperation_Date(Calendar operation_Date) {
        this.operation_Date = operation_Date;
    }

    public double getInvoicePrice() {
        return invoicePrice;
    }

    public void setInvoicePrice(double invoicePrice) {
        this.invoicePrice = invoicePrice;
    }

    

}
