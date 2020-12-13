import java.util.ArrayList;

public class Globals {
    static Disk external_disk = new Disk();
    static Disk working_disk = new Disk();
    static Directory directory = new Directory();
    static String osErrMsg = "";
    static String diskErrMsg = "";
    public static Boolean fs_booted = false;
    public static Boolean fs_is_available = false;
    public static Boolean external_disk_exists = true;
    public static Boolean working_disk_exists = true;
    public static Boolean external_disk_image_exists = false;
    public static Boolean working_disk_image_exists = false;

    static final int NUM_SECTORS = 1000;
    static final int SECTOR_SIZE = 512;

    public static String tempBuffer = "";

    public Globals()
    {

    }
}
