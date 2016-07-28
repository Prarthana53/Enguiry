/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prarthana.enquiry.dao;

import com.prarthana.enquiry.enq.Enquiry;

/**
 *
 * @author prarthanapradhan
 */
public interface EnquiryDAO {
    boolean insert(Enquiry e);
    boolean delete(int id);
    Enquiry getByName(String name);
    Enquiry[] getAll();
}
