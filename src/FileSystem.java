import java.util.ArrayList;

public class FileSystem {
    public Globals global = new Globals();

    public int size = 0;
    public static int max_file_size = 0;
    public static Boolean is_open = false;
    public static int current_read_pointer = 0;
    public static int current_write_pointer = 0;
    public static int fd = 0;
    public static String value = "";
    public static int location = 0;
    public static String type = "";

    int FS_Boot()
    {
        if (global.fs_booted)
        {
            global.osErrMsg = "E_FILE_BOOT";
            return -1;
        }
        else {
            if (global.external_disk_image_exists) {
                global.fs_booted = true;
                global.fs_is_available = true;
                return 0;
            } else {
                global.external_disk_image_exists = true;
                //Copy external_disk into working_disk
                global.working_disk.file_table = new ArrayList<>();
                for (int i = 0; i < global.external_disk.file_table.size() && global.external_disk.file_table.size() > 0; i++) {
                    global.working_disk.file_table.add(i, global.external_disk.file_table.get(i));
                }
                if (global.working_disk_exists) {
                    global.fs_booted = true;
                    global.fs_is_available = true;
                    return 0;
                } else {
                    global.osErrMsg = "E_FILE_BOOT";
                    return -1;
                }
            }
        }
    }


    int FS_Sync()
    {
        if (global.fs_is_available)
        {
            //Copy working_disk contents into external_disk
            global.external_disk.file_table = new ArrayList<>();
            for (int i = 0; i < global.working_disk.file_table.size() && global.working_disk.file_table.size() > 0; i++)
            {
                global.external_disk.file_table.add(i, global.working_disk.file_table.get(i));
            }
            return 0;
        } else {
            return -1;
        }
    }


    int FS_Reset() {
        int result = FS_Sync();
        if (result == 0)
        {
            global.fs_is_available = false;
            global.fs_booted = false;
            return 0;
        } else {
            global.osErrMsg = "E_FILE_RESET";
            return -1;
        }
    }



}
