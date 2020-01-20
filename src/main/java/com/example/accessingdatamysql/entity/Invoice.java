package com.example.accessingdatamysql.entity;

import lombok.Data;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.*;
import java.net.SocketTimeoutException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Set;

@Data
public class Invoice {

    private String invoceCode;
    private String invoceNUmber;
    private String invoiceType;
//    @DecimalMax(value="9999999999.99")
//    @DecimalMin(value="-9999999999.99")

    @Digits(integer=4,fraction = 2,message = "最多2位小数",groups={})
    @Digits(integer=9,fraction = 2,message = "最多2位小数",groups={})
    private Double invoiceAmount;

    private Double invoiceTax;
    private Double AmountTax;
//    @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$",message = "手机号码格式错误")
    private String mobile;
    @Future
    private Date invoiceDate;
    @Email
    private String email;

    public Invoice() {
    }

    public Invoice(String invoceCode, String invoceNUmber, String invoiceType, Double invoiceAmount, Double invoiceTax, Double amountTax) {
        this.invoceCode = invoceCode;
        this.invoceNUmber = invoceNUmber;
        this.invoiceType = invoiceType;
        this.invoiceAmount = invoiceAmount;
        this.invoiceTax = invoiceTax;
        AmountTax = amountTax;
    }

    public static void main(String[] args) {
        Invoice invoice = new Invoice();
//        invoice.setInvoiceAmount(-990.0);
//        invoice.setInvoiceTax(0.0);
//        invoice.setAmountTax(0.0);
      invoice.setInvoiceAmount(999999.66);

        ValidatorFactory vf = Validation.buildDefaultValidatorFactory(); // 手动创建一个validator验证器
        Validator validator = vf.getValidator();

        Set<ConstraintViolation<Invoice>> validate = validator.validate(invoice);

        for (ConstraintViolation<Invoice> constraintViolation : validate) {
            System.out.println(constraintViolation.getMessage());
        }
    }

}
