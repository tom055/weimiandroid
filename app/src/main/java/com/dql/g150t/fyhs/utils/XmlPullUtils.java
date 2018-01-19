package com.dql.g150t.fyhs.utils;

import android.util.Xml;


import com.dql.g150t.fyhs.model.FuYouResponseDTO;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ST on 2017/8/30.
 */

public class XmlPullUtils {

    public static FuYouResponseDTO getResponse(String data){
        XmlPullParser parser = Xml.newPullParser();
        String str = data.replace("\\","");
        str = str.substring(1,str.length()-1);
        InputStream in = new ByteArrayInputStream(str.getBytes());
        FuYouResponseDTO dto = new FuYouResponseDTO();
        try {
            parser.setInput(in,"UTF-8");
            int eventType = parser.getEventType();
            while (eventType!=XmlPullParser.END_DOCUMENT){
                switch (eventType){
                    case XmlPullParser.START_TAG:
                        String name = parser.getName();
                        switch (parser.getName()){
                            case "VERSION":
                                dto.setVERSION(parser.nextText());
                                break;
                            case "RESPONSECODE":
                                dto.setRESPONSECODE(parser.nextText());
                                break;
                            case "RESPONSEMSG":
                                dto.setRESPONSEMSG(parser.nextText());
                                break;
                            case "MCHNTORDERID":
                                dto.setMCHNTORDERID(parser.nextText());
                                break;
                            case "ORDERID":
                                dto.setORDERID(parser.nextText());
                                break;
                            case "AMT":
                                dto.setAMT(parser.nextText());
                                break;
                            case "BANKCARD":
                                dto.setBANKCARD(parser.nextText());
                                break;
                            case "REM1":
                                dto.setREM1(parser.nextText());
                                break;
                            case "REM2":
                                dto.setREM2(parser.nextText());
                                break;
                            case "REM3":
                                dto.setREM3(parser.nextText());
                                break;
                            case "SIGNTP":
                                dto.setSIGNTP(parser.nextText());
                                break;
                            case "MCHNTCD":
                                dto.setMCHNTCD(parser.nextText());
                                break;
                            case "SIGN":
                                dto.setSIGN(parser.nextText());
                                break;
                            case "TYPE":
                                dto.setTYPE(parser.nextText());
                                break;
                            case "VER":
                                dto.setVER(parser.nextText());
                                break;
                        }
                        break;
                }
                eventType = parser.next();
            }
            return dto;
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dto;
    }
}
