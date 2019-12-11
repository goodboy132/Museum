package com.soft.museum.constant;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateParser {
  public static List<LocalDateTime> parse(String from, String to) throws ParseException {
    List<LocalDateTime> localDateTimes = new ArrayList<>();
    Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(from);
    Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(to);
    localDateTimes.add(LocalDateTime.ofInstant(date1.toInstant(), ZoneId.systemDefault()));
    localDateTimes.add(LocalDateTime.ofInstant(date2.toInstant(), ZoneId.systemDefault()));
    return localDateTimes;
  }
}
