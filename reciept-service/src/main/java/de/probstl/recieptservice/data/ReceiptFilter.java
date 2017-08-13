package de.probstl.recieptservice.data;

import java.util.Date;

/**
 * Defines a filter for receipts
 *
 * @version $Id: my.products.setup,v 1.21 2016/08/12 13:02:01 rh Exp $<br>
 * (c) DE software &amp; control GmbH
 */
public interface ReceiptFilter
{
    /**
     * Returns the Date from which the receipts are returned
     *
     * @return
     */
    public Date getFromDate();

    /**
     * Returns the Date to which the receipts are returned
     *
     * @return
     */
    public Date getToDate();
}
