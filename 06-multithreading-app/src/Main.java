import com.tss.tasks.MyTask;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
//        ExecutorService service= Executors.newCachedThreadPool();
//        for (int i=0;i<100;i++)
//        {
//            service.execute(new MyTask());
//        }
//        Thread thread=new Thread(new MyTask());
//        thread.start();

//        ExecutorService service= Executors.newFixedThreadPool(10);
//        for (int i=0;i<100;i++)
//        {
//            service.execute(new MyTask());
//        }

        ExecutorService service= Executors.newSingleThreadExecutor();
        for (int i=0;i<100;i++)
        {
            service.execute(new MyTask());
        }
    }
}