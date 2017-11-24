package com.example.dingu.axicut.Design;

import com.example.dingu.axicut.SaleOrder;
import com.example.dingu.axicut.WorkOrder;

import java.io.Serializable;

/**
 * Created by root on 22/5/17.
 */

public interface DesignLayoutCommunicator extends Serializable {
     void adapterNotify(String layout);
     void updateWorkOrderLayoutToDatabase(String layout);
     void clearAll();
     WorkOrder getWorkOrder();
}
