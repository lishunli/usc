package com.taifook.mtss.mss.integration.egioginstrexport;

import java.util.List;

/**
 * <br> This is an Email Model. </br>
 *
 * <br></br>
 * <br>
 *  Copyright (c) 2002 Tai Fook Securities Group Limited.
 *  All rights reserved.
 *
 *  This file contains the valuable properties of Tai Fook Securities
 *  Group Limited, embodying substantial creative efforts and confidential
 *  information, ideas and expressions. No part of this file may be
 *  reproduced or distributed in any form or by any means, or stored
 *  in a data base or a retrieval system, without the prior written
 *  permission of Tai Fook Securities Group Limited.
 * </br>
 *
 * <br></br>
 * <br>Revision History: </br>
 * <TABLE BORDER=1>
 * <TR><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>2005</TD><TD>chchau</TD><TD>Design</TD></TR>
 * </TABLE>
 *
 */
@SuppressWarnings("rawtypes")
public class EmailModel {
    List toList = null;
    List ccList = null;
    List bccList = null;
    String subject = null;
    String content = null;
    String lang = null;

    public List getBccList() {
        return bccList;
    }
    public void setBccList(List bccList) {
        this.bccList = bccList;
    }
    public List getCcList() {
        return ccList;
    }
    public void setCcList(List ccList) {
        this.ccList = ccList;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public List getToList() {
        return toList;
    }
    public void setToList(List toList) {
        this.toList = toList;
    }
    /**
     * @return Returns the lang.
     */
    public String getLang() {
        return lang;
    }
    /**
     * @param lang The lang to set.
     */
    public void setLang(String lang) {
        this.lang = lang;
    }
}
