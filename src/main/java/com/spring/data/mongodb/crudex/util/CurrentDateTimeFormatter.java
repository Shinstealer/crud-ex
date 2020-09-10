package com.spring.data.mongodb.crudex.util;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class CurrentDateTimeFormatter {

  private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZZ" , Locale.KOREA);

  public static String getCurrentDateTime(){
    return formatter.format(OffsetDateTime.now());
  }
  
}
