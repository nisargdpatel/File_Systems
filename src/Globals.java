import java.util.ArrayList;

public class Globals {
    static Disk external_disk = new Disk();
    static Disk working_disk = new Disk();
    static Directory directory = new Directory();
    static String osErrMsg = "";
    static String diskErrMsg = "";
    public static Boolean fs_booted = false;
    public static Boolean fs_is_available = false;
    public static Boolean external_disk_exists = false;
    public static Boolean working_disk_exists = false;
    public static ArrayList<Files> file_table = new ArrayList<>();

    public Globals()
    {

    }
}
