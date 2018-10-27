package org.huixing.vod;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.ba;
import javafx.application.Application;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigInteger;


public class BaseGUI extends Application {
    private static String[] params;

    static {
        try {
            Field e = ba.class.getDeclaredField("e");
            e.setAccessible(true);
            Field f = ba.class.getDeclaredField("f");
            f.setAccessible(true);
            Field modifersField = Field.class.getDeclaredField("modifiers");
            modifersField.setAccessible(true);
            modifersField.setInt(e, e.getModifiers() & ~Modifier.FINAL);
            modifersField.setInt(f, f.getModifiers() & ~Modifier.FINAL);
            e.set(null, new BigInteger("1"));
            f.set(null, new BigInteger("1"));
            modifersField.setAccessible(false);
        } catch (Exception e1) {
            e1.printStackTrace();
        }

    }

    public BaseGUI() {
        super();
    }

    static void setParams(String[] params) {
        BaseGUI.params = params;
    }

    @Override
    public void start(Stage stage) {

        Browser browser = new Browser();
        com.teamdev.jxbrowser.chromium.swing.BrowserView view = new com.teamdev.jxbrowser.chromium.swing.BrowserView(browser);

        JFrame frame = new JFrame("JxBrowser - Hello World");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(view, BorderLayout.CENTER);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        browser.loadHTML("<h1>Hello World!</h1>");
//        stage.setTitle("Chrome View");
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(BaseGUI.class.getResource("D:\\test.fxml"));
//        System.out.println(loader.getLocation().getPath());
//        try {
//            Parent load = loader.load();
//            Scene scene = new Scene(load);
//            BrowserView webview = (BrowserView) scene.lookup("#webview");
//            webview.getBrowser().loadURL("http://www.bangwo8.com");
//            stage.setScene(scene);
//            stage.setWidth(1366);
//            stage.setHeight(768);
//            stage.setOnCloseRequest(event -> {
//                stage.close();
//                System.exit(0);
//            });
///*
//Media media = new Media("http://v1i.cc/adl.mp4");
//
////创建播放器对象，控制媒体播放行为
//MediaPlayer mediaPlayer = new MediaPlayer(media);
//mediaPlayer.setAutoPlay(true);   //设置自动播放
//mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
////创建媒体播放视图
//MediaView mediaView = new MediaView(mediaPlayer);
//((BorderPane)load).setBottom(mediaView);*/
//
//
//            stage.getIcons().add(new Image(BaseGUI.class.getResourceAsStream("/img/icon.png")));
//
//            stage.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
