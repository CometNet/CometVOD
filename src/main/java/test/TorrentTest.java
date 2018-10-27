package test;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.ba;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;
import org.apache.commons.lang3.ArrayUtils;
import org.eclipse.bittorrent.TorrentFile;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigInteger;


public class TorrentTest {
    @Test
    public void testGetInfoHash() throws IOException {
        TorrentFile tf = new TorrentFile(new File("D://Clean_Zone_Responsive_Admin_Template.torrent"));

        System.out.println(ArrayUtils.toString(tf.getFilenames()));
    }

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
    @Test
    public void testIe(){

        Browser browser = new Browser();
        BrowserView view = new BrowserView(browser);

        JFrame frame = new JFrame("JxBrowser - Hello World");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(view, BorderLayout.CENTER);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        browser.loadHTML("<h1>Hello World!</h1>");
    }
}
