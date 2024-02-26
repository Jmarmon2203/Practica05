package Util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Util {

    public static byte[] pathToByteArray(String path) {
        try {
            BufferedImage imagen = ImageIO.read(new File(path));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(imagen, path.substring(path.length() - 3), baos);
            return baos.toByteArray();
        } catch (IOException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static GregorianCalendar dateToGC(java.util.Date date) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        return cal;
    }

    public static java.sql.Date gcToDate(GregorianCalendar date) {
        if (date != null) {
            return new java.sql.Date(date.getTimeInMillis());
        } else {
            return null;
        }
    }
}