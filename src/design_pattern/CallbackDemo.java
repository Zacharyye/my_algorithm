package design_pattern;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallbackDemo {
  public static void main(String[] args) {
    BClass b = new BClass();
    b.process(new ICallback() {
      @Override
      public void methodToCallback() {
        Executors.newSingleThreadExecutor().submit(new Runnable() {
          @Override
          public void run() {
            System.out.println("Call back me.");
            System.exit(1);
          }
        });
      }
    });
  }
}

interface ICallback {
  void methodToCallback();
}

class BClass {
  public void process(ICallback iCallback) {
    System.out.println("Start ...");
    iCallback.methodToCallback();
    System.out.println("End!");
  }
}
