package util;
import org.dizitart.no2.Nitrite;

import java.io.File;
public class Lib {
	public static class Platform {

        public static Nitrite db = Nitrite.builder().openOrCreate();

        public static void persist() { db = Nitrite.builder().filePath(new File(Paths.DB_LOC)).openOrCreate(); }
        public static void commit() { db.commit(); }

    }

    public static class Paths {
        public static final String DB_LOC = "C:\\Users\\kmt\\Desktop\\swproject\\res\\db\\swdb.nitdb";
    }

}
