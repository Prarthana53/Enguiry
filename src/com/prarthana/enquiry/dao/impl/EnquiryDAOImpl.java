/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prarthana.enquiry.dao.impl;

import com.prarthana.enquiry.dao.EnquiryDAO;
import com.prarthana.enquiry.enq.Enquiry;

/**
 *
 * @author prarthanapradhan
 */
public class EnquiryDAOImpl implements EnquiryDAO {
    private int counter=0;
    private Enquiry[] enqList=new Enquiry[5];

    @Override
    public boolean insert(Enquiry e) {
      if(counter==enqList.length){
      return false;
      }
      enqList[counter]=e;
      counter++;
      return true;
    }

    @Override
    public boolean delete(int id) {
        for(int i=0;i<enqList.length;i++) {
        Enquiry en=enqList[i];
        if(en!=null && en.getId()==id){
        enqList[i]=null;
        return true;
        }
        }
        return false;
    }

    @Override
    public Enquiry getByName(String name) {
        for(int i=0;i<enqList.length;i++) {
        Enquiry en=enqList[i];
        if(en!=null && en.getType().equalsIgnoreCase(name)){
        enqList[i]=null;
        return en;
        }
        }
        return null;
    }

    @Override
    public Enquiry[] getAll() {
        return enqList;
    }
    
}
