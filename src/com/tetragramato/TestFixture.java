package com.tetragramato;

import com.tetragramato.model.complexe.Operation;
import com.tetragramato.model.complexe.Quittance;
import com.tetragramato.model.type.TypeOperation;
import com.tetragramato.model.type.TypeQuittance;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * Création des fictures pour le test.
 * Created by tetragramato on 31/01/2015.
 */
public class TestFixture {

    public static List<Operation> buildTestCaseOperations() {

        Quittance quittancePrime = new Quittance.Builder()
                .idQuittance(1L)
                .libelle("Quitance Prime 1")
                .typeQuittance(TypeQuittance.PRIME)
                .build();

        Quittance quittanceCommission = new Quittance.Builder()
                .idQuittance(1L)
                .libelle("Quitance Commission 1")
                .typeQuittance(TypeQuittance.COMMISSION)
                .build();

        Operation operationCredit20 = new Operation.Builder()
                .montant(new BigDecimal("20"))
                .typeOperation(TypeOperation.CREDIT)
                .quittance(quittancePrime)
                .build();

        Operation operationCredit20Bis = new Operation.Builder()
                .montant(new BigDecimal("20"))
                .typeOperation(TypeOperation.CREDIT)
                .quittance(quittancePrime)
                .build();

        Operation operationDebit40 = new Operation.Builder()
                .montant(new BigDecimal("40"))
                .typeOperation(TypeOperation.DEBIT)
                .quittance(quittancePrime)
                .build();

        Operation operationDebit40Bis = new Operation.Builder()
                .montant(new BigDecimal("40"))
                .typeOperation(TypeOperation.DEBIT)
                .quittance(quittancePrime)
                .build();

        Operation operationCredit50 = new Operation.Builder()
                .montant(new BigDecimal("50"))
                .typeOperation(TypeOperation.CREDIT)
                .quittance(quittanceCommission)
                .build();

        Operation operationCredit50Bis = new Operation.Builder()
                .montant(new BigDecimal("50"))
                .typeOperation(TypeOperation.CREDIT)
                .quittance(quittanceCommission)
                .build();

        Operation operationDebit10 = new Operation.Builder()
                .montant(new BigDecimal("10"))
                .typeOperation(TypeOperation.DEBIT)
                .quittance(quittanceCommission)
                .build();

        Operation operationDebit10Bis = new Operation.Builder()
                .montant(new BigDecimal("10"))
                .typeOperation(TypeOperation.DEBIT)
                .quittance(quittanceCommission)
                .build();

        return Arrays.asList(operationCredit20, operationCredit20Bis, operationDebit40, operationDebit40Bis, operationCredit50, operationCredit50Bis, operationDebit10, operationDebit10Bis);
    }
}
