package algorithm;

import javax.xml.crypto.dsig.SignatureMethod;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.stream.IntStream;

public class CountingSort {
  public static void countingSort(int[] a, int n) {
    if (n <= 1) {
      return;
    }

    int max = a[0];
    for (int i = 1; i < n; ++i) {
      if (max < a[i]) {
        max = a[i];
      }
    }

    int[] c = new int[max + 1];
    for (int i = 0; i <= max; ++i) {
      c[i] = 0;
    }

    for (int i = 0; i < n; ++i) {
      c[a[i]]++;
    }

    for (int i = 1; i <= max; ++i) {
      c[i] = c[i-1] + c[i];
    }

    int[] r = new int[n];
    for (int i = n - 1; i >= 0; --i) {
      int index = c[a[i]] - 1;
      r[index] = a[i];
      c[a[i]]--;
    }

    for (int i = 0; i < n; i++) {
      a[i] = r[i];
    }

    IntStream.of(a)
            .forEach(ac -> System.out.println(ac));
  }

  public static void main(String[] args) {
    int[] arr = {2,5,3,0,2,3,0,3};
//    countingSort(arr, arr.length);
//    arr[10] = 1;
//    try {
//      calEndDate(BigDecimal.valueOf(100),BigDecimal.valueOf(3), "2020-07-22");
//    } catch (ParseException e) {
//      e.printStackTrace();
//    }
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    System.out.println(LocalDateTime.parse("2020-07-20 00:00:00", formatter));
  }

  public static void calEndDate (BigDecimal account , BigDecimal feeForADay, String startStr) throws ParseException {
    //计算可用天数
    BigDecimal days = account.divide(feeForADay, 0, RoundingMode.CEILING);
    //计算时间
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date startDate = sdf.parse(startStr);
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(startDate);
    calendar.add(Calendar.DAY_OF_MONTH, days.intValue());
    Date endDate = calendar.getTime();
    String endStr = sdf.format(endDate);
    System.out.println(endStr);
  }
}
