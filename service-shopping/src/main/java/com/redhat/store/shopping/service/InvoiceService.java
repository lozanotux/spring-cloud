package com.redhat.store.shopping.service;

import com.redhat.store.shopping.entity.Invoice;

import java.util.List;

public interface InvoiceService {
    List<Invoice> findInvoiceAll();

    Invoice createInvoice(Invoice invoice);
    Invoice updateInvoice(Invoice invoice);
    Invoice deleteInvoice(Invoice invoice);

    Invoice getInvoice(Long id);
}
