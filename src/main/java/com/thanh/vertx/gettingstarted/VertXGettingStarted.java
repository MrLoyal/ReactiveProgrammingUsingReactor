package com.thanh.vertx.gettingstarted;

import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.file.FileProps;
import io.vertx.core.file.FileSystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class VertXGettingStarted {
    private static final Logger logger = LoggerFactory.getLogger(VertXGettingStarted.class);


    public static void main(String[] args) {
        VertxOptions options = (new VertxOptions()).setWorkerPoolSize(10);
        Vertx vertx = Vertx.vertx(options);

        FileSystem fs = vertx.fileSystem();
        String filePath = "/Users/admin/learn/project-reactor/ReactiveProgrammingUsingReactor/src/main/java/com/thanh/vertx/gettingstarted/VertXGettingStarted.java";
        Future<FileProps> future = fs.props(filePath);

        future.onComplete(filePropsAsyncResult -> {
            System.out.println("File size = " + filePropsAsyncResult.result().size());
        });

        String filename = "files/vertx1.txt";
        String filename2 = "files/vertx2.txt";
        fs.createFile(filename)
                .compose(v -> {
                    logger.info("Compose 1");
                    return fs.writeFile("/foo", Buffer.buffer());
                })
                .compose(v -> {
                    logger.info("Compose 2");
                    System.out.println("Compose 2");
                    return fs.move(filename, filename2);
                });

        //vertx.setPeriodic(1000, id -> {
        //    logger.info("Called by VertX");
        //});

        Future<String> dnsFuture = vertx.createDnsClient().lookup("nodo.vn");
        // dnsFuture.toCompletionStage().

        try {
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        vertx.close();

    }
}
